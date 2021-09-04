package com.zyyu.ucp.security;

import com.zyyu.ucp.resolver.CurrUserArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * Web应用配置相关
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

     /**
      * 设置允许跨域
      * @param registry
      */
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        System.out.println("cors mapping");
//        //允许全部请求跨域
//        registry.addMapping("/**")
//                .allowedMethods("*")
//                .allowedHeaders("*")
//                .allowCredentials(true)
//                .allowedOriginPatterns("*");
//    }

    /**
     * 将需要登录后才能访问的接口添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtInterceptor()).addPathPatterns("/admin/**");
    }

    /**
     * 配置自定义参数解析器
     * @param argumentResolvers
     */
    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new CurrUserArgumentResolver());
    }
}
