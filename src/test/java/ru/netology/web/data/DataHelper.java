package ru.netology.web.data;

import lombok.Value;

public class DataHelper {
    private DataHelper() {}

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }
    //@Value - аннотация Lombok, дает возможность с помощью аннотации создавать те самые Value Objects.
    //Генерирует для объекта конструктор, методы toString()/equals()/hashCode()

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }

    @Value
    public static class BalanceFirstCard {
        private String numberCard1;
        private int balanceCard1;
    }

    public static BalanceFirstCard getBalanceFirstCardFor(AuthInfo authInfo) {
        return new BalanceFirstCard("5559 0000 0000 0001", 10_000);
    }

    @Value
    public static class BalanceSecondCard {
        private String numberCard2;
        private int balanceCard2;
    }

    public static BalanceSecondCard getBalanceSecondCardFor(AuthInfo authInfo) {
        return new BalanceSecondCard("5559 0000 0000 0002", 10_000);
    }
}