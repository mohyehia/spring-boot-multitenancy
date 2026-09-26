package com.moh.yehia.multitenancy.resolver;

import jakarta.servlet.http.HttpServletRequest;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HttpHeaderTenantResolver implements TenantResolver<HttpServletRequest> {

    @Value("${multi-tenancy.http.header-name:X-Tenant-ID}")
    private String tenantHeaderName;

    @Override
    public String resolveTenantId(@NonNull HttpServletRequest httpServletRequest) {
        return httpServletRequest.getHeader(tenantHeaderName);
    }
}
