package io.johnroach.functionaltest.pages

import geb.Page


class HomePage extends BasePage {
    static url = ""

    static content = {
        firstPostCard { $("article", 0, class: "post-card").find("a") }
        siteDescription { $("h2", class: "site-description") }
    }
}
