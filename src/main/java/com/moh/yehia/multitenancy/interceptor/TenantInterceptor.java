package com.moh.yehia.multitenancy.interceptor;

import com.moh.yehia.multitenancy.resolver.HttpHeaderTenantResolver;
import com.moh.yehia.multitenancy.resolver.TenantContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class TenantInterceptor implements HandlerInterceptor {
    private final HttpHeaderTenantResolver tenantResolver;

    public TenantInterceptor(HttpHeaderTenantResolver tenantResolver) {
        this.tenantResolver = tenantResolver;
    }

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) throws Exception {
        var tenantId = tenantResolver.resolveTenantId(request);
        TenantContext.setTenant(tenantId);
        return true;
    }

    @Override
    public void postHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        TenantContext.clear();
    }

    @Override
    public void afterCompletion(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler, @Nullable Exception ex) throws Exception {
        TenantContext.clear();
    }
}
