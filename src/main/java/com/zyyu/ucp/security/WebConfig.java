package com.zyyu.ucp.security;

import com.zyyu.ucp.resolver.CurrUserArgumentResolver;
import com.zyyu.ucp.utils.FileHandleUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.io.File;
import java.util.List;

/**
 * Web应用配置相关
 */
@Configuration
public class WebConfig<addResourceHandlers> extends WebMvcConfigurationSupport {
    private Logger logger = LoggerFactory.getLogger(WebConfig.class);
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
        registry.addInterceptor(new AdminJwtInterceptor()).addPathPatterns("/admin/**").excludePathPatterns("/admin/login");
        registry.addInterceptor(new AccountJwtInterceptor()).addPathPatterns("/account/**");
    }

    /**
     * 配置自定义参数解析器
     * @param argumentResolvers
     */
    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new CurrUserArgumentResolver());
    }

    /**
     * 一旦使用了WebMvcConfigurationSupport（或WebMvcConfigurerAdapter）
     * 那么必须要重写addResourceHandlers来配置资源映射，
     * 此时application.properties中关于静态资源访问的配置将失效
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        String uploadPath = "file:"+ FileHandleUtil.getUploadPath()+File.separator;
        //配置静态资源处理
        registry.addResourceHandler("/res/**")
                .addResourceLocations("resources/", "static/", "public/","META-INF/resources/")
                .addResourceLocations("classpath:resources/", "classpath:static/","classpath:public/",
                                      "classpath:META-INF/resources/","classpath:upload/")
                .addResourceLocations(uploadPath);
        logger.info("uploadPath="+uploadPath);
    }
}
