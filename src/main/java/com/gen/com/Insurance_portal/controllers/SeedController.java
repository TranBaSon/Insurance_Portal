package com.gen.com.Insurance_portal.controllers;

import com.gen.com.Insurance_portal.common.constanst.ClaimsCode;
import com.gen.com.Insurance_portal.common.enums.*;
import com.gen.com.Insurance_portal.entites.*;
import com.gen.com.Insurance_portal.entites.ProductCategory;
import com.gen.com.Insurance_portal.services.*;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@Hidden
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/seed")
public class SeedController {

    private final IRoleService roleService;
    private final IFAQService faqService;
    private final IProductCategoryService productCategoryService;
    private final IAuthoritiesGroupService authoritiesGroupService;
    private final IAuthoritiesService authoritiesService;
    private final PasswordEncoder passwordEncoder;
    private final IUserService userService;
    private final ISysAdminService sysAdminService;
    private final IPartnerService partnerService;
    private final IProductService productService;

    public SeedController(IRoleService roleService, IFAQService faqService,
                          IProductCategoryService productCategoryService,
                          IAuthoritiesGroupService authoritiesGroupService,
                          IAuthoritiesService authoritiesService,
                          PasswordEncoder passwordEncoder,
                          IUserService userService,
                          ISysAdminService sysAdminService, IPartnerService partnerService, IProductService productService) {

        this.roleService = roleService;
        this.faqService = faqService;
        this.productCategoryService = productCategoryService;
        this.authoritiesGroupService = authoritiesGroupService;
        this.authoritiesService = authoritiesService;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.sysAdminService = sysAdminService;
        this.partnerService = partnerService;
        this.productService = productService;
    }

