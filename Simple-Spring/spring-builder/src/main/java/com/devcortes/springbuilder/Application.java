package com.devcortes.springbuilder;

import java.util.Map;

public class Application {

    public static ApplicationContext run(String scanPackage, Map<Class, Class> ifc2ImplClass) {
        JavaConfig javaConfig = new JavaConfig(scanPackage, ifc2ImplClass);
        ApplicationContext applicationContext = new ApplicationContext(javaConfig);
        ObjectFactory objectFactory = new ObjectFactory(applicationContext);
        applicationContext.setObjectFactory(objectFactory);
        return applicationContext;
    }
}
