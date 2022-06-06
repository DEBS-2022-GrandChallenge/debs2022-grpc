package org.debs2.group4.grpcclient.config;

import net.devh.boot.grpc.client.interceptor.GrpcGlobalClientInterceptor;
import org.debs2.group4.grpcclient.interceptor.LogGrpcInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Order(Ordered.LOWEST_PRECEDENCE)
@Configuration(proxyBeanMethods = false)
public class GlobalClientInterceptorConfiguration {

    @GrpcGlobalClientInterceptor
    LogGrpcInterceptor logGrpcInterceptor() {
        return new LogGrpcInterceptor();
    }
}
