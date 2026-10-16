<div align="center">

# UOL Help Desk

### Implicit & Explicit Intents Lab Task

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)

**CS02310 Mobile Application Development** · Section S
Somia Khan · SAP ID 70151016

</div>

---

## About

A small app that lets a student reach the university in one tap. The home screen opens other apps through **implicit Intents**, and a second screen is reached with an **explicit Intent** that carries the student's name.

---

## Features

### Home Screen
| Button | Action | Opens |
|---|---|---|
| Visit Website | `ACTION_VIEW` + `https://www.uol.edu.pk` | Web browser |
| Call Help Desk | `ACTION_DIAL` + `tel:04212345678` | Phone dialer |
| Find Campus | `ACTION_VIEW` + `geo:0,0?q=University+of+Lahore` | Maps app |
| Send a Request | Explicit Intent | Request screen |

### Request Screen
- Greets the student by name (uses "Student" if no name is received)
- **Call This Number:** accepts only 11 digits starting with `03`
- **Open Link:** rejects empty input and adds `https://` when missing

### Safety & Validation
- `openIntent()` helper catches `ActivityNotFoundException` and shows a Toast if no app can handle the action
- `setError()` shows messages for an empty name, an invalid phone number and an empty link

---

## Implicit vs Explicit Intents

| | Implicit | Explicit |
|---|---|---|
| **Names the target?** | No, only an action and data | Yes, the exact class |
| **Who decides?** | Android picks an installed app | The developer |
| **Used here for** | Browser, dialer, maps | Opening `RequestActivity` |

---

## Project Structure

| File | Purpose |
|---|---|
| `MainActivity.java` | Home screen, the three implicit Intents, `openIntent()` helper |
| `RequestActivity.java` | Greeting, phone and link validation |
| `activity_main.xml` | Home screen layout |
| `activity_request.xml` | Request screen layout |

---

## How to Run

1. Open this folder in **Android Studio**.
2. Wait for **Gradle sync** to finish.
3. Run on an emulator (a Google Play image is best for the maps app) or a phone.
