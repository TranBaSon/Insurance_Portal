package com.gen.com.Insurance_portal.services.impls;

import com.gen.com.Insurance_portal.entites.FAQ;
import com.gen.com.Insurance_portal.repositories.FAQRepository;
import com.gen.com.Insurance_portal.services.IFAQService;
import org.springframework.stereotype.Service;

@Service
public class FAQService extends AbstractService<FAQ> implements IFAQService {
    private final FAQRepository faqRepository;

    public FAQService(FAQRepository faqRepository) {
        super(faqRepository);
        this.faqRepository = faqRepository;
    }
}
