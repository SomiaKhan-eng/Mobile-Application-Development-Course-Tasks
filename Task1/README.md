<div align="center">

# Fragment Lab Task 1

### Bottom Navigation with Fragments

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)

**CS02310 Mobile Application Development**
Somia Khan · SAP ID 70151016

</div>

---

## About

An Android app with a bottom navigation bar. Tapping each item swaps the screen between three fragments inside a single activity.

---

## Features

- **Bottom navigation bar** with Home, Profile and Settings items
- **Three fragments** (`HomeFragment`, `ProfileFragment`, `SettingsFragment`) swapped by `FragmentManager`
- **Home opens by default** when the app starts
- Custom icons and a colour selector for the active navigation item

---

## Project Structure

| File | Purpose |
|---|---|
| `MainActivity.java` | Hosts the navigation bar and switches fragments |
| `HomeFragment.java` | Home screen |
| `ProfileFragment.java` | Profile screen |
| `SettingsFragment.java` | Settings screen |
| `bottom_nav_menu.xml` | Defines the three navigation items |
| `nav_item_color.xml` | Colours for selected and unselected items |

---

## How to Run

1. Open this folder in **Android Studio**.
2. Wait for **Gradle sync** to finish.
3. Run on an emulator or a connected Android phone.
