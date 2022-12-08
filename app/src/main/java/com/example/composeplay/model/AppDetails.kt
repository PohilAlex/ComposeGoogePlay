package com.example.composeplay.model

data class AppDetails(
    val aboutAppText: String,
    val whatNewText: String
)

val gitHubAppDetails = AppDetails(
    aboutAppText = """
        Triage notifications, review, comment, and merge, right from your mobile device
        
        There’s a lot you can do on GitHub that doesn’t require a complex development environment – like sharing feedback on a design discussion, or reviewing a few lines of code. GitHub for Android lets you move work forward wherever you are. Stay in touch with your team, triage issues, and even merge, right from the app. We’re making these tasks easy for you to perform, no matter where you work, with a beautifully native experience.
        
        You can use GitHub for Android to:
        
        • Browse your latest notifications
        • Read, react, and reply to Issues and Pull Requests
        • Review and merge Pull Requests
        • Organize Issues with labels, assignees, projects, and more
        • Browse your files and code
        """.trimIndent(),
    whatNewText = """
        - Push notifications are now grouped when they belong to the same thread.
        - Introducing feed filters: filter out specific types of content from your feed.
        - Introducing feed rollups: similar items are grouped together within the feed.
    """.trimIndent()
)

val emptyAppDetails = AppDetails(
    aboutAppText = "",
    whatNewText = ""
)