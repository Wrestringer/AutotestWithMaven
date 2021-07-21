package com.example;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Condition;

import java.io.File;

public class AppPage {
    
    private String page;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String mobile;
    private String subject1;
    private String subject2;
    private String hobby;
    private String dayOfBirth;
    private String monthOfBirth;
    private String yearOfBirth;
    private String cAddress;
    private String state;
    private String city;
    private File png;

    AppPage(String page, String firstName, String lastName, String email, String gender, String mobile, String subject1, String subject2, String hobby,File png, String dayOfBirth, String monthOfBirth, String yearOfBirth, String cAddres, String state, String city){
        this.setParams(page, firstName, lastName, email, gender, mobile, subject1, subject2, hobby, png, dayOfBirth, monthOfBirth, yearOfBirth, cAddres, state, city);
    }
    
    public void setParams(String page, String firstName, String lastName, String email, String gender, String mobile, String subject1, String subject2, String hobby,File png, String dayOfBirth, String monthOfBirth, String yearOfBirth, String cAddres, String state, String city) {
        this.page = page;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.mobile = mobile;
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.hobby = hobby;
        this.png = png;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.cAddress = cAddres;
        this.state = state;
        this.city = city;
    }

    public void openPage() {
        Selenide.open(page);
    }

    public void fillForm() {
        Selenide.$("#firstName").setValue(firstName);
        Selenide.$("#lastName").setValue(lastName);
        Selenide.$("#userEmail").setValue(email);
        Selenide.$("#genterWrapper").$(Selectors.byText(gender)).click();
        Selenide.$("#userNumber").setValue(mobile);
        Selenide.$("#dateOfBirthInput").click();
        Selenide.$(".react-datepicker__month-select").selectOption(monthOfBirth);
        Selenide.$(".react-datepicker__year-select").selectOption(yearOfBirth);
        Selenide.$(".react-datepicker__day--0" + dayOfBirth).click();
        Selenide.$("#subjectsContainer").click();
        Selenide.$("#subjectsInput").setValue(subject1).pressEnter();
        Selenide.$("#subjectsInput").setValue(subject2).pressEnter();
        Selenide.$("#hobbiesWrapper").$(Selectors.byText(hobby)).click();
        Selenide.$("#uploadPicture").uploadFile(png);
        Selenide.$("#currentAddress").setValue(cAddress);
        Selenide.$("#react-select-3-input").setValue(state).pressEnter();
        Selenide.$("#react-select-4-input").setValue(city).pressEnter();
        Selenide.$("#submit").click();
    }

    public void checkData() {
        Selenide.$(".table-responsive").shouldHave(Condition.text(firstName), Condition.text(lastName), Condition.text(email), Condition.text(mobile), Condition.text(subject1), Condition.text(subject2), Condition.text(hobby), Condition.text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth), Condition.text(png.getName()), Condition.text(cAddress), Condition.text(state), Condition.text(city));
    }
}
