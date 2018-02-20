package io.johnroach.functionaltest.traits

import geb.Browser


trait SharedTrait {
    def testData

    /**
     * Loads the correct data for use in the test scripts based on environment running the test
     */
    def loadSharedTestData() {
        def fileToSlurpIn = new File('').absolutePath + '/src/test/groovy/io/johnroach/functionaltest/data/'
        testData = new ConfigSlurper().parse(new File(fileToSlurpIn + "testData.groovy").toURL())
        baseUrl = testData.envConfig.BASE_URL
        return testData
    }
}
