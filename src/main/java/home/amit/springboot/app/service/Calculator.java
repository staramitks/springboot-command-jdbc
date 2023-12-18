package home.amit.springboot.app.service;
/*
User :- AmitSingh
Date :- 12/17/2023
Time :- 2:58 PM
Year :- 2023
*/

import org.springframework.stereotype.Component;

@Component
public class Calculator {
    public double divide(double dividend, double divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return dividend / divisor;
    }
}
