# 🎧 Audio Book Compose

A modern Android application built with **Jetpack Compose**, implementing a concept design by [Gleb Kuznetsov on Dribbble](https://dribbble.com/shots/17635314-Audio-Book-App-Concept).

The project is built as a learning medium to improve understanding of Android architecture, Jetpack Compose UI, and UI interactions. It implements the MVVM architecture using a dummy data source to display a list of audio books and simulate audio playback.

The application uses Material 3 design with a balanced and consistent appearance in both Light Mode and Dark Mode.

<p align="center">
  <b>Demo</b>
</p>

<p align="center">
  <img src="/demo.gif" alt="app demo" width="300" />
</p>

<p align="center">
  <a href="https://github.com/Masdikaa/Audio-Book-Compose/releases/download/v1.0/AudioBookCompose.apk">
    <img src="https://img.shields.io/badge/Download_APK-Android-3DDC84?style=for-the-badge&logo=android&logoColor=white" alt="Download APK" />
  </a>
</p>

## 🚀 Key Implementation

* **MVVM Architecture & UI State**<br>
UI states are managed within the `ViewModel` using `StateFlow`, enabling a reactive and data-driven UI.
The implementation follows the principles of *Unidirectional Data Flow* (UDF) to ensure predictable state management and clearer data flow
* **Stateless & Stateful Composables**<br>
State hoisting is applied to separate UI logic from state management, resulting in reusable, testable, and modular composable components
* **Jetpack Navigation Compose**<br>
The app uses a *single-activity* architecture with Jetpack Navigation Compose to handle seamless navigation
* **UI Previews & Theming**<br>
Composable Previews are utilized to support faster UI iteration and to maintain consistent theming and design implementation across the application


## 📌 Project Scope & Limitations

* **Dummy Data**<br>
This project does not connect to a real backend API. All data presented (audio books, authors, genres) is **static dummy data** loaded locally from a list for demonstration purposes.
* **Scope**<br>
The implemented features and screens are strictly limited to the visual scope presented in the [original Dribbble concept](https://dribbble.com/shots/17635314-Audio-Book-App-Concept). It focuses on UI/UX fidelity rather than full audio streaming functionality

## 🛠 Tech Stack

* **Language**: Kotlin
* **UI Toolkit**: [Jetpack Compose](https://developer.android.com/jetpack/compose) (Material 3)
* **Architecture**: MVVM (Model-View-ViewModel)
* **State Management**: Unidirectional Data Flow (UDF) with `StateFlow` & `UIState` pattern
* **Navigation**: Jetpack Compose Navigation
* **Image Vector Converter**: [Valkyrie](https://github.com/ComposeGears/Valkyrie)

## 🎯 Learning Outcomes
* Designing UIs with **Jetpack Compose** using Material 3 principles
* Managing UI state reactively with **StateFlow** following **Unidirectional Data Flow**
* Structuring an app with **MVVM architecture** to clearly separate presentation and business logic
* Implementing screen navigation in a **single-activity architecture** using Navigation Compose
* Creating **stateless** and **stateful** composables for modular, reusable UI components
* Supporting **adaptive theming** for Light Mode and Dark Mode with consistent design.


