package com.kitchen.service;

import com.kitchen.configuration.AdminConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;

@Service
public class MailCreatorService {
    @Autowired
    AdminConfig adminConfig;

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    private final String CRUD_URL = "http://localhost:8085/products/exp/today";

    @Autowired
    ProductService productService;

    List<String> productNamesExpiryDateToday = new ArrayList<>();

    private void loadProductNamesExpiryDateToday() {
        productService.getProductsWithExpireDateEndsToday().stream()
                .forEach(p -> productNamesExpiryDateToday.add(p.getName() + " " + p.getQuantity() + " :" + p.getExpiryDate()));
    }
    public void deleteProductNamesExpiryDateToday() {
        productNamesExpiryDateToday.clear();
    }

    public String buildDailyExpiryDateMail(String message) {
        Context context = new Context();
        loadProductNamesExpiryDateToday();
        context.setVariable("message", message);
        context.setVariable("kitchen_url", CRUD_URL);
        context.setVariable("button", "Show products in website");
        context.setVariable("hello_message", "Hello " + adminConfig.getAdminName() + "!");
        context.setVariable("products_exp_end", productNamesExpiryDateToday);
        context.setVariable("goodbye_message", "Have a tasty day " + adminConfig.getAdminName() + "!");
        return templateEngine.process("mail/daily-expiry-date-mail", context);
    }
}
