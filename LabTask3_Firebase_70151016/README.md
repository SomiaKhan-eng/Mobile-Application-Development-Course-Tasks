<div align="center">

# UOL Lost & Found Board

### Lab Task 3 · Firebase + RecyclerView

**CS02310** · Mobile Application Development · The University of Lahore

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Firebase](https://img.shields.io/badge/Firebase-FFCA28?style=for-the-badge&logo=firebase&logoColor=black)
![Android Studio](https://img.shields.io/badge/Android_Studio-3DDC84?style=for-the-badge&logo=androidstudio&logoColor=white)

</div>

---

## About

An Android app where students post lost or found items on campus and everyone sees them on one shared board that updates by itself. All data comes from the Firebase Realtime Database.

| | |
|---|---|
| **Student** | Somia Khan |
| **SAP ID** | 70151016 |
| **Section** | S |

---

## Features

- **Post Item screen** with item name, location, contact and a Lost / Found choice. Empty fields are rejected with `setError()`.
- **Cloud storage**: every post is saved under the `LostFound` node in Firebase Realtime Database.
- **Live board** built with RecyclerView and CardView, newest post first, updating with no refresh button.
- **Mark as Returned**: tapping a card writes `Returned` to that item's status, and the card turns grey.
- **Empty state**: a "No items posted yet" message appears when there are no posts.

---

## Concepts Used

| Concept | Where it is used |
|---|---|
| Model class (`LostItem`) | Holds one post, with a no-argument constructor for Firebase |
| `push()` + `setValue()` | Creates a unique key and writes the post |
| `addValueEventListener()` | Reads all posts live, and again on every change |
| `DataSnapshot` | Converts each child into a `LostItem` |
| RecyclerView + Adapter + ViewHolder | Shows the posts as cards |
| `removeEventListener()` | Removes the listener in `onDestroy()` |

---

## Project Structure

```
app/src/main/
├── java/com/example/labtask2/
│   ├── MainActivity.java        # Live board
│   ├── PostItemActivity.java    # Post Item form
│   ├── LostItem.java            # Model class
│   └── LostItemAdapter.java     # RecyclerView adapter
└── res/layout/
    ├── activity_main.xml
    ├── activity_post_item.xml
    └── item_lost.xml            # Card layout
```

---

## Setup

`google-services.json` is **not included** for security reasons. To run the app:

1. Create your own project in the [Firebase Console](https://console.firebase.google.com).
2. Register an Android app with the package name `com.example.labtask2`.
3. Create a **Realtime Database** in test mode.
4. Download `google-services.json` and place it in the `app/` folder.
5. If your database is not in the US, put your database URL in `FirebaseDatabase.getInstance("your-url")` in
