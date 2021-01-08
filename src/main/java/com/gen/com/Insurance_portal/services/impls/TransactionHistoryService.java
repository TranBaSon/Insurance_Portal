package com.gen.com.Insurance_portal.services.impls;

import com.gen.com.Insurance_portal.common.Helpper;
import com.gen.com.Insurance_portal.common.enums.*;
import com.gen.com.Insurance_portal.common.enums.PaymentMethod;
import com.gen.com.Insurance_portal.common.mappers.TransactionHistoryMapper;
import com.gen.com.Insurance_portal.entites.*;
import com.gen.com.Insurance_portal.exceptions.MessageException;
import com.gen.com.Insurance_portal.exceptions.NotFoundEntityException;
import com.gen.com.Insurance_portal.exceptions.NotFoundEntityExceptionByCode;
import com.gen.com.Insurance_portal.models.RequestModels.ParamsModel;
import com.gen.com.Insurance_portal.models.RequestModels.TransactionHistoryModel;
import com.gen.com.Insurance_portal.repositories.TransactionHistoryRepository;
import com.gen.com.Insurance_portal.services.*;
import com.gen.com.Insurance_portal.utils.Utils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TransactionHistoryService extends AbstractService<TransactionHistory> implements ITransactionHistoryService {
    private final TransactionHistoryRepository transactionHistoryRepository;
    private final ICustomerService customerService;
    private final IPartnerService partnerService;
    private final IProductService productService;
    private final IConstractService contractService;

    public TransactionHistoryService(TransactionHistoryRepository transactionHistoryRepository,
                                     CustomerService customerService, IPartnerService partnerService,
                                     IProductService productService, IConstractService contractService) {
        super(transactionHistoryRepository);
        this.transactionHistoryRepository = transactionHistoryRepository;
        this.customerService = customerService;
        this.partnerService = partnerService;
        this.productService = productService;
        this.contractService = contractService;
    }

    @Override
    public void create(TransactionHistoryModel transactionHistoryModel) {

        Product product = productService.findById(transactionHistoryModel.getProductId())
                .orElseThrow(() -> new NotFoundEntityException(transactionHistoryModel.getProductId(), "Product"));

        Partner partner = partnerService.findById(transactionHistoryModel.getPartnerId())
                .orElseThrow(() -> new NotFoundEntityException(transactionHistoryModel.getPartnerId(), "Partner"));

        Customer customer = customerService.findById(transactionHistoryModel.getCustomerId())
                .orElseThrow(() -> new NotFoundEntityException(transactionHistoryModel.getCustomerId(), "Customer"));

        Contract contract = new Contract();
        String contractCode = Helpper.genContractCode(partner.getCode());
        while (contractService.existsByCode(contractCode)){
            contractCode = Helpper.genContractCode(partner.getCode());
        }
        contract.setCode(contractCode);
        contract.setPhoneNumber(transactionHistoryModel.getPhoneNumber());
        contract.setCustomer(customer);
        contract.setCustomerCode(customer.getCustomerCode());
        contract.setEmail(transactionHistoryModel.getEmail());
        contract.setAddress(transactionHistoryModel.getAddress());
        contract.setBuyerIdNumber(customer.getUser().getIdNumber());
        contract.setGender(customer.getUser().getGender().toString());
        contract.setDob(customer.getUser().getDod());
        contract.setFullName(transactionHistoryModel.getName());
        contract.setPaidAmount(transactionHistoryModel.getPrice());
        contract.setCreatedContractDate(new Date());
        contract.setPurchaseMethod(PurchaseMethod.Paypal);
        contract.setIdNumber(customer.getUser().getIdNumber());
        contract.setNumberPlate(transactionHistoryModel.getNumberPlate());
        contract.setCarBrand(transactionHistoryModel.getCarBrand());
        contract.setCarMaker(transactionHistoryModel.getCarMaker());
        contract.setPartner(partner.getName());
        contract.setPartnerCode(partner.getCode());
        contract.setProduct(product.getName());
        contract.setProductCode(product.getCode());

        Date activeDate = new Date();
        if (product.getEffectiveDateType().equals(EffectiveDateType.NONE) ||
                product.getEffectiveDateType().equals(EffectiveDateType.T1ToTx)) {
                LocalDate localDate = LocalDate.now().plusDays(product.getEffectiveDateRangeSelectionNumber());
                activeDate = java.util.Date.from(localDate.atStartOfDay()
                        .atZone(ZoneId.systemDefault())
                        .toInstant());

                contract.setStatus(ContractStatus.Inactive);
        }
        if (product.getEffectiveDateType().equals(EffectiveDateType.T1)) {
            LocalDate localDate = LocalDate.now().plusDays(1);
            activeDate = java.util.Date.from(localDate.atStartOfDay()
                    .atZone(ZoneId.systemDefault())
                    .toInstant());
            contract.setStatus(ContractStatus.Inactive);
        }

        LocalDate localDate = LocalDate.now().plusYears(1);
        Date expiredDate = java.util.Date.from(localDate.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());

        contract.setExtendSuccessDate(activeDate);
        contract.setActiveDate(activeDate);
        contract.setExpiredDate(expiredDate);
        contract.setStatus(ContractStatus.Inactive);
        contract.setEffectiveDate(activeDate);
        Contract contractResult = contractService.save(contract);

        TransactionHistory transactionHistory = new TransactionHistory();
        transactionHistory.setTransactionCode(Utils.generateRandomUuid());
        transactionHistory.setTransactionDate(new Date());
        transactionHistory.setPaymentMethod(PaymentMethod.Paypal);
        transactionHistory.setAmount(transactionHistoryModel.getPrice());
        transactionHistory.setCustomerCode(customer.getCustomerCode());
        transactionHistory.setCustomerPhoneNumber(transactionHistoryModel.getPhoneNumber());
        transactionHistory.setCustomer(customer);
        transactionHistory.setProductName(product.getName());
        transactionHistory.setProductCode(product.getCode());
        transactionHistory.setPartnerName(partner.getName());
        transactionHistory.setPartnerCode(partner.getCode());
        transactionHistory.setContractCode(contract.getCode());
        transactionHistory.setTransactionStatus(TransactionStatus.Success);
        transactionHistory.setContract(contractResult);
        transactionHistory.setProcessName(TransactionProcessName.BuyNew);
        transactionHistory.setEffectiveDate(contract.getEffectiveDate());
        transactionHistory.setExpiredDate(contract.getExpiredDate());

        transactionHistoryRepository.save(transactionHistory);

    }

    @Override
    public TransactionHistory findByTransactionCode(String code) {
        TransactionHistory transactionHistory = transactionHistoryRepository.findByTransactionCode(code)
                .orElseThrow(() -> new NotFoundEntityExceptionByCode(code, "TransactionHistory"));
        return transactionHistory ;
    }

    @Override
    public Object getList(ParamsModel paramsModel, Boolean forUser) {
        try {
            int page = 0;
            if (paramsModel.getPageNumber() >= 1) {
                page = paramsModel.getPageNumber() - 1;
            }
            List<Sort.Order> orders = new ArrayList<Sort.Order>();

            if (paramsModel.getSort()[0].contains(",")) {
                // will sort more than 2 fields
                // sortOrder="field, direction"
                for (String sortOrder : paramsModel.getSort()) {
                    String[] _sort = sortOrder.split(",");
                    orders.add(new Sort.Order(Utils.getSortDirection(_sort[1]), _sort[0]));
                }
            } else {
                // sort=[field, direction]
                orders.add(new Sort.Order(Utils.getSortDirection(paramsModel.getSort()[1]), paramsModel.getSort()[0]));
            }

            Pageable pagingSort = PageRequest.of(page, paramsModel.getPageSize(), Sort.by(orders));

            Page<TransactionHistory> pageTuts;
            if (paramsModel.getFilter() == null){
                pageTuts = findAll(pagingSort);
            } else {
                pageTuts = transactionHistoryRepository.findAllByContractCode(paramsModel.getFilter(), pagingSort);
            }

            Object responseData;

            if (forUser){
                responseData = pageTuts.getContent().stream()
                        .map(TransactionHistoryMapper.INSTANCE::TransactionHistoryToTransactionHistoryModel)
                        .collect(Collectors.toList());
            }else {
                responseData = pageTuts.getContent();
            }


            Map<String, Object> response = new HashMap<>();
            response.put("data", responseData);
            response.put("currentPage", paramsModel.getPageNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return response;

        } catch (Exception e) {
            throw  new MessageException("Error server.");
        }
    }
}
