package com.gen.com.Insurance_portal.services.impls;

import com.gen.com.Insurance_portal.common.mappers.ProductProviderMapper;
import com.gen.com.Insurance_portal.entites.Partner;
import com.gen.com.Insurance_portal.exceptions.MessageException;
import com.gen.com.Insurance_portal.exceptions.NotFoundEntityException;
import com.gen.com.Insurance_portal.models.RequestModels.CreatePartnerModel;
import com.gen.com.Insurance_portal.models.RequestModels.UpdateProductProviderModel;
import com.gen.com.Insurance_portal.repositories.PartnerRepository;
import com.gen.com.Insurance_portal.services.IPartnerService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

@Service
public class PartnerService extends AbstractService<Partner> implements IPartnerService {

    private final PartnerRepository partnerRepository;

    public PartnerService(PartnerRepository partnerRepository) {
        super(partnerRepository);
        this.partnerRepository = partnerRepository;
    }


    @Override
    public void save(CreatePartnerModel productProviderModel) {
        Partner provider = ProductProviderMapper.INSTANCE
                                   .createProductProviderModelToProductProvider(productProviderModel);


        Boolean existsByNameOrCode = partnerRepository
                .existsByNameOrCode(productProviderModel.getName(), productProviderModel.getCode());

        if (existsByNameOrCode) {
            throw new MessageException("Name or code already exists.");
        }

        this.save(provider);
    }


    @Override
    public void update(UpdateProductProviderModel productProviderModel, Long id) {
        Partner partner = this.findById(id)
                .orElseThrow(() -> new NotFoundEntityException(id, "Partner"));

        Boolean existsByNameOrCodeAndIdNot = partnerRepository
                .existsByNameOrCodeAndIdNot(productProviderModel.getName(), productProviderModel.getCode(), partner.getId());

        if (existsByNameOrCodeAndIdNot) {
            throw new MessageException("Name or code already exists.");
        }

        if (!Strings.isBlank(productProviderModel.getCode())) {
            partner.setCode(productProviderModel.getCode());
        }
        if (!Strings.isBlank(productProviderModel.getAppellation())) {
            partner.setAppellation(productProviderModel.getAppellation());
        }
        if (!Strings.isBlank(productProviderModel.getImages())) {
            partner.setAvatarImage(productProviderModel.getImages());
        }
        if (!Strings.isBlank(productProviderModel.getContact())) {
            partner.setContact(productProviderModel.getContact());
        }
        if (!Strings.isBlank(productProviderModel.getHotline())) {
            partner.setHotline(productProviderModel.getHotline());
        }
        if (!Strings.isBlank(productProviderModel.getName())) {
            partner.setName(productProviderModel.getName());
        }
        if (!Strings.isBlank(productProviderModel.getPhoneNumber())) {
            partner.setPhoneNumber(productProviderModel.getPhoneNumber());
        }
        if (!Strings.isBlank(productProviderModel.getPhoneNumber())) {
            partner.setPhoneNumber(productProviderModel.getPhoneNumber());
        }

        this.update(partner);
    }

    @Override
    public void toggleStatus(Long id) {
        Partner provider = this.findById(id)
                .orElseThrow(() -> new NotFoundEntityException(id, "Partner"));
        provider.setIsActive(!provider.getIsActive());
        update(provider);
    }

}
