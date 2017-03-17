package com.hjy.oa.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.core.Logger;
import org.junit.Test;

/**
 * Created by sheeran on 2017/3/17.
 */
public class TestLog {
    private static Log logger = LogFactory.getLog(Test.class);
    @Test
    public void testLog(){
        // 记录debug级别的信息
        logger.debug("This is debug message.");
        // 记录info级别的信息
        logger.info("This is info message.");
        logger.warn("this is warn message");
        // 记录error级别的信息
        logger.error("This is error message.");
    }
}
