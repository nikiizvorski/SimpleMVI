# SimpleMVI
Simple implementation of MVI (MVI stands for Model-View-Intent) Architecture on Android allowing you to understand how Networking, Caching Data flow should look in this pattern also i would try to add the latest libraries and sample of usage with Android JetPack and Rx.

# Structure
API (Services) - Network Tempalte
App (Application) - Base Application
DB (Database) - Room / Realm
DI (Dependency Injection) - Hilt
EXT (Constants) - Constants
ENTITY (DataModels) - Entity and Models
INTERACTORS (PhotoInteractor) - Model
PRESENTATION (Views and ViewModels - ViewBindings) - Intent / Action
UTILS (Extensions / DataState etc) - Helper classes

The idea of this project would be to give a very simple implementation of the MVI architecture that you might use on daily basis in your projects as a base. So you could basically go forward with more complex and advanced usage of it.
Currently we have introduced. Simple View State - ViewModel State - Networking and Caching with Room and Model State
we have a network request which we cache in our db and afte that show the data.

# Advantages of this project
- Model-View-Intent is a tool to create maintainable and scalable apps.
- A unidirectional and cyclical data flow.
- A consistent state during the lifecycle of Views.
- Immutable Models that provide reliable behavior and thread safety on big apps.

# Dissadvantages of the project
 - The downside of using MVI rather than other architecture patterns for Android is that the learning curve for this pattern tends to be a bit longer. You need a decent amount of knowledge of other intermediate and advanced topics such as reactive programming, multi-threading and RxJava. Architecture patterns such as MVC or MVP might be easier to grasp for new Android developers.

# Business Logic
- The following has been applied. 

- Views observe user action and renders different state - ViewModel - adds or removes - Interactor or Business Logic would create a new model with different state.

# Testing
- Testing haven't been integrated in this project. But would be fairly simple to do that. Firebase Cloud, Espresso, Robo etc.

- Added all the libraries for base setup for AndroidX on request for testing setup soon.

# CI/CD
- The project doesn't have any CD integrated. But if anyone would like to have that i would provide a sample implementation to any of the following: BitBucket, Github, CircleCI, Travis or any other.

# Added base Bitrise Integration
- Bintray - Maven/JCenter Center automation and Distribution can be added also the scripts can be added without any issues or incompatibility

# Gradle Scripts and Managment
- The Gradle scripts and managment haven't been updated to production build since the project is unknown and the future requirements are also. Once someone has a proposal i can add it and update a base default one. Which most people have in their company.

# Language
- The language of the code would stay Kotlin. The architecture can be applied and rotated to MVP fairly easy and to Java after if you want.

# Documentation
- It has been years for me when i started in University adding code documentation and i would like to think and continue to do that as a good developers practise. SOLID would be kept in mind for this project at all times. Do please let me know if i have an error somewhere. Appreciate it.

# InteliJ Plugins Used
- Plugins that i have personally used in our company and in my personal work.

# Comments and Ideas
- Here you can find a very clean arch that will be updated in the future with some small samples and cool integrations over the time. I would be adding some more about that soon when i can find some more time.

# Android Jetpack and Navigation Integration Added
- Could be added if requested. Currently doesn't contain implementation.

# Compose Implementation
- Could add ComposeViews for customViews or Composable View implementation if required. Would probably add it in the future.

# Android Lifecycle Integration Added
- The projectu uses lifecycle aware components

# DiffUtil Integration Added
- DiffUtil to be updated with the new implementation

# Hilt Integration - Added

# Future Updates

- Base Mapper for Entity and Network Models

- If time Composable Integration with Migration Strategy and Integration of standalone or custom View

- KSP will be integrated at a later date when most libraries support it!

- Kotlin Extensions, MediatorLiveData, Transformations and more

- Simplify and extend the project further

- RxJava3 implementation and render

- Reducer etc

# Recommended Architecture implementation to go forward

- MVI CORE BADOO - https://github.com/badoo/MVICore
- MVI Kotlin - https://github.com/arkivanov/MVIKotlin
- Kotlin Multiplatform Plugin - https://kotlinlang.org/docs/mobile/setup.html

Take your time with these two architectures since they are quite good to be used in production and also it might not fit the best with every project, team and organization. Also if you wish you could go in multiplatform it's quite interesting and nice how you could go forward!

# License
Feel free to use. If you can add me to any credits would appreciate it. Thanks. A good base would be to have something like the new projects that i will be adding for MVI and KotlinMultiplatform with MVI. You could also adapt this project for KotlinMultiplatform.



