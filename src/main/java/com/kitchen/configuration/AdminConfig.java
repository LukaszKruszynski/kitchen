package com.kitchen.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class AdminConfig {
    @Value("${admin.email}")
    private String email;
    @Value("${admin.name}")
    private String adminName;
}
