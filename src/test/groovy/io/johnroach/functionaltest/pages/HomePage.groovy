package io.johnroach.functionaltest.pages

import geb.Page


class HomePage extends BasePage {
    static url = ""
    static content = {
        siteDescription { $("h2", class: "site-description") }
    }
}
