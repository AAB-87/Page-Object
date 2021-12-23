package ru.netology.web.test;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.DashboardPage;
import ru.netology.web.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.web.data.DataHelper.getFirstCardNumber;
import static ru.netology.web.data.DataHelper.getSecondCardNumber;

class MoneyTransferTest {

    @BeforeEach
    void setUp() {
        open("http://localhost:9999"); // открываем необходимую страницу
        val loginPage = new LoginPage(); // создаём переменную и инициализируем её новым объектом
        val authInfo = DataHelper.getAuthInfo(); // получаем информацию для авторизации для передачи её новому объекту (возвращает authInfo)
        val verificationPage = loginPage.validLogin(authInfo); // у переменной LoginPage вызывваем метод и передаём туда инфу для авторизации (возвращает verificationPage)
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);
    }

    @Test
    void transactionFromSecondToFirstCard() {
        // var - ключевое слово в Java, которое позволяет не писать тип для переменной.
        val dashboardPage = new DashboardPage(); // создаём новый объект
        int amountValue = 2500; // указываем сумму
        val expectedResultSecondCard = dashboardPage.getSecondCardBalance() - amountValue; // отнимаем из общей суммы на второй карте 2500 руб
        val expectedResultFirstCard = dashboardPage.getFirstCardBalance() + amountValue; // прибавляем к общей сумме первой карты 2500 руб
        val transferPage = dashboardPage.firstCardDeposit(); // кликаем на кнопку Пополнить
        transferPage.updateBalance(amountValue, DataHelper.getSecondCardNumber()); // выполняем перевод с одной карты на другую
        val actualResultsFirstCard = dashboardPage.getFirstCardBalance(); // запрашиваем баланс первой карты после перевода средств
        val actualResultsSecondCard = dashboardPage.getSecondCardBalance(); // запрашиваем баланс второй карты после перевода средств
        assertEquals(expectedResultFirstCard, actualResultsFirstCard); // сравниваем ОР и ФР
        assertEquals(expectedResultSecondCard, actualResultsSecondCard); // сравниваем ОР и ФР
    }

    @Test
    void transactionFromFirstToSecondCard() {
        // var - ключевое слово в Java, которое позволяет не писать тип для переменной.
        val dashboardPage = new DashboardPage(); // создаём новый объект
        int amountValue = 3000; // указываем сумму
        val expectedResultFirstCard = dashboardPage.getFirstCardBalance() - amountValue; // отнимаем из общей суммы на первой карте 30000 руб
        val expectedResultSecondCard = dashboardPage.getSecondCardBalance() + amountValue; // прибавляем к общей сумме второй карты 3000 руб
        val transferPage = dashboardPage.secondCardDeposit(); // кликаем на кнопку Пополнить
        transferPage.updateBalance(amountValue, DataHelper.getFirstCardNumber()); // выполняем перевод с одной карты на другую
        val actualResultsFirstCard = dashboardPage.getFirstCardBalance(); // запрашиваем баланс первой карты после перевода средств
        val actualResultsSecondCard = dashboardPage.getSecondCardBalance(); // запрашиваем баланс второй карты после перевода средств
        assertEquals(expectedResultFirstCard, actualResultsFirstCard); // сравниваем ОР и ФР
        assertEquals(expectedResultSecondCard, actualResultsSecondCard); // сравниваем ОР и ФР
    }
}

