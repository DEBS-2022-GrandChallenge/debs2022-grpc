package org.debs2.group4.grpcserver.config;

import org.debs2.group4.grpcserver.interceptor.LogGrpcInterceptor;
import org.springframework.context.annotation.Configuration;

import net.devh.boot.grpc.server.interceptor.GrpcGlobalServerInterceptor;

@Configuration(proxyBeanMethods = false)
public class GlobalInterceptorConfiguration {

    @GrpcGlobalServerInterceptor
    LogGrpcInterceptor logGrpcInterceptor() {
        return new LogGrpcInterceptor();
    }
}
