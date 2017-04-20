package spring.configuration;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.XmlViewResolver;

import controller.DemoInterceptor;

// mvc-servlet.xml
@Configuration
@Configurable
// <context:component-scan base-package="controller" />
@ComponentScan(basePackages = { "controller" })
// <mvc:annotation-driven />
@EnableWebMvc
public class SpringMVCConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    private ServletContext servletContext;

    /*
    // 3.1 之前必需自行設定，3.1 之後可繼承 WebMvcConfigurerAdapter 覆寫想要的方法即可
    @Bean
    public XmlViewResolver viewResolver() {
        return new XmlViewResolver();
    }
     */

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        // <bean class="org.springframework.web.servlet.view.XmlViewResolver" />
        XmlViewResolver viewResolver = new XmlViewResolver();
        Resource location = new ServletContextResource(servletContext, "/WEB-INF/views.xml");
        viewResolver.setLocation(location);
        registry.viewResolver(viewResolver);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // <mvc:interceptors>
        //     <bean class="controller.DemoInterceptor" />
        // </mvc:interceptors>
        registry.addInterceptor(new DemoInterceptor());
    }

}
