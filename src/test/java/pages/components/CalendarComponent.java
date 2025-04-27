package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {

        $(".react-datepicker__month-select").selectOption(month);
//        $(".react-datepicker__month-dropdown-container").selectOptionByValue("6");
//        $(".react-datepicker__month-dropdown-container").$(byText("May")).click();
//        $(".react-datepicker__month-dropdown-container").selectOption("July");
//        $(".react-datepicker__year-dropdown-container").$(byText("1903")).click();
        $(".react-datepicker__year-select").selectOption(year);
//        $(".react-datepicker__month-container").$(byText("18")).click();
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();

    }
}
