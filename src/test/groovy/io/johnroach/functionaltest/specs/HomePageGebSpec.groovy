package io.johnroach.functionaltest.specs

import io.johnroach.functionaltest.pages.HomePage
import io.johnroach.functionaltest.traits.BasePageTrait
import io.johnroach.functionaltest.utils.BasePageGebSpec
import spock.lang.Issue


class HomePageGebSpec extends BasePageGebSpec implements BasePageTrait {
    @Issue("https://johnroach.io")
    def "Check if description is displayed on the home page"() {
        when: "A user is on the home page"
        to HomePage
        waitFor { HomePage }

        then: "Site description is displayed"
        assert siteDescription.text() == "Coding for life"
    }
}
