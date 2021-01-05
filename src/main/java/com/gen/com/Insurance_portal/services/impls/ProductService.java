package com.gen.com.Insurance_portal.services.impls;

import com.gen.com.Insurance_portal.common.enums.ProductStatus;
import com.gen.com.Insurance_portal.common.mappers.ProductMapper;
import com.gen.com.Insurance_portal.entites.Partner;
import com.gen.com.Insurance_portal.entites.Product;
import com.gen.com.Insurance_portal.entites.ProductCategory;
import com.gen.com.Insurance_portal.exceptions.MessageException;
import com.gen.com.Insurance_portal.exceptions.NotFoundEntityException;
import com.gen.com.Insurance_portal.exceptions.NotFoundEntityExceptionByCode;
import com.gen.com.Insurance_portal.models.RequestModels.CreateProductModel;
import com.gen.com.Insurance_portal.models.RequestModels.ProductStatusRequest;
import com.gen.com.Insurance_portal.models.RequestModels.UpdateProductModel;
import com.gen.com.Insurance_portal.models.responseModels.ResponseProductModel;
import com.gen.com.Insurance_portal.repositories.ProductRepository;
import com.gen.com.Insurance_portal.services.ICloudinaryService;
import com.gen.com.Insurance_portal.services.IProductCategoryService;
import com.gen.com.Insurance_portal.services.IPartnerService;
import com.gen.com.Insurance_portal.services.IProductService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
public class ProductService extends AbstractService<Product> implements IProductService {
    private final ProductRepository productRepository;
    private final ICloudinaryService cloudinaryService;
    private final IPartnerService productProviderService;
    private final IProductCategoryService productCategoryService;

    public ProductService(ProductRepository productRepository,
                          ICloudinaryService cloudinaryService,
                          IPartnerService productProviderService,
                          IProductCategoryService productCategoryService) {

        super(productRepository);
        this.productRepository = productRepository;
        this.cloudinaryService = cloudinaryService;
        this.productProviderService = productProviderService;
        this.productCategoryService = productCategoryService;
    }

    @Override
    public void create(CreateProductModel productModel) throws ExecutionException, InterruptedException {
        Product product = ProductMapper.INSTANCE.createProductModelToProduct(productModel.getPrimitive());

        Boolean existsByNameOrCode = productRepository.existsByNameOrCode(productModel.getPrimitive().getName(), productModel.getPrimitive().getCode());
        if (existsByNameOrCode) {
            throw new MessageException("Name or code already exists.");
        }

        CompletableFuture<String> async1 = cloudinaryService.uploadAsync(productModel.getAvatarImage());
        CompletableFuture<String> async2 = cloudinaryService.uploadAsync(productModel.getBannerImage());
        CompletableFuture<String> async3 = cloudinaryService.uploadPDFAsync(productModel.getInsuredRule());

        CompletableFuture.allOf(async1, async2, async3).join();

        product.setAvatarImage(async1.get());
        product.setBannerImage(async2.get());
        product.setInsuredRule(async3.get());

        ProductCategory productCategory = productCategoryService.findById(productModel.getPrimitive().getProductCategoryId())
                .orElseThrow(() -> new NotFoundEntityException(productModel.getPrimitive().getProductCategoryId(), "productCategory"));

        Partner provider = productProviderService.findById(productModel.getPrimitive().getPartnerId())
                .orElseThrow(() -> new NotFoundEntityException(productModel.getPrimitive().getPartnerId(), "Partner"));

        product.setProductCategory(productCategory);
        product.setPartner(provider);

        this.save(product);
    }

