package com.example;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.Configuration;

import java.io.File;



class AppTest {

    Faker faker = new Faker();
    File png = new File("src\\test\\resources\\fortest.png");
    AppPage appPage = new AppPage("https://demoqa.com/automation-practice-form", 
    faker.name().firstName(), 
    faker.name().lastName(),
    faker.internet().emailAddress(), 
    "Male",
    faker.number().digits(10), 
    "English", 
    "Physics", 
    "Music", 
    png, 
    "18",
    "May", 
    "1998", 
    faker.address().fullAddress(), 
    "NCR", 
    "Delhi");
    

    @BeforeAll
    static void setap() {
        Configuration.startMaximized = true;
    }

    @Test
    void Test1(){
        appPage.openPage();
        appPage.fillForm();
        appPage.checkData();
    }
}
