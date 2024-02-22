package actions.risefairsketch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import actions.commons.AbstractPage;
import interfaces.risefairsketch.ProjectsPageInterfaces;

public class ProjectsPage extends AbstractPage{
    WebDriver driver;

    public ProjectsPage(WebDriver driver_) {
        driver = driver_;
    }
    public void clickAddProject(){clickToElement(driver, ProjectsPageInterfaces.BTN_ADDPROJECT);}

    public void selectValueInDropdownlist(String combobox, String value) {
        clickToElement(driver, ProjectsPageInterfaces.DROPDOWNLISTS, combobox);
        clickToElement(driver, ProjectsPageInterfaces.OPTIONS, value);
    }

    public void selectValueInCombobox(String combobox, String value) {
        clickToElement(driver, ProjectsPageInterfaces.COMBOBOX, combobox);
        clickToElement(driver, ProjectsPageInterfaces.OPTIONS, value);
    }
    public void inputAllInformation(String title, String ProjectType , String ValueProjectType , String Description, String startDate, String deadLine,String Price, String ValueLabels, String ValueOfClient) {

        WebElement txbTitle = findAnElement(driver, ProjectsPageInterfaces.TXB_TITLE);
        WebElement description = findAnElement(driver, ProjectsPageInterfaces.TXA_DESCRIPTION);
        WebElement startdate = findAnElement(driver, ProjectsPageInterfaces.TXB_STARTDATE);
        WebElement deadline = findAnElement(driver, ProjectsPageInterfaces.TXB_DEADLINE);
        WebElement price = findAnElement(driver, ProjectsPageInterfaces.TXB_PRICE);
        WebElement save = findAnElement(driver, ProjectsPageInterfaces.BTN_SAVE);

        System.out.println("Input Title data");
        txbTitle.sendKeys(title);

        System.out.println("Select Project type with value Internal Project");
        selectValueInDropdownlist("Project type", ValueProjectType);

        if (ValueLabels == "Client Project"){
            System.out.println("Select Client with value Demo Client");
            selectValueInDropdownlist("Client", ValueOfClient);
        }

        System.out.println("Input Description data");
        description.sendKeys(Description);


        System.out.println("Enter Start date");
        startdate.sendKeys(startDate);

        System.out.println("Enter Deadline");
        deadline.sendKeys(deadLine);

        System.out.println("Enter Price");
        price.sendKeys(Price);

        System.out.println("Select Labels with value white");
        selectValueInCombobox("Labels", ValueLabels);

        System.out.println("Click Save");
        save.click();
    }
}