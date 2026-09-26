# spring-boot-multitenancy

This is a Spring Boot application that demonstrates multitenancy support. It allows you to manage multiple tenants within a single application instance, providing isolation and customization for each tenant.

## Flow
- Tenant resolver: The application identifies the tenant based on the incoming request, using request header.
- Tenant context: Once the tenant is identified, the application sets the tenant context for the current request, ensuring that all subsequent operations are performed within the scope of the identified tenant.
- Tenant interceptor: The application uses a tenant interceptor to intercept incoming requests and extract the tenant information from the request header. This information is then used to set the tenant context for the current request.