package io.johnroach.functionaltest.utils

import io.johnroach.functionaltest.traits.SharedTrait
import geb.driver.CachingDriverFactory
import geb.spock.GebSpec
import groovy.json.JsonSlurper
import org.junit.Rule
import org.junit.rules.TestName
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.RemoteWebDriver
import spock.lang.Shared
import spock.lang.Stepwise


class BasePageGebSpec extends GebSpec implements SharedTrait {
    /**
     * Represents the browser to be used as part of the test run.
     */
    private String browser

    /**
     * Represents the operating system to be used as part of the test run.
     */
    private String os

    /**
     * Represents the version of the browser to be used as part of the test run.
     */
    private String version

    /**
     * Represents the deviceName of mobile device
     */
    private String deviceName

    /**
     * Represents the device-orientation of mobile device
     */
    private String deviceOrientation

    /**
     * Instance variable which contains the Sauce Job Id.
     */
    private String sessionId

    private static boolean driverCreated

    @Rule
    public TestName name = new TestName() {
        public String getMethodName() {
            return super.getMethodName()
        }
    }

    public createDriver() {
        String driverType = System.getProperty("driverType")
        ChromeOptions options = new ChromeOptions()
        options.addArguments("start-maximized")
        options.addArguments("disable-gpu")
        options.addArguments("ignore-certificate-errors")
        options.addArguments("ignore-urlfetcher-cert-requests")
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:9515"), options)
        this.sessionId = (((RemoteWebDriver) driver).getSessionId()).toString()
    }

    /**
    *
    * @return the value of the Sauce Job id.
    */
    public String getSessionId() {
        return sessionId
    }

    public void setupSpec() throws Exception {
        driverCreated = false
    }

    private isSpecStepwise() {
        this.class.getAnnotation(Stepwise) != null
    }

    public void setup() throws Exception {
        loadSharedTestData()
        if (!driverCreated || !isSpecStepwise()) {
            createDriver()
            driverCreated = true
        }
    }

    @Override
    public void cleanup() throws Exception {
        if(!isSpecStepwise()) {
            CachingDriverFactory.clearCache()
            driver.quit()
        }
    }

    @Override
    public void cleanupSpec() throws Exception {
        if(isSpecStepwise()) {
            CachingDriverFactory.clearCache()
            driver.quit()
        }
    }
}
