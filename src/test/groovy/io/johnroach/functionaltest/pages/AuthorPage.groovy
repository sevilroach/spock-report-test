package io.johnroach.functionaltest.pages

import geb.Page


class AuthorPage extends BasePage {
    static url = "/author/john"

    static content = {
        authorBio { $("h2", class: "author-bio") }
        homePageLink { $("li", class: "nav-home").find("a") }
    }
}
