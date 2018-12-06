package s.s.test;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import s.s.test.config.AppConfig;
import s.s.test.config.WebConfig;
import s.s.test.config.WebSecurityConfig;

public class MainWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppConfig.class, WebSecurityConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
    //implements WebApplicationInitializer {
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//
//        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//        context.scan("s.s.test");
//        servletContext.addListener(new ContextLoaderListener(context));
//        ServletRegistration.Dynamic appServlet = servletContext.addServlet("mvc", new DispatcherServlet(new GenericWebApplicationContext()));
//        appServlet.setLoadOnStartup(1);
//        appServlet.addMapping("/");
//
//    }
}
