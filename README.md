# CryptoCurrencyInfo
An android app built in kotlin that fetches crypto data from coinpaprika api. The application is built using the usecase + MVVM architectural design pattern

This project is meant to demonstrate the Android MVVM Clean architecture in android with the help of all the latest components available.

## Features
* Home Screen showing list of countries
* Offline Support.
* Detail Screen to show more information about a country.

## Architecture
* Built with Modern Android Development practices.
* Utilized Usecase, Repository pattern for data.
* Includes valid Unit tests for ViewModel,Repository,Usecases and Mappers.

## Built With 🛠
- https://kotlinlang.org/ - First class and official programming language for Android development.
- https://kotlinlang.org/docs/reference/coroutines-overview.html - For asynchronous and more..
- https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-flow/ - A cold asynchronous data stream that sequentially emits values and completes normally or with an exception.
- https://developer.android.com/topic/libraries/architecture - Collection of libraries that help you design robust, testable, and maintainable apps.
    - https://developer.android.com/jetpack/compose - It simplifies and accelerates UI development on Android.
    - https://developer.android.com/topic/libraries/architecture/viewmodel - Stores UI-related data that isn't destroyed on UI changes.
- https://developer.android.com/training/dependency-injection
    - https://dagger.dev/hilt - Easier way to incorporate Dagger DI into Android apps.
- https://developer.android.com/reference/androidx/room/package-summary - For saving Data in local DB and to provide offline support.
- https://mockito.io - For Mocking and Unit Testing.
 
All the dependencies are declared in the build.gradle file. No need to take some extra measure. 
Just import this project via Android Studio :)

## 👨 Developed By
*** Aghogho Akpedeye ***
