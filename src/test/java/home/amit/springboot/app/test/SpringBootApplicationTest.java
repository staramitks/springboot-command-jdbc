package home.amit.springboot.app.test;

import ch.qos.logback.classic.Level;
import home.amit.springboot.app.dao.ApplicationDAO;
import home.amit.springboot.app.service.ApplicationService;
import home.amit.springboot.app.service.Calculator;
import home.amit.springboot.app.service.MyMessagePrinting;
import home.amit.springboot.app.test.context.datasource.DataSourceContextProvider;
import home.amit.springboot.app.test.context.datasource.TestBaseClass;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
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
@Slf4j
public class SpringBootApplicationTest extends TestBaseClass {


	@Value("${heart.beat.sql}")
	private String heartBeatSQL;


	@Autowired
	Calculator mockCalculator;

	@Autowired
	ApplicationDAO applicationDAO;


	@Autowired
	ApplicationService applicationService;

	MyMessagePrinting myMessagePrinting= new MyMessagePrinting();

	@Test
	@Timeout(100)
	public void testLogMessage(CapturedOutput output) {
		String testStr="Returning Successfully with result of 29";

		Awaitility.await().timeout(20, TimeUnit.SECONDS).untilAsserted(()->Assertions.assertTrue(output.getOut().contains(testStr)));
		Assertions.assertTrue(output.getOut().contains(testStr));
	}


	@Order(2)
	@RepeatedTest(2)
	void service_returning_mocked_data_from_template() {

		assertEquals(29, applicationDAO.isHeartBeating());
	//	assertEquals(2, repetitionInfo.getTotalRepetitions());

	}



	@Test
	@Order(1)
	void test_service_heartbeat_function_invoked() {
		Mockito.verify(applicationDAO, Mockito.atLeastOnce()).isHeartBeating();
	}


	@Test
	public void test_argument_captor() {
		ArgumentCaptor<Double> divisorCaptor1 = ArgumentCaptor.forClass(Double.class);
		ArgumentCaptor<Double> divisorCaptor2 = ArgumentCaptor.forClass(Double.class);
		verify(mockCalculator).divide(divisorCaptor1.capture(), divisorCaptor2.capture());
		Assertions.assertNotNull(divisorCaptor1);
		Assertions.assertNotNull(divisorCaptor2);

	}



}
