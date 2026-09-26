package com.moh.yehia.multitenancy.resolver;

import org.hibernate.cfg.AvailableSettings;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.hibernate.autoconfigure.HibernatePropertiesCustomizer;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

@Component
public class TenantIdentifierResolver implements CurrentTenantIdentifierResolver<String>, HibernatePropertiesCustomizer {
    @Override
    public String resolveCurrentTenantIdentifier() {
        // return the tenant from the TenantContext, or another schema either provided by postgres like "public" or another created schema if the tenant is not set
        // if using a different database, we can create our custom schema like 'master' or 'main' for the data that is not tenant-specific
        return Objects.requireNonNullElse(TenantContext.getTenant(), "public");
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return false;
    }

    @Override
    public void customize(@NonNull Map<String, Object> hibernateProperties) {
        hibernateProperties.put(AvailableSettings.MULTI_TENANT_IDENTIFIER_RESOLVER, this);
    }
}
