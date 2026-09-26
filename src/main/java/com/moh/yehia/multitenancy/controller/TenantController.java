package com.moh.yehia.multitenancy.controller;

import com.moh.yehia.multitenancy.resolver.TenantContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tenant")
public class TenantController {

    @GetMapping
    public String getTenant() {
        return TenantContext.getTenant();
    }
}
