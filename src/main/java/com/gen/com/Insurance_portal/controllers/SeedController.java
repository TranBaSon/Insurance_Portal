package com.gen.com.Insurance_portal.controllers;

import com.gen.com.Insurance_portal.entites.FAQ;
import com.gen.com.Insurance_portal.entites.ProductCategory;
import com.gen.com.Insurance_portal.entites.Role;
import com.gen.com.Insurance_portal.services.IFAQService;
import com.gen.com.Insurance_portal.services.IProductCategoryService;
import com.gen.com.Insurance_portal.services.IRoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/seed")
public class SeedController {

    private final IRoleService roleService;
    private final IFAQService faqService;
    private final IProductCategoryService productCategoryService;

    public SeedController(IRoleService roleService, IFAQService faqService,
                          IProductCategoryService productCategoryService) {

        this.roleService = roleService;
        this.faqService = faqService;
        this.productCategoryService = productCategoryService;
    }

    @GetMapping("/role")
    public String seedRole() {

        Role admin = new Role("admin role", "ADMIN");
        Role customer = new Role("customer role", "CUSTOMER");
        List<Role> roles = Arrays.asList(admin, customer);

        roleService.saveAll(roles);

        return "seed succeed!";
    }

    @GetMapping("/common")
    public String seedFAQ() {

        ProductCategory pc1 = new ProductCategory("Bảo hiểm sức khỏe");
        ProductCategory pc2 = new ProductCategory("Bảo hiểm du lịch");
        ProductCategory pc3 = new ProductCategory("Bảo hiểm tài sản");
        ProductCategory pc4 = new ProductCategory("Bảo hiểm xe");

        List<ProductCategory> productCategories = Arrays.asList(pc1, pc2, pc3, pc4);
        productCategoryService.saveAll(productCategories);

        FAQ faq1 = new FAQ("Những trường hợp nào khách hàng tham gia bảo hiểm sẽ không được bồi thường?", "Trong thực tế, tất cả các yêu cầu thanh toán quyền lợi bảo hiểm theo đúng quy định tại quy tắc điều khoản sản phẩm bảo hiểm đều được các công ty bảo hiểm chấp thuận chi trả đầy đủ và nhanh chóng. Tuy nhiên, trên cơ sở tuân thủ luật pháp và đảm bảo công bằng cho tất cả khách hàng tham gia bảo hiểm, đồng thời để bảo hiểm nhân thọ không trở thành một phương tiện đầu cơ trục lợi, cũng có những trường hợp các công ty bảo hiểm buộc phải từ chối thanh toán quyền lợi bảo hiểm.", true);
        FAQ faq2= new FAQ("Điều kiện để được tham gia bảo hiểm nhân thọ là gì?", "Khách hàng chỉ cần ở trong độ tuổi có thể được bảo hiểm (có quy định trong từng sản phẩm cụ thể), có tình trạng sức khỏe phù hợp với tiêu chuẩn thẩm định của công ty bảo hiểm, và có khả năng đóng phí bảo hiểm là có thể tham gia bảo hiểm nhân thọ.", true );
        FAQ faq3= new FAQ("Sản phẩm bảo hiểm nhân thọ nào là tốt nhất?", "Chúng tôi cho rằng, sản phẩm tốt nhất là sản phẩm phù hợp nhất với nhu cầu và khả năng tài chính vào từng thời kỳ của mỗi khách hàng. Điều này có nghĩa là một sản phẩm có thể được coi là tốt nhất với khách hàng này chưa chắc đã tốt nhất với khách hàng khác; hoặc một sản phẩm có thể là phù hợp nhất với khách hàng tại giai đoạn này, nhưng đến một giai đoạn khác trong cuộc sống, khách hàng có thể cần thêm một sản phẩm khác nữa để đáp ứng tốt hơn nhu cầu đã thay đổi của mình. Nhưng nhìn chung, tất cả các sản phẩm bảo hiểm nhân thọ đều góp phần giúp bạn an tâm hơn trước những rủi ro trong cuộc sống và thực hiện được các kế hoạch tài chính ngắn hạn cũng như dài hạn của mình. Các Đại lý bảo hiểm/Chuyên viên hoạch định tài chính của AIA Việt Nam sẽ hỗ trợ bạn lựa chọn giải pháp bảo hiểm phù hợp nhất với nhu cầu của bạn và gia đình.", true );
        FAQ faq4= new FAQ("Bảo hiểm nhân thọ có lợi ích gì đối với xã hội, với nền kinh tế?", "Bảo hiểm nhân thọ (BHNT) mang lại nhiều lợi ích to lớn cho xã hội, cho nền kinh tế của một quốc gia. BHNT hỗ trợ tạo dựng sự ổn định xã hội thông qua việc đảm bảo an toàn tài chính và qua đó giảm thiểu tối đa sự lo lắng cho khách hàng tham gia bảo hiểm, BHNT giúp giảm gánh nặng ngân sách quốc gia trong việc chăm lo người già, và những người phụ thuộc khi người trụ cột trong gia đình không may qua đời, BHNT giúp tạo công ăn việc làm ổn định với thu nhập thỏa đáng cho rất nhiều người, BHNT giúp huy động vốn để đầu tư cho những dự án trung và dài hạn nhằm góp phần phát triển đất nước.", true );
        FAQ faq5= new FAQ("Khách hàng cần phải có tối thiểu bao nhiêu tiền để tham gia Bảo hiểm Nhân thọ?", "Số tiền khách hàng cần có để đóng phí bảo hiểm tùy thuộc vào rất nhiều yếu tố, như sản phẩm bảo hiểm mà khách hàng tham gia, thời hạn bảo hiểm, số tiền bảo hiểm, tuổi và tình trạng sức khỏe của khách hàng khi tham gia bảo hiểm… Tuy nhiên, theo quy định hiện nay của AIA Việt Nam, khách hàng chỉ cần tối thiểu khoảng 14.000 đồng/ngày (5 triệu đồng /năm) là đã có thể tham gia các giải pháp bảo hiểm của AIA. Với khoản tiết kiệm này, tùy thuộc vào thời gian tích lũy, mục tiêu bảo hiểm, các Đại lý bảo hiểm chuyên nghiệp của AIA sẽ hỗ trợ bạn lựa chọn sản phẩm và số tiền được bảo hiểm tương ứng để giúp bạn có giải pháp bảo hiểm phù hợp nhất.", true );

        List<FAQ> faqs = Arrays.asList(faq1, faq2, faq3, faq4, faq5);
        faqService.saveAll(faqs);

        return "seed succeed!";
    }
}
