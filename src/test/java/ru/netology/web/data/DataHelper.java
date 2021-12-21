package ru.netology.web.data;

import lombok.Value;

public class DataHelper {
    private DataHelper() {}

    @Value
    public static class AuthInfo { // Информация об авторизации
        private String login;
        private String password;
    }
    //@Value - аннотация Lombok, дает возможность с помощью аннотации создавать Value Objects.
    //Генерирует для объекта конструктор, методы toString()/equals()/hashCode()

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    @Value
    public static class VerificationCode { // Код верификации
        private String code;
    }

    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }

    @Value
    public static class Card1 {
        private String numberCard1;
    }

    public static Card1 getFirstCard() {
        return new Card1("5559 0000 0000 0001");
    }

    @Value
    public static class Card2 {
        private String numberCard2;
    }

    public static Card2 getSecondCard() {
        return new Card2("5559 0000 0000 0002");
    }

}