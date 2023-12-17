package home.amit.springboot.app.service;
/*
User :- AmitSingh
Date :- 12/17/2023
Time :- 4:13 PM
Year :- 2023
*/

public class Utility {

    private String privateMethod(String message) {
        return message;
    }

    public String callPrivateMethod(String message) {
        return privateMethod(message);
    }
}