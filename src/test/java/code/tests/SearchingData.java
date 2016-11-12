package code.tests;


import org.testng.annotations.DataProvider;

public class SearchingData {

    @DataProvider(name = "SearchByFiltersTest")
    public static Object[][] testingSearchByFilters() {
        return new Object[][] {{"Новые", "Марка", "Jeep", "Кузов", "Внедорожник"},
                               {"С пробегом", "Марка", "Lexus", "Кузов", "Седан"},
                               {"Новые", "Марка", "Jaguar", "Кузов", "Седан"},
                               {"С пробегом", "Марка", "Nissan", "Коробка", "Автомат"}};
    }

}
