package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class TransferPage { // Страница перевода средств
    private SelenideElement amountField = $("[data-test-id=amount] input"); // находим поле Сумма
    private SelenideElement fromField = $("[data-test-id=from] input"); // находим поле Откуда
    private SelenideElement topUpButton = $("[data-test-id=action-transfer]"); // находим кнопку Пополнить

    public TransferPage() {
        amountField.shouldBe(visible); // поле ввода суммы страницы должно быть видно
    }

    public DashboardPage updateBalance(int amountValue, DataHelper.CardInfo cardInfo) {
        amountField.setValue(String.valueOf(amountValue)); // вписываем сумму
        fromField.setValue(cardInfo.getCardNumber()); // вписываем номер карты
        topUpButton.click(); // кликаем по кнопке Попоплнить
        return new DashboardPage(); // возвращаемся в Личный кабинет (суммы на картых изменились)
    }
}