package home.amit.springboot.app.test.context.datasource;
/*
User :- AmitSingh
Date :- 12/15/2023
Time :- 1:19 PM
Year :- 2023
*/


import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import home.amit.springboot.app.test.logging.MemoryAppender;
import static org.assertj.core.api.Assertions.assertThat;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
public class TestBaseClass {


    public static MemoryAppender memoryAppender;
    private static final Class clazz = home.amit.springboot.app.service.MyMessagePrinting.class;
    @BeforeAll
    static void testMessage()
    {
        Logger logger = (Logger) LoggerFactory.getLogger(clazz);
        memoryAppender = new MemoryAppender();
        memoryAppender.setContext((LoggerContext) LoggerFactory.getILoggerFactory());
        logger.setLevel(Level.DEBUG);
        logger.addAppender(memoryAppender);
        memoryAppender.start();
    }

    @AfterAll
    public static void cleanUp() {
        memoryAppender.reset();
        memoryAppender.stop();
    }
}
