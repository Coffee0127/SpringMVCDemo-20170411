package spring.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// Spring 由 org.springframework.web.SpringServletContainerInitializer 自動偵測、自動呼叫註冊所需的相關方法
// <load-on-startup>1</load-on-startup>
public class DispatcherServletRegister extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        // 沒有 Root WebApplicationContext
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        //  <init-param>
        //      <param-name>contextConfigLocation</param-name>
        //      <param-value>spring.configuration.SpringMVCConfiguration</param-value>
        //  </init-param>
        return new Class[] { SpringMVCConfiguration.class };
    }

    @Override
    protected String[] getServletMappings() {
        //  <servlet-mapping>
        //      <url-pattern>*.controller</url-pattern>
        //  </servlet-mapping>
        return new String[] { "*.controller" };
    }

}
