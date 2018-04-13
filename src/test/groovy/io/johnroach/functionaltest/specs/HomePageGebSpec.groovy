package io.johnroach.functionaltest.specs

import io.johnroach.functionaltest.pages.AuthorPage
import io.johnroach.functionaltest.pages.FirstPostPage
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
        when: "First post on home page is clicked"
        firstPostCard.click()
        at FirstPostPage

        then: "Article is displayed"
        assert !postContent.isDisplayed()
    }

    @Issue("https://johnroach.io")
    def "Clicking Read More from footer goes to author page"() {
        when: "Read More is clicked"
        readMoreAboutMe.click()

        then: "Author page is displayed"
        assert currentUrl.contains("author/john")
    }
}
