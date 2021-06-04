package com.AkobotWeb.config.propertiesConfig;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * SMS 서비스 키를 별도의 properties파일에서 관리하도록
 * https://oingdaddy.tistory.com/67 참고
 */

@Component
public class ApplicationContextService implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        applicationContext = context;
    }

    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }
}
