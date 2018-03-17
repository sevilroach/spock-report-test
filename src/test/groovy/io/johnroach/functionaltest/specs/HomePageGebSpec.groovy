package io.johnroach.functionaltest.specs

import io.johnroach.functionaltest.pages.HomePage
import io.johnroach.functionaltest.traits.BasePageTrait
import io.johnroach.functionaltest.utils.BasePageGebSpec
import spock.lang.Issue
import spock.lang.Stepwise

@Stepwise
class HomePageGebSpec extends BasePageGebSpec implements BasePageTrait {
    @Issue("https://johnroach.io")
    def "Check if description is displayed on the home page"() {
        when: "A user is on the home page"
        to HomePage
        waitFor { HomePage }

        then: "Site description is displayed"
        assert siteDescription.text() == "Coding for life"
    }

    @Issue("https://johnroach.io")
    def "First post on the home page is clickable"() {
        given: "A user is on home page"
        to HomePage
        waitFor { HomePage }

        when: "First post on home page is clicked"
        firstPostCard.click()
        at FirstPostPage

        then: "Article is displayed"
        assert postContent.isDisplayed()
    }

    @Issue("https://johnroach.io")
    def "Clicking Read More from footer goes to author page"() {
        given: "A user is on the first post's page"
        to FirstPostPage

        when: "Read More is clicked"
        readMoreAboutMe.click()

        then: "Author page is displayed"
        assert currentUrl.contains("author/john")
    }

    @Issue("https://johnroach.io")
    def "Clicking Home from header on author page goes to home page"() {
        given: "A user is on author page"
        to AuthorPage

        when: "Read More is clicked"
        homePageLink.click()

        then: "Author page is displayed"
        assert currentUrl.contains("author/john")
    }

}
