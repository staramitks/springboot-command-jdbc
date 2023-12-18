package home.amit.springboot.app.test;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import home.amit.springboot.app.dao.ApplicationDAO;
import home.amit.springboot.app.service.ApplicationService;
import home.amit.springboot.app.service.Calculator;
import home.amit.springboot.app.service.MyMessagePrinting;
import home.amit.springboot.app.test.context.datasource.DataSourceContextProvider;
import home.amit.springboot.app.test.context.datasource.TestBaseClass;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import home.amit.springboot.app.test.logging.MemoryAppender;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.internal.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.any;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;
import java.util.concurrent.TimeUnit;


@SpringBootTest
@ContextConfiguration(classes = {TestContextProvider.class, DataSourceContextProvider.class})
@ExtendWith(OutputCaptureExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@Tag("tyrion-integration-testing")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Slf4j

public class SpringBootApplicationTest extends TestBaseClass {


	@Value("${heart.beat.sql}")
	private String heartBeatSQL;


	@Autowired
	ApplicationDAO applicationDAO;

	@Autowired
	Calculator mockCalculator;

	@Autowired
	ApplicationService applicationService;

	MyMessagePrinting myMessagePrinting= new MyMessagePrinting();


	@Test
	@Timeout(10)
	@Order(1)
	public void testLogMessage(CapturedOutput output) {
		String testStr="Returning Successfully with result of 29";
		//myMessagePrinting.testMessage();
		Awaitility.await().atMost(10,TimeUnit.SECONDS).untilAsserted(()->{Assertions.assertTrue(output.getOut().contains(testStr));});

	}


	@Order(2)
	@RepeatedTest(2)
	void service_returning_mocked_data_from_template() {

		assertEquals(29, applicationDAO.isHeartBeating());
	//	assertEquals(2, repetitionInfo.getTotalRepetitions());

	}
	@Test
	@Disabled
	void testWithCapturedOutput() {
		String testStr="This is the method I want to test";
		System.out.println(memoryAppender.getSize());
		Assertions.assertTrue(memoryAppender.contains(testStr, Level.DEBUG));
	}



	@Test
	@Order(2)
	void test_service_heartbeat_function_invoked() {
		Mockito.verify(applicationDAO, Mockito.atLeastOnce()).isHeartBeating();
	}

	@Test
	public void testDivide() {
		// Create a mock Calculator


		ArgumentCaptor<Double> divisorCaptor1 = ArgumentCaptor.forClass(Double.class);
		ArgumentCaptor<Double> divisorCaptor2 = ArgumentCaptor.forClass(Double.class);

		// Verify that the divide method was called with the expected arguments
		verify(mockCalculator).divide(divisorCaptor1.capture(), divisorCaptor2.capture());

		// Assert on the captured value

		Assertions.assertNotNull(divisorCaptor1);
		Assertions.assertNotNull(divisorCaptor2);

	}


}
