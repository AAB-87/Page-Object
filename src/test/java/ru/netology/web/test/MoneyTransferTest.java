package ru.netology.web.test;

import lombok.var;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.LoginPage;
import static com.codeborne.selenide.Selenide.open;

class MoneyTransferTest {

    @Test
    void shouldTransferMoneyBetweenOwnCards() {
        open("http://localhost:9999"); // открываем необходимую страницу
        var loginPage = new LoginPage(); // создаём переменную и инициализируем её новым объектом
        var authInfo = DataHelper.getAuthInfo(); // получаем информацию для авторизации для передачи её новому объекту (возвращает authInfo)
        var verificationPage = loginPage.validLogin(authInfo); // у переменной LoginPage вызывваем метод и передаём туда инфу для авторизации (возвращает verificationPage)
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        // var - ключевое слово в Java, которое позволяет вам не писать тип для переменной.
    }

}
