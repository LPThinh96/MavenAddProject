package actions.commons;

import org.testng.annotations.DataProvider;

public class DataProviderFactory {

	@DataProvider(name = "accountTestRisefairketch")
	public static Object[][] dataTest() {
		return new Object[][] { { "admin@demo.com", "riseDemo" }, { "client@demo.com", "riseDemo" } };
	}

    @DataProvider(name = "inputInformationAddProject")
    public static Object[][] dataTest1() {
        return new Object[][]{{"abc", "Internal Project", "Description", " 12-03-2023",
				"11-04-2023", "3000", "white", "Demo Client"}};
    }

}
