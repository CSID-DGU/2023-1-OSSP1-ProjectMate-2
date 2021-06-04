package com.AkobotWeb.config.propertiesConfig;

import com.AkobotWeb.config.propertiesConfig.ApplicationContextService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;

/**
 * SMS 서비스 키를 별도의 properties파일에서 관리하도록
 * https://oingdaddy.tistory.com/67 참고
 */

@Slf4j
public class PropertyUtil {
    public static String getProperty(String propertyName) {
        return getProperty(propertyName, null);
    }

    public static String getProperty(String propertyName, String defaultValue) {
        String value = defaultValue;
        ApplicationContext applicationContext = ApplicationContextService.getApplicationContext();
        if (applicationContext.getEnvironment().getProperty(propertyName) == null) {
            log.warn(propertyName + " properties was not loaded.");
        } else {
            value = applicationContext.getEnvironment().getProperty(propertyName).toString();
        }
        return value;
    }
}
