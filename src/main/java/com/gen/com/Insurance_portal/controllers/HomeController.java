package com.gen.com.Insurance_portal.controllers;

import com.gen.com.Insurance_portal.services.IRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/home")
public class HomeController {

    private final IRoleService roleService;

    public HomeController(IRoleService roleService) {
        this.roleService = roleService;
    }


    @RequestMapping("swagger")
    public String home() {
        return "redirect:/swagger-ui.html";
    }

    @RequestMapping
    public String hello() {
        return "Welcome to here!";
    }



//    @RequestMapping("/seed/authorities")
//    public String seedAuthorities() {
//
//        // Sản phẩm
//        Authorities a1 = new Authorities(ClaimsCode.ProductCreate, "Khai báo sản phẩm");
//        Authorities a2 = new Authorities(ClaimsCode.ProductEdit, "sửa thông tin sản phẩm");
//        Authorities a3 = new Authorities(ClaimsCode.ProductStatus, "Active / Deactive sản phẩm");
//        Authorities a4 = new Authorities(ClaimsCode.ProductApprovement, "Duyệt thông tin sản p sản phẩm");
//        Authorities a5 = new Authorities(ClaimsCode.ProductList, "Xem danh sách sản phẩm");
//        Authorities a6 = new Authorities(ClaimsCode.ProductList, "Xem chi tiết sản phẩm");
//
//
//
//
//
//        return "seed succeed!";
//    }
//
//    @RequestMapping("/seed/role")
//    public String seedFAQ() {
//
//        Role admin = new Role("admin role", "ADMIN");
//        Role customer = new Role("customer role", "CUSTOMER");
//        List<Role> roles = Arrays.asList(admin, customer);
//
//        roleService.saveAll(roles);
//        return "seed succeed!";
//    }



}
