<div align="center">

# Seminar App

### Seminar Registration with a Confirmation Screen

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)

**CS02310 Mobile Application Development**
Somia Khan · SAP ID 70151016

</div>

---

## About

An Android app where a student registers for a seminar by entering a name and an email. The input is checked, and if it is valid, a confirmation screen shows the registration details.

---

## Features

- **Registration screen** with name and email fields
- **Validation:** a `Registration` class checks the input, and a Toast asks for a valid name and email if it fails
- **Confirmation screen** that receives the name and email through an Intent and displays them

---

## App Flow

| Step | Screen | What happens |
|---|---|---|
| 1 | `RegistrationActivity` | Student enters name and email, then taps register |
| 2 | Validation | `Registration.isValid()` checks the input |
| 3 | `ConfirmationActivity` | Shows the submitted details (opened with an explicit Intent and `putExtra()`) |

---

## Project Structure

| File | Purpose |
|---|---|
| `RegistrationActivity.java` | Reads input, validates, starts the confirmation screen |
| `Registration.java` | Model class holding the name and email, with the validation logic |
| `ConfirmationActivity.java` | Displays the registration details |
| `activity_registration.xml` | Registration screen layout |
| `activity_confirmation.xml` | Confirmation screen layout |

---

## How to Run

1. Open this folder in **Android Studio**.
2. Wait for **Gradle sync** to finish.
3. Run on an emulator or a connected Android phone.
