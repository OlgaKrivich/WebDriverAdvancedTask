package hooks;

import static driver.SingletonDriver.getDriver;

import driver.SingletonDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class DriverHooks {

    private DriverHooks() {
    }

    @BeforeAll
    public static void setUpDriver() {
        getDriver();
    }

    @AfterAll
    public static void quitDriver() {
        quit();
    }

    public static void quit() {
        SingletonDriver.getDriver().quit();
    }

    public static void clearCookies() {
        SingletonDriver.getDriver().manage().deleteAllCookies();
    }

}