    @Override
    public void update(UpdateProductModel productModel, Long id) throws ExecutionException, InterruptedException {
        Product product = findById(id).orElseThrow(() -> new NotFoundEntityException(id, "Product"));

        Boolean existsByNameOrCodeAndIdNot = productRepository
                .existsByNameOrCodeAndIdNot(productModel.getPrimitive().getName(), productModel.getPrimitive().getCode(), id);

        if (existsByNameOrCodeAndIdNot) {
            throw new MessageException("Name or code already exists.");
        }

        if (!Strings.isBlank(productModel.getPrimitive().getCode())) {
            product.setCode(productModel.getPrimitive().getCode());
        }
        if (!Strings.isBlank(productModel.getPrimitive().getDetailedDescription())) {
            product.setDetailedDescription(productModel.getPrimitive().getDetailedDescription());
        }
        if (!Strings.isBlank(productModel.getPrimitive().getName())) {
            product.setName(productModel.getPrimitive().getName());
        }
        if (!Strings.isBlank(productModel.getPrimitive().getShortDescription())) {
            product.setShortDescription(productModel.getPrimitive().getShortDescription());
        }
        if (productModel.getPrimitive().getPriceObj() != null) {
            product.setPriceObj(productModel.getPrimitive().getPriceObj());
        }
        if (productModel.getPrimitive().getGenderApply() != null) {
            product.setGenderApply(productModel.getPrimitive().getGenderApply());
        }
        if (productModel.getPrimitive().getProductCategoryId() != null) {
            ProductCategory productCategory = productCategoryService.findById(productModel.getPrimitive().getProductCategoryId())
                    .orElseThrow(() -> new NotFoundEntityException(productModel.getPrimitive().getProductCategoryId(), "productCategory"));
            product.setProductCategory(productCategory);
        }
        if (productModel.getPrimitive().getPartnerId() != null) {
            Partner provider = productProviderService.findById(productModel.getPrimitive().getPartnerId())
                    .orElseThrow(() -> new NotFoundEntityException(productModel.getPrimitive().getPartnerId(), "Partner"));
            product.setPartner(provider);
        }
        if (productModel.getPrimitive().getEffectiveDateRangeSelectionNumber() != null) {
            product.setEffectiveDateRangeSelectionNumber(productModel.getPrimitive().getEffectiveDateRangeSelectionNumber());
        }
        if (productModel.getAvatarImage() != null && productModel.getBannerImage()
                != null && productModel.getInsuredRule() != null) {
            CompletableFuture<String> async1 = cloudinaryService.uploadAsync(productModel.getAvatarImage());
            CompletableFuture<String> async2 = cloudinaryService.uploadAsync(productModel.getBannerImage());
            CompletableFuture<String> async3 = cloudinaryService.uploadPDFAsync(productModel.getInsuredRule());
            CompletableFuture.allOf(async1, async2, async3).join();

            product.setAvatarImage(async1.get());
            product.setBannerImage(async2.get());
            product.setInsuredRule(async3.get());
        }

        if (productModel.getAvatarImage() != null && productModel.getBannerImage() != null ) {
            CompletableFuture<String> async1 = cloudinaryService.uploadAsync(productModel.getAvatarImage());
            CompletableFuture<String> async2 = cloudinaryService.uploadAsync(productModel.getBannerImage());
            CompletableFuture.allOf(async1, async2).join();

            product.setAvatarImage(async1.get());
            product.setBannerImage(async2.get());
        }

        if ( productModel.getBannerImage()
                != null && productModel.getInsuredRule() != null) {
            CompletableFuture<String> async2 = cloudinaryService.uploadAsync(productModel.getBannerImage());
            CompletableFuture<String> async3 = cloudinaryService.uploadPDFAsync(productModel.getInsuredRule());
            CompletableFuture.allOf(async2, async3).join();

            product.setBannerImage(async2.get());
            product.setInsuredRule(async3.get());
        }

        if (productModel.getAvatarImage() != null && productModel.getInsuredRule() != null) {
            CompletableFuture<String> async1 = cloudinaryService.uploadAsync(productModel.getAvatarImage());
            CompletableFuture<String> async3 = cloudinaryService.uploadPDFAsync(productModel.getInsuredRule());
            CompletableFuture.allOf(async1, async3).join();

            product.setAvatarImage(async1.get());
            product.setInsuredRule(async3.get());
        }

        if (productModel.getAvatarImage() != null) {
            CompletableFuture<String> async1 = cloudinaryService.uploadAsync(productModel.getAvatarImage());
            CompletableFuture.allOf(async1).join();

            product.setAvatarImage(async1.get());
        }

        if ( productModel.getBannerImage() != null ) {
            CompletableFuture<String> async2 = cloudinaryService.uploadAsync(productModel.getBannerImage());
            CompletableFuture.allOf(async2).join();

            product.setBannerImage(async2.get());
        }

        if (productModel.getInsuredRule() != null) {
            CompletableFuture<String> async3 = cloudinaryService.uploadPDFAsync(productModel.getInsuredRule());
            CompletableFuture.allOf(async3).join();

            product.setInsuredRule(async3.get());
        }

        update(product);

    }

    @Override
    public Product findByCode(String code) {
        return productRepository.findByCode(code)
                .orElseThrow(() -> new NotFoundEntityExceptionByCode(code, "Product"));
    }

    @Override
    public List<ResponseProductModel> getList() {
        return productRepository.findProductsByProductStatus(ProductStatus.APPROVED).stream()
                .map(ProductMapper.INSTANCE::ProductModelToProductResponse).collect(Collectors.toList());
    }

