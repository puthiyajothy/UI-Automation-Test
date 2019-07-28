package com.test.qa.pageobjects.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.test.qa.pageobjects.utils.PageBase;

/**
 * DropDownPage.java - class to verify DropDown Page functions Created by
 * SrirankanK on 10/3/2018.
 */
public class DropDownPage extends PageBase {

    private static By dropdown = By.id("dropdown");
    private static By clickLink = By.xpath("//*[text()=\"Dropdown\"]");

    public static boolean isDropDownDisplayed() {
        return getDriver().findElement(dropdown).isDisplayed();

    }
    public static void dropdownlink() {
        getDriver().findElement(clickLink).click();
    }
    public static String getSelectedOption(String option1) {
        Select dropDownOption = new Select(getDriver().findElement(dropdown));
        return dropDownOption.getFirstSelectedOption().getText();
    }

}
