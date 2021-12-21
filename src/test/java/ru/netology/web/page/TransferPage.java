package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class TransferPage { // Страница перевода средств
    private SelenideElement amountField = $("[data-test-id=amount] input");
    private SelenideElement fromField = $("[data-test-id=from] input");
    private SelenideElement topUpButton = $("[data-test-id=action-transfer]");

    public TransferPage() {
        amountField.shouldBe(visible); // заголовок страницы (Пополнение карты) должен быть виден
    }

    public DashboardPage updateBalance() { // запрашиваем инфу у DataHelper
        amountField.setValue() // пополняем первую значит переводим со второй на первую
        fromField.setValue()
        topUpButton.click();
        return new DashboardPage();
    }
}