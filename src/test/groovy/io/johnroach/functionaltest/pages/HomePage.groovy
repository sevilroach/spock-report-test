package io.johnroach.functionaltest.pages

import geb.Page


class HomePage extends BasePage {
    static url = ""

    static content = {
        firstPostCard { $("article", class: "post-card").find("a")[0] }
        siteDescription { $("h2", class: "site-description") }
    }
}
