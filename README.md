# 🎧 Audio Book Compose

A modern Android application built with **Jetpack Compose**, implementing a concept design by [Gleb Kuznetsov on Dribbble](https://dribbble.com/shots/17635314-Audio-Book-App-Concept).

This project serves as a showcase of **Modern Android Development (MAD)** skills, focusing on medium level UI interactions, layout drawing, and clean architecture implementation.

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

## ✨ Key Features

* **Immersive UI**: Full `Edge-to-Edge` implementation with transparent system bars.
* **Smart Scrolling**: Sticky headers synchronized with category selection. The list intelligently scrolls or maintains position based on the user's viewport context.
* **Interactive Player**: Draggable seeker with precise time tracking and smooth state updates.

## ⚠️ Project Scope & Limitations

* **Dummy Data**: This project does not connect to a real backend API. All data presented (audio books, authors, genres) is **static dummy data** loaded locally from a list for demonstration purposes.
* **Scope**: The implemented features and screens are strictly limited to the visual scope presented in the [original Dribbble concept](https://dribbble.com/shots/17635314-Audio-Book-App-Concept). It focuses on UI/UX fidelity rather than full audio streaming functionality.

## 🛠 Tech Stack

* **Language**: Kotlin
* **UI Toolkit**: [Jetpack Compose](https://developer.android.com/jetpack/compose) (Material 3)
* **Architecture**: MVVM (Model-View-ViewModel)
* **State Management**: Unidirectional Data Flow (UDF) with `StateFlow` & `UIState` pattern.
* **Navigation**: Jetpack Compose Navigation.
* **Async**: Coroutines & Flow.
* **Image Vector Converter**: [Valkyrie](https://github.com/ComposeGears/Valkyrie)

## 🏗 Architecture & Engineering Highlights

### 1. Unidirectional Data Flow (UDF)
The app strictly follows UDF principles. The UI observes a sealed interface `UIState` (Loading, Success, Error) ensuring the view is always in a deterministic state.

```kotlin
sealed interface HomeUIState {
    object Loading : HomeUIState
    data class Success(val audioBooks: List<AudioBook>) : HomeUIState
    data class Error(val message: String) : HomeUIState
}
