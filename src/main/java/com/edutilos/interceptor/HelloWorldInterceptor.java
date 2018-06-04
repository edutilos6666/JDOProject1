package com.edutilos.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Created by edutilos on 30/08/2016.
 */
public class HelloWorldInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        Logger logger = LogManager.getLogger(HelloWorldInterceptor.class);
        System.out.println("Pre-Processing");
        logger.info("Pre-Processing");
        logger.debug("Pre-Processing");
        logger.warn("Pre-Processing");
        logger.error("Pre-Processing");
        String result = invocation.invoke();
        System.out.println("Post-Processing");
        logger.info("Post-Processing");
        logger.debug("Post-Processing");
        logger.warn("Post-Processing");
        logger.error("Post-Processing");
        return result;
    }
}
