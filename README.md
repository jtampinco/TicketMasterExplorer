# TicketMasterExplorer
Simple android app that uses the TicketMaster search event API

# Project Details
This project contains 1 parent activity with 2 tabs. 

The first tab displays all the events currently searchable via the GET discovery/v2/events API. The events are displayed as cards and include their name, price range, photo, date, venue, and the attractions associated with them. Infinite scrolling has been applied wherein 10 events are shown initially. 

The second tab displays all "liked" events. The like functionality is in the form of a "heart" on each event card. Once an event is "liked" it will be stored in the database and deleted once it is "unliked"

### This application is using the following technologies:
1) Kotlin as the main programming language
2) Model View ViewModel (MVVM) Architecture
3) Jetpack Compose
4) HILT for Dependency Injection
5) Coil for Image Loading
6) Retrofit for API Communication
7) Room for local data storage

<i>The notable difference in an app developed using jetpack compose is that it does not need fragments and significantly fewer XML files</i>

### TO-DO
There are still some missing components in this app to showcase a more industry-accepted application so I will probably add them as I get more free time
1) State Hoisting - I implemented it on the composable(s) I developed but I believe I can still do better
2) Kotlin Multiplatform - This might be the end state that I wish to achieve
3) Animations/Transitions - For now I am still using default "material" behavior for the composable(s), I'll still do more research to make it better
4) Testing - This is pretty much self-explanatory
5) Modularization
