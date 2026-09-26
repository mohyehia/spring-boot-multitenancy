package com.moh.yehia.multitenancy.resolver;

import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class TenantContext {
    private static final Logger log = LoggerFactory.getLogger(TenantContext.class);

    private static final ThreadLocal<String> tenantContext = new InheritableThreadLocal<>();

    public static void setTenant(@NonNull String tenant) {
        log.debug("Setting tenant context to: {}", tenant);
        tenantContext.set(tenant);
    }

    public static String getTenant() {
        return tenantContext.get();
    }

    public static void clear() {
        log.debug("Clearing tenant context");
        tenantContext.remove();
    }
}