    @Override
    public void updateByCode(UpdateProductModel productModel, String code) throws ExecutionException, InterruptedException {
        Product product = productRepository.findByCode(code)
                .orElseThrow(() -> new NotFoundEntityExceptionByCode(code, "Product"));

        Boolean existsByNameOrCodeAndIdNot = productRepository
                .existsByNameOrCodeAndIdNot(productModel.getPrimitive().getName(), productModel.getPrimitive().getCode(), product.getId());

        if (existsByNameOrCodeAndIdNot) {
            throw new MessageException("Name or code already exists.");
        }

        if (!Strings.isBlank(productModel.getPrimitive().getCode())) {
            product.setCode(productModel.getPrimitive().getCode());
        }
        if (!Strings.isBlank(productModel.getPrimitive().getDetailedDescription())) {
            product.setDetailedDescription(productModel.getPrimitive().getDetailedDescription());
        }
        if (!Strings.isBlank(productModel.getPrimitive().getName())) {
            product.setName(productModel.getPrimitive().getName());
        }
        if (!Strings.isBlank(productModel.getPrimitive().getShortDescription())) {
            product.setShortDescription(productModel.getPrimitive().getShortDescription());
        }
        if (productModel.getPrimitive().getPriceObj() != null) {
            product.setPriceObj(productModel.getPrimitive().getPriceObj());
        }
        if (productModel.getPrimitive().getGenderApply() != null) {
            product.setGenderApply(productModel.getPrimitive().getGenderApply());
        }
        if (productModel.getPrimitive().getProductCategoryId() != null) {
            ProductCategory productCategory = productCategoryService.findById(productModel.getPrimitive().getProductCategoryId())
                    .orElseThrow(() -> new NotFoundEntityException(productModel.getPrimitive().getProductCategoryId(), "productCategory"));
            product.setProductCategory(productCategory);
        }
        if (productModel.getPrimitive().getPartnerId() != null) {
            Partner provider = productProviderService.findById(productModel.getPrimitive().getPartnerId())
                    .orElseThrow(() -> new NotFoundEntityException(productModel.getPrimitive().getPartnerId(), "Partner"));
            product.setPartner(provider);
        }
        if (productModel.getPrimitive().getEffectiveDateRangeSelectionNumber() != null) {
            product.setEffectiveDateRangeSelectionNumber(productModel.getPrimitive().getEffectiveDateRangeSelectionNumber());
        }
        if (productModel.getAvatarImage() != null && productModel.getBannerImage()
                != null && productModel.getInsuredRule() != null) {
            CompletableFuture<String> async1 = cloudinaryService.uploadAsync(productModel.getAvatarImage());
            CompletableFuture<String> async2 = cloudinaryService.uploadAsync(productModel.getBannerImage());
            CompletableFuture<String> async3 = cloudinaryService.uploadPDFAsync(productModel.getInsuredRule());
            CompletableFuture.allOf(async1, async2, async3).join();

            product.setAvatarImage(async1.get());
            product.setBannerImage(async2.get());
            product.setInsuredRule(async3.get());
        }

        if (productModel.getAvatarImage() != null && productModel.getBannerImage() != null ) {
            CompletableFuture<String> async1 = cloudinaryService.uploadAsync(productModel.getAvatarImage());
            CompletableFuture<String> async2 = cloudinaryService.uploadAsync(productModel.getBannerImage());
            CompletableFuture.allOf(async1, async2).join();

            product.setAvatarImage(async1.get());
            product.setBannerImage(async2.get());
        }

        if ( productModel.getBannerImage()
                != null && productModel.getInsuredRule() != null) {
            CompletableFuture<String> async2 = cloudinaryService.uploadAsync(productModel.getBannerImage());
            CompletableFuture<String> async3 = cloudinaryService.uploadPDFAsync(productModel.getInsuredRule());
            CompletableFuture.allOf(async2, async3).join();

            product.setBannerImage(async2.get());
            product.setInsuredRule(async3.get());
        }

        if (productModel.getAvatarImage() != null && productModel.getInsuredRule() != null) {
            CompletableFuture<String> async1 = cloudinaryService.uploadAsync(productModel.getAvatarImage());
            CompletableFuture<String> async3 = cloudinaryService.uploadPDFAsync(productModel.getInsuredRule());
            CompletableFuture.allOf(async1, async3).join();

            product.setAvatarImage(async1.get());
            product.setInsuredRule(async3.get());
        }

        if (productModel.getAvatarImage() != null) {
            CompletableFuture<String> async1 = cloudinaryService.uploadAsync(productModel.getAvatarImage());
            CompletableFuture.allOf(async1).join();

            product.setAvatarImage(async1.get());
        }

        if ( productModel.getBannerImage() != null ) {
            CompletableFuture<String> async2 = cloudinaryService.uploadAsync(productModel.getBannerImage());
            CompletableFuture.allOf(async2).join();

            product.setBannerImage(async2.get());
        }

        if (productModel.getInsuredRule() != null) {
            CompletableFuture<String> async3 = cloudinaryService.uploadPDFAsync(productModel.getInsuredRule());
            CompletableFuture.allOf(async3).join();

            product.setInsuredRule(async3.get());
        }

        update(product);
    }

    @Override
    public void deleteByCode(String code) {
        Product product = productRepository.findByCode(code)
                .orElseThrow(() -> new NotFoundEntityExceptionByCode(code, "Product"));
        delete(product);
    }

    @Override
    public void status(String code, ProductStatusRequest statusRequest) {
        Product product = productRepository.findByCode(code)
                .orElseThrow(() -> new NotFoundEntityExceptionByCode(code, "Product"));
        product.setProductStatus(statusRequest.getStatus());
        update(product);
    }
}
