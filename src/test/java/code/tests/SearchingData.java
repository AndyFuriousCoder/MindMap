package code.tests;


import org.testng.annotations.DataProvider;

public class SearchingData {

    @DataProvider(name = "SearchByFiltersTest")
    public static Object[][] testingSearchByFilters() {
        return new Object[][] {{"Новые", "Марка", "Jeep", "Кузов", "Внедорожник", "Модель", "Cherokee"},
                               {"С пробегом", "Марка", "Lexus", "Кузов", "Седан", "Модель", "GS"},
                               {"Новые", "Марка", "Jaguar", "Кузов", "Седан", "Модель", "XE"},
                               {"С пробегом", "Марка", "Nissan", "Коробка", "Автомат", "Модель", "X-Trail"}};
    }

}