    @GetMapping
    public String hello() {
        return "Welcome to here!";
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/role")
    public String seedRole() {


        List<Authorities> authorities = authoritiesService.findAll();

        Role admin = roleService.save(new Role("admin role", "ADMIN", authorities));
        Role customer = roleService.save(new Role("customer role", "CUSTOMER"));


        User user = new User();
        user.setGivenName("admin");
        user.setSurname("admin");
        user.setRole(admin);
        user.setEmail("admin@gmail.com");
        user.setUsername("admin");
        user.setPassword(passwordEncoder.encode("Admin@12345"));
        user.setGender(Gender.NONE);
        user.setIsActive(true);
        user.setFromLegacySystem(true);
        User newUser = userService.save(user);

        SysAdmin sysAdmin = new SysAdmin();
        sysAdmin.setUser(user);
        sysAdmin.setIsActive(true);
        sysAdmin.setType(SysAdminType.ADMIN);
        sysAdminService.save(sysAdmin);

        return "seed succeed!";
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/common")
    public String seedFAQ() {

        ProductCategory pc1 = new ProductCategory("Bảo hiểm sức khỏe", "Bảo hiểm sức khỏe");
        ProductCategory pc2 = new ProductCategory("Bảo hiểm du lịch", "Bảo hiểm du lịch");
        ProductCategory pc3 = new ProductCategory("Bảo hiểm tài sản", "Bảo hiểm tài sản");
        ProductCategory pc4 = new ProductCategory("Bảo hiểm xe", "Bảo hiểm xe");

        List<ProductCategory> productCategories = Arrays.asList(pc1, pc2, pc3, pc4);
        List<ProductCategory> productCategories1 = productCategoryService.saveAll(productCategories);

        FAQ faq1 = new FAQ("Những trường hợp nào khách hàng tham gia bảo hiểm sẽ không được bồi thường?", "Trong thực tế, tất cả các yêu cầu thanh toán quyền lợi bảo hiểm theo đúng quy định tại quy tắc điều khoản sản phẩm bảo hiểm đều được các công ty bảo hiểm chấp thuận chi trả đầy đủ và nhanh chóng. Tuy nhiên, trên cơ sở tuân thủ luật pháp và đảm bảo công bằng cho tất cả khách hàng tham gia bảo hiểm, đồng thời để bảo hiểm nhân thọ không trở thành một phương tiện đầu cơ trục lợi, cũng có những trường hợp các công ty bảo hiểm buộc phải từ chối thanh toán quyền lợi bảo hiểm.", true);
        FAQ faq2= new FAQ("Điều kiện để được tham gia bảo hiểm nhân thọ là gì?", "Khách hàng chỉ cần ở trong độ tuổi có thể được bảo hiểm (có quy định trong từng sản phẩm cụ thể), có tình trạng sức khỏe phù hợp với tiêu chuẩn thẩm định của công ty bảo hiểm, và có khả năng đóng phí bảo hiểm là có thể tham gia bảo hiểm nhân thọ.", true );
        FAQ faq3= new FAQ("Sản phẩm bảo hiểm nhân thọ nào là tốt nhất?", "Chúng tôi cho rằng, sản phẩm tốt nhất là sản phẩm phù hợp nhất với nhu cầu và khả năng tài chính vào từng thời kỳ của mỗi khách hàng. Điều này có nghĩa là một sản phẩm có thể được coi là tốt nhất với khách hàng này chưa chắc đã tốt nhất với khách hàng khác; hoặc một sản phẩm có thể là phù hợp nhất với khách hàng tại giai đoạn này, nhưng đến một giai đoạn khác trong cuộc sống, khách hàng có thể cần thêm một sản phẩm khác nữa để đáp ứng tốt hơn nhu cầu đã thay đổi của mình. Nhưng nhìn chung, tất cả các sản phẩm bảo hiểm nhân thọ đều góp phần giúp bạn an tâm hơn trước những rủi ro trong cuộc sống và thực hiện được các kế hoạch tài chính ngắn hạn cũng như dài hạn của mình. Các Đại lý bảo hiểm/Chuyên viên hoạch định tài chính của AIA Việt Nam sẽ hỗ trợ bạn lựa chọn giải pháp bảo hiểm phù hợp nhất với nhu cầu của bạn và gia đình.", true );
        FAQ faq4= new FAQ("Bảo hiểm nhân thọ có lợi ích gì đối với xã hội, với nền kinh tế?", "Bảo hiểm nhân thọ (BHNT) mang lại nhiều lợi ích to lớn cho xã hội, cho nền kinh tế của một quốc gia. BHNT hỗ trợ tạo dựng sự ổn định xã hội thông qua việc đảm bảo an toàn tài chính và qua đó giảm thiểu tối đa sự lo lắng cho khách hàng tham gia bảo hiểm, BHNT giúp giảm gánh nặng ngân sách quốc gia trong việc chăm lo người già, và những người phụ thuộc khi người trụ cột trong gia đình không may qua đời, BHNT giúp tạo công ăn việc làm ổn định với thu nhập thỏa đáng cho rất nhiều người, BHNT giúp huy động vốn để đầu tư cho những dự án trung và dài hạn nhằm góp phần phát triển đất nước.", true );
        FAQ faq5= new FAQ("Khách hàng cần phải có tối thiểu bao nhiêu tiền để tham gia Bảo hiểm Nhân thọ?", "Số tiền khách hàng cần có để đóng phí bảo hiểm tùy thuộc vào rất nhiều yếu tố, như sản phẩm bảo hiểm mà khách hàng tham gia, thời hạn bảo hiểm, số tiền bảo hiểm, tuổi và tình trạng sức khỏe của khách hàng khi tham gia bảo hiểm… Tuy nhiên, theo quy định hiện nay của AIA Việt Nam, khách hàng chỉ cần tối thiểu khoảng 14.000 đồng/ngày (5 triệu đồng /năm) là đã có thể tham gia các giải pháp bảo hiểm của AIA. Với khoản tiết kiệm này, tùy thuộc vào thời gian tích lũy, mục tiêu bảo hiểm, các Đại lý bảo hiểm chuyên nghiệp của AIA sẽ hỗ trợ bạn lựa chọn sản phẩm và số tiền được bảo hiểm tương ứng để giúp bạn có giải pháp bảo hiểm phù hợp nhất.", true );

        List<FAQ> faqs = Arrays.asList(faq1, faq2, faq3, faq4, faq5);
        faqService.saveAll(faqs);

        Partner partner = new Partner();
        partner.setAppellation("MR.");
        partner.setCode("PRUU");
        partner.setEmail("prudential@gmail.com");
        partner.setContact("2");
        partner.setHotline("1");
        partner.setIntroductionContent("Prudential");
        partner.setIntroductionContent("Prudential");
        partner.setName("Prudential");
        partner.setPhoneNumber("0383860666");
        partner.setStatus(PartnerStatus.APPROVED);

        Partner partnerResult = partnerService.save(partner);

        Product product = new Product();
        product.setEffectiveDateRangeSelectionNumber(0);
        product.setAvatarImage("https://res.cloudinary.com/dmhmclzpm/image/upload/v1609757301/image_tceti6.png");
        product.setBannerImage("https://res.cloudinary.com/dmhmclzpm/image/upload/v1609757254/banner_vn7lnt.png");
        product.setCode("BHOT");
        product.setDetailedDescription("Chỉ với mức phí từ 1.300 đồng/ngày, quyền lợi lên đến 200 triệu đồng, bảo hiểm ô tô bắt buộc là một trong các giấy tờ xe luôn phải mang theo khi tham gia giao thông. Người điều khiển xe sẽ bị phạt từ 400.000 – 600.000 đồng khi không có bảo hiểm bắt buộc ô tô hoặc bảo hiểm đã hết hạn. Với ViettelPay, khách hàng có thêm lựa chọn để mở rộng quyền lợi bảo hiểm cho người ngồi trên xe lên đến 80 triêu đồng, với mức phí tăng thêm chỉ từ 40.000 đồng/năm. ");
        product.setEffectiveDateType(EffectiveDateType.T);
        product.setFeeType(FeeType.FIXED);
        product.setGenderApply(GenderApply.ALL);
        product.setShortDescription("https://res.cloudinary.com/dmhmclzpm/image/upload/v1609757613/insurance_lljsqd.png");
        product.setName("Bảo hiểm xe ô tô");
        product.setPriceObj(200000000.);
        product.setProductStatus(ProductStatus.APPROVED);
        product.setPartner(partnerResult);
        product.setProductCategory(productCategories1.get(3));
        productService.save(product);

        return "seed succeed!";
    }



    @PreAuthorize("permitAll()")
    @RequestMapping("/authorities")
    public String seedAuthorities() {

        Role admin = roleService.save(new Role("admin role", "ADMIN"));
        admin.setActive(true);
        roleService.save(new Role("customer role", "CUSTOMER"));


        User user = new User();
        user.setGivenName("admin");
        user.setSurname("admin");
        user.setRole(admin);
        user.setEmail("admin@gmail.com");
        user.setUsername("admin");
        user.setPassword(passwordEncoder.encode("Admin@12345"));
        user.setGender(Gender.NONE);
        user.setIsActive(true);
        user.setFromLegacySystem(true);
        User newUser = userService.save(user);

        SysAdmin sysAdmin = new SysAdmin();
        sysAdmin.setUser(user);
        sysAdmin.setIsActive(true);
        sysAdmin.setType(SysAdminType.ADMIN);
        sysAdminService.save(sysAdmin);

        AuthoritiesGroup productGroup = authoritiesGroupService.save(new AuthoritiesGroup("Sản phẩm"));

        // Sản phẩm
        Authorities a1 = new Authorities(ClaimsCode.ProductCreate, "Khai báo sản phẩm", productGroup);
        Authorities a2 = new Authorities(ClaimsCode.ProductEdit, "sửa thông tin sản phẩm", productGroup);
        Authorities a3 = new Authorities(ClaimsCode.ProductStatus, "Active / Deactive sản phẩm", productGroup);
        Authorities a4 = new Authorities(ClaimsCode.ProductApprovement, "Duyệt thông tin sản pphẩm", productGroup);
        Authorities a5 = new Authorities(ClaimsCode.ProductList, "Xem danh sách sản phẩm", productGroup);
        Authorities a6 = new Authorities(ClaimsCode.ProductDetail, "Xem chi tiết sản phẩm", productGroup);
        Authorities a69 = new Authorities(ClaimsCode.ProductDelete, "Xoá sản phẩm", productGroup);

        List<Authorities> productAuthorities = Arrays.asList(a1, a2, a3, a4, a5, a6, a69);
        admin.getAuthorities().addAll(productAuthorities);
        authoritiesService.saveAll(productAuthorities);


        //---------------------------------------------------------------------------------------------->



        AuthoritiesGroup attributeGroup = authoritiesGroupService.save(new AuthoritiesGroup("Thuộc tính"));

        // Thuộc tính
        Authorities a7 = new Authorities(ClaimsCode.AttributeCreate, "thêm thuộc tính", attributeGroup);
        Authorities a8 = new Authorities(ClaimsCode.AttributeEdit, "sửa thuộc tính", attributeGroup);
        Authorities a9 = new Authorities(ClaimsCode.AttributeStatus, "Active / Deactive thuộc tính", attributeGroup);
        Authorities a10 = new Authorities(ClaimsCode.AttributeList, "xem danh sách thuộc tính", attributeGroup);
        Authorities a11 = new Authorities(ClaimsCode.AttributeDetail, "xem chi tiết thuộc tính", attributeGroup);

        List<Authorities> attributeAuthorities = Arrays.asList(a7, a8, a9, a10, a11);
        admin.getAuthorities().addAll(attributeAuthorities);
        authoritiesService.saveAll(attributeAuthorities);


        //---------------------------------------------------------------------------------------------->


        AuthoritiesGroup customerGroup = authoritiesGroupService.save(new AuthoritiesGroup("Khách hàng"));

        // Khách hàng
        Authorities a12 = new Authorities(ClaimsCode.CustomerList, "xem danh sách khách hàng", customerGroup);
        Authorities a67 = new Authorities(ClaimsCode.CustomerDetail, "xem chi tiết khách hàng", customerGroup);
        List<Authorities> customerAuthorities = Arrays.asList(a12, a67);
        admin.getAuthorities().addAll(customerAuthorities);
        authoritiesService.saveAll(customerAuthorities);


        //---------------------------------------------------------------------------------------------->


        // Đối tác:
        AuthoritiesGroup partnersGroup = authoritiesGroupService.save(new AuthoritiesGroup("Đối tác"));

        // --> đối tác

        AuthoritiesGroup partnerGroup = authoritiesGroupService.save(new AuthoritiesGroup("đối tác", partnersGroup));

        Authorities a13 = new Authorities(ClaimsCode.PartnerCreate, "khai báo đối tác", partnerGroup);
        Authorities a14 = new Authorities(ClaimsCode.PartnerEdit, "sửa thông tin đối tác", partnerGroup);
        Authorities a15 = new Authorities(ClaimsCode.PartnerStatus, "Active / Deactive đối tác", partnerGroup);
        Authorities a16 = new Authorities(ClaimsCode.PartnerApprovement, "duyệt thông tin đối tác", partnerGroup);
        Authorities a17 = new Authorities(ClaimsCode.PartnerList, "xem danh sách đối tác", partnerGroup);
        Authorities a68 = new Authorities(ClaimsCode.PartnerDetail, "xem chi tiết đối tác", partnerGroup);

        List<Authorities> partnerAuthorities = Arrays.asList(a13, a14, a15, a16, a17, a68);
        admin.getAuthorities().addAll(partnerAuthorities);
        authoritiesService.saveAll(partnerAuthorities);


        // --> số hợp đồng

        AuthoritiesGroup contractNumberGroup = authoritiesGroupService.save(new AuthoritiesGroup("số hợp đồng", partnersGroup));
        Authorities a18 = new Authorities(ClaimsCode.ContractNumberCreate, "tạo số hợp đồng", contractNumberGroup);
        Authorities a19 = new Authorities(ClaimsCode.ContractNumberEdit, "sửa thông tin số hợp đồng", contractNumberGroup);
        Authorities a20 = new Authorities(ClaimsCode.ContractNumberList, "xem danh sách số hợp đồng", contractNumberGroup);

        List<Authorities> contractNumberAuthorities = Arrays.asList(a18, a19, a20);
        admin.getAuthorities().addAll(contractNumberAuthorities);
        authoritiesService.saveAll(contractNumberAuthorities);


        //---------------------------------------------------------------------------------------------->


        AuthoritiesGroup contactGroup = authoritiesGroupService.save(new AuthoritiesGroup("Hợp đồng"));

        // Hợp đồng
        Authorities a21 = new Authorities(ClaimsCode.ContractRequest, "yêu cầu điều chỉnh bồi thường",contactGroup);
        Authorities a22 = new Authorities(ClaimsCode.ContractCompensation, "bồi thường", contactGroup);
        Authorities a23 = new Authorities(ClaimsCode.ContractRefuse, "từ chối bồi thường", contactGroup);
        Authorities a24 = new Authorities(ClaimsCode.ContractList, "xem danh sách hợp đồng", contactGroup);

        List<Authorities> contactAuthorities = Arrays.asList(a21, a22, a23, a24);
        admin.getAuthorities().addAll(contactAuthorities);
        authoritiesService.saveAll(contactAuthorities);


        //---------------------------------------------------------------------------------------------->


        AuthoritiesGroup roleGroup = authoritiesGroupService.save(new AuthoritiesGroup("Phân quyền"));

        // Phân quyền
        Authorities a25 = new Authorities(ClaimsCode.RoleCreate, "thiết lập nhóm quyền", roleGroup);
        Authorities a26 = new Authorities(ClaimsCode.RoleEdit, "chỉnh sửa nhóm quyền", roleGroup);
        Authorities a27 = new Authorities(ClaimsCode.RoleList, "xem danh sách nhóm quyền", roleGroup);
        Authorities a28 = new Authorities(ClaimsCode.RoleStatus, "Active / Deactive nhóm quyền", roleGroup);
        Authorities a29 = new Authorities(ClaimsCode.RoleDetail, "xem chi tiết nhóm quyền", roleGroup);

        List<Authorities> roleAuthorities = Arrays.asList(a25, a26, a27, a28, a29);
        admin.getAuthorities().addAll(roleAuthorities);
        authoritiesService.saveAll(roleAuthorities);


        //---------------------------------------------------------------------------------------------->


        AuthoritiesGroup articleGroup = authoritiesGroupService.save(new AuthoritiesGroup("Tin bài"));

        // Tin bài
        Authorities a30 = new Authorities(ClaimsCode.ArticleCreate, "thêm tin bài", articleGroup);
        Authorities a31 = new Authorities(ClaimsCode.ArticleEdit, "sửa tin bài", articleGroup);
        Authorities a32 = new Authorities(ClaimsCode.ArticleList, "xem danh sách tin bài", articleGroup);
        Authorities a33 = new Authorities(ClaimsCode.ArticleStatus, "Active / Deactive tin bài", articleGroup);
        Authorities a34 = new Authorities(ClaimsCode.ArticleDetail, "xem chi tiết tin bài", articleGroup);

        List<Authorities> articleAuthorities = Arrays.asList(a30, a31, a32, a33, a34);
        admin.getAuthorities().addAll(articleAuthorities);
        authoritiesService.saveAll(articleAuthorities);


        //---------------------------------------------------------------------------------------------->


        AuthoritiesGroup faqGroup = authoritiesGroupService.save(new AuthoritiesGroup("Câu hỏi thường gặp"));

        // Câu hỏi thường gặp
        Authorities a35 = new Authorities(ClaimsCode.FAQCreate, "thêm câu hỏi thường gặp", faqGroup);
        Authorities a36 = new Authorities(ClaimsCode.FAQEdit, "sửa câu hỏi thường gặp", faqGroup);
        Authorities a37 = new Authorities(ClaimsCode.FAQList, "xem danh sách câu hỏi thường gặp", faqGroup);
        Authorities a38 = new Authorities(ClaimsCode.FAQStatus, "Active / Deactive câu hỏi thường gặp", faqGroup);
        Authorities a39 = new Authorities(ClaimsCode.FAQDetail, "xem chi tiết câu hỏi thường gặp", faqGroup);

        List<Authorities> faqAuthorities = Arrays.asList(a35, a36, a37, a38, a39);
        admin.getAuthorities().addAll(faqAuthorities);
        authoritiesService.saveAll(faqAuthorities);
        //---------------------------------------------------------------------------------------------->


        AuthoritiesGroup historyTransactionGroup = authoritiesGroupService.save(new AuthoritiesGroup("Lịch sử giao dịch"));

        // Lịch sử giao dịch
        Authorities a40 = new Authorities(ClaimsCode.HistoryTransactionList, "xem lịch sử giao dịch", historyTransactionGroup);
        Authorities a41 = new Authorities(ClaimsCode.HistoryTransactionExport, "xuất file lịch sử giao dịch", historyTransactionGroup);

        List<Authorities> historyTransactionAuthorities = Arrays.asList(a40, a41);
        admin.getAuthorities().addAll(historyTransactionAuthorities);
        authoritiesService.saveAll(historyTransactionAuthorities);


        //---------------------------------------------------------------------------------------------->


        AuthoritiesGroup articleCategoryGroup = authoritiesGroupService.save(new AuthoritiesGroup("Quản lý chuyên mục"));

        // Quản lý chuyên mục
        Authorities a42 = new Authorities(ClaimsCode.ArticleCategoryCreate, "thêm chuyển mục", articleCategoryGroup);
        Authorities a43 = new Authorities(ClaimsCode.ArticleCategoryEdit, "sửa chuyên mục", articleCategoryGroup);
        Authorities a44 = new Authorities(ClaimsCode.ArticleCategoryList, "xem danh sách chuyên mục", articleCategoryGroup);
        Authorities a45 = new Authorities(ClaimsCode.ArticleCategoryDetail, "xem chi tiết chuyên mục", articleCategoryGroup);
        Authorities a46 = new Authorities(ClaimsCode.ArticleCategoryStatus, "Active / Deactive chuyên mục", articleCategoryGroup);

        List<Authorities> articleCategoryAuthorities = Arrays.asList(a42, a43, a44, a45, a46);
        admin.getAuthorities().addAll(articleCategoryAuthorities);
        authoritiesService.saveAll(articleCategoryAuthorities);

        //---------------------------------------------------------------------------------------------->



        AuthoritiesGroup productOrderGroup = authoritiesGroupService.save(new AuthoritiesGroup("Sản phẩm nổi bật"));

        // Sản phẩm nổi bật
        Authorities a48 = new Authorities(ClaimsCode.ProductOrderConfig, "quản lý sản phẩm nổi bật", productOrderGroup);
        admin.getAuthorities().add(a48);
        authoritiesService.save(a48);



        //---------------------------------------------------------------------------------------------->

        AuthoritiesGroup rateChargeGroup = authoritiesGroupService.save(new AuthoritiesGroup("Quản lý tỉ lệ phí"));

        // Quản lý tỉ lệ phí
        Authorities a49 = new Authorities(ClaimsCode.RateChargeCreate, "thêm tỉ lệ phí", rateChargeGroup);
        Authorities a50 = new Authorities(ClaimsCode.RateChargeEdit, "sửa tỉ lệ phí", rateChargeGroup);
        Authorities a51 = new Authorities(ClaimsCode.RateChargeList, "xem danh sách tỉ lệ phí", rateChargeGroup);
        Authorities a52 = new Authorities(ClaimsCode.RateChargeDetail, "xem chi tiết tỉ lệ phí", rateChargeGroup);
        Authorities a53 = new Authorities(ClaimsCode.RateChargeStatus, "Active / Deactive tỉ lệ phí", rateChargeGroup);

        List<Authorities> rateChargeAuthorities = Arrays.asList(a49, a50, a51, a52, a53);
        admin.getAuthorities().addAll(rateChargeAuthorities);
        authoritiesService.saveAll(rateChargeAuthorities);

        //---------------------------------------------------------------------------------------------->


        AuthoritiesGroup orderPendingGroup = authoritiesGroupService.save(new AuthoritiesGroup("Đơn hàng chờ thanh toán"));

        // Đơn hàng chờ thanh toán
        Authorities a55 = new Authorities(ClaimsCode.OrderPendingList, "xem danh sách đơn hàng chờ thanh toán", orderPendingGroup);
        Authorities a56 = new Authorities(ClaimsCode.OrderPendingDetail, "xem chi tiết đơn hàng chờ thanh toán", orderPendingGroup);
        Authorities a57 = new Authorities(ClaimsCode.OrderPendingCreatePolicy, "tạo hợp đồng cho đơn hàng chờ thanh toán", orderPendingGroup);

        List<Authorities> orderPendingAuthorities = Arrays.asList(a55, a56, a57);
        admin.getAuthorities().addAll(orderPendingAuthorities);
        authoritiesService.saveAll(orderPendingAuthorities);


        //---------------------------------------------------------------------------------------------->



        AuthoritiesGroup targetGroupGroup = authoritiesGroupService.save(new AuthoritiesGroup("Nhóm đối tượng"));

        // Nhóm đối tượng
        Authorities a58 = new Authorities(ClaimsCode.TargetGroupCreate, "tạo mới nhóm đối tượng", targetGroupGroup);
        Authorities a59 = new Authorities(ClaimsCode.TargetGroupEdit, "sửa nhóm đối tượng", targetGroupGroup);
        Authorities a60 = new Authorities(ClaimsCode.TargetGroupList, "xem danh sách nhóm đối tượng", targetGroupGroup);
        Authorities a61 = new Authorities(ClaimsCode.TargetGroupDetail, "xem chi tiết nhóm đối tượng", targetGroupGroup);
        Authorities a62 = new Authorities(ClaimsCode.TargetGroupStatus, "Active / Deactive nhóm đối tượng", targetGroupGroup);

        List<Authorities> targetGroupAuthorities = Arrays.asList(a58, a59, a60, a61, a62);
        admin.getAuthorities().addAll(targetGroupAuthorities);
        authoritiesService.saveAll(targetGroupAuthorities);


        //---------------------------------------------------------------------------------------------->


        AuthoritiesGroup promoGroup = authoritiesGroupService.save(new AuthoritiesGroup("Mã khuyến mãi"));

        // Mã khuyến mãi
        Authorities a63 = new Authorities(ClaimsCode.PromoCreate, "tạo mã khuyến mãi", promoGroup);
        Authorities a64 = new Authorities(ClaimsCode.PromoEdit, "sửa mã khuyến mãi", promoGroup);
        Authorities a65 = new Authorities(ClaimsCode.PromoIndex, "xem danh sách mã khuyến mãi", promoGroup);

        List<Authorities> promoAuthorities = Arrays.asList(a63, a64, a65);
        admin.getAuthorities().addAll(promoAuthorities);
        authoritiesService.saveAll(promoAuthorities);



        //---------------------------------------------------------------------------------------------->


        AuthoritiesGroup siteConfigGroup = authoritiesGroupService.save(new AuthoritiesGroup("Cấu hình cho website"));

        // Cấu hình cho website
        Authorities a66 = new Authorities(ClaimsCode.SiteConfigIndex, "cấu hình cho website", siteConfigGroup);
        admin.getAuthorities().add(a66);
        authoritiesService.save(a66);

        roleService.update(admin);


        return "seed succeed!";
    }

}
