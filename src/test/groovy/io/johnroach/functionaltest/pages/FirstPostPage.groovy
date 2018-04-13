package io.johnroach.functionaltest.pages

import geb.Page


class FirstPostPage extends BasePage {
    static at = { title == "Test Driven Development with Infrastructure Code" }

    static content = {
        authorBio { $("h2", class: "author-bio") }
        postContent { $("section", class: "post-full-content") }
        readMoreAboutMe { $("a", class: "author-card-button") }
    }
}
