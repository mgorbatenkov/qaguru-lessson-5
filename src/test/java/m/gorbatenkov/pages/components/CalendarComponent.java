package m.gorbatenkov.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        $(String.format(".react-datepicker__day--0%s" +
                ":not(.react-datepicker__day--outside-month)", day)).click();
    }
}
