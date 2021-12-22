package ru.netology.web.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;
import ru.netology.web.data.DataHelper;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage { // Страница личного кабинета
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private ElementsCollection cards = $$(".list__item"); // где list__item - элемент строки содержащий **** **** **** 0001, баланс: 10000 р. + кнопку
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";


    public DashboardPage() {
        heading.shouldBe(visible); // заголовок страницы (Личный кабинет) должен быть виден
    }

    public int getFirstCardBalance() {
        val text = cards.first().text(); // метод text возвращает текст элемента **** **** **** 0001, баланс: 10000 р. + кнопку
        return extractBalance(text);
    }

    private int extractBalance(String text) { // Извлечение баланса из текста элемента
        val start = text.indexOf(balanceStart); // indexOf - возвращает позицию, с которой начинается подстрока в строке
        val finish = text.indexOf(balanceFinish); // indexOf - возвращает позицию, с которой начинается подстрока в строке
        val value = text.substring(start + balanceStart.length(), finish); // substring - вырезает подстроку из строки
        return Integer.parseInt(value);
    }

    public int getSecondCardBalance() {
        val text = cards.last().text(); // метод text возвращает текст элемента **** **** **** 0001, баланс: 10000 р. + кнопку
        return extractBalance(text);
    }

    public TransferPage chooseCard(DataHelper.CardInfo cardInfo) { // запрашиваем инфу у DataHelper
        cards.findBy(text(cardInfo.getCardNumber())).find("[data-test-id=action-deposit]").click(); // обращаемся к полю cards вызываем у него метод поиска
        return new TransferPage(); // возвражается страница Личного кабинета
    }
}