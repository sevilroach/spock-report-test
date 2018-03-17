package io.johnroach.functionaltest.pages

import geb.Page


class FirstPostPage extends BasePage {
    static at = { title == "gRPC and protobuf Awesome Microservices Communication Introduction" }

    static content = {
        authorBio { $("h2", class: "author-bio") }
        postContent { $("section", class: "post-full-content") }
        readMoreAboutMe { $("a", class: "author-card-button") }
    }
}
