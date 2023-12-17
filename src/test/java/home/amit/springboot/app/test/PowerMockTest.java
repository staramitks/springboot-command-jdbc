package home.amit.springboot.app.test;
/*
User :- AmitSingh
Date :- 12/17/2023
Time :- 4:15 PM
Year :- 2023
*/

import home.amit.springboot.app.service.Utility;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Utility.class)
public class PowerMockTest {

    @Test
    @SneakyThrows
    public void TestStaticMethod_WithPowerMockito()  {

        String message = " PowerMock with Mockito and JUnit ";
        String expectedmessage = " Using with EasyMock ";

        Utility mock =PowerMockito.spy(new Utility());
        PowerMockito.doReturn(expectedmessage).when(mock, "privateMethod", message);

        String actualmessage = mock.callPrivateMethod(message);
        assertEquals(expectedmessage, actualmessage);

        System.out.println(PowerMockito.verifyPrivate(getClass()));
    }
}