package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class TransferPage { // Страница перевода средств
    private SelenideElement amountField = $("[data-test-id=amount] input");
    private SelenideElement fromField = $("[data-test-id=from] input");
    private SelenideElement topUpButton = $("[data-test-id=action-transfer]");

    public TransferPage() {
        amountField.shouldBe(visible); // поле ввода суммы страницы должно быть видно
    }

    public DashboardPage updateBalance(DataHelper.CardInfo cardNumber , int amount) { // запрашиваем инфу у DataHelper
        amountField.sendKeys(Integer.toString(amount));
        fromField.sendKeys();
        topUpButton.click();
        return new DashboardPage();
    }
}