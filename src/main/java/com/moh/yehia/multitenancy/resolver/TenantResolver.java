package com.moh.yehia.multitenancy.resolver;

import org.jspecify.annotations.NonNull;

@FunctionalInterface
public interface TenantResolver<T> {
    String resolveTenantId(@NonNull T context);
}
