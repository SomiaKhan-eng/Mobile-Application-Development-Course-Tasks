<div align="center">

# UOL Course Catalogue

### Lab Task 02 – RecyclerView

**CS02310** · Mobile Application Development · BS Software Engineering · The University of Lahore

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Android Studio](https://img.shields.io/badge/Android_Studio-3DDC84?style=for-the-badge&logo=androidstudio&logoColor=white)

</div>

---

## About

UOL Course Catalogue is a simple Android app that shows the courses of the BS Software Engineering programme as a scrolling list of cards. Tapping a card opens a details screen for that course only, with a button to email its instructor.


---

## Features

**Scenario 1 – Course list**
- Scrollable list built with `RecyclerView` and `LinearLayoutManager`
- Each course is shown as a `CardView` with the course code, title and credit hours
- Nine courses of the BS-SE programme

**Scenario 2 – Course details**
- Tapping a card opens `CourseDetailActivity` for that course only
- Shows the code (as screen title), title, instructor, credit hours and description
- "Email Instructor" button opens the email app with that instructor's address (`ACTION_SENDTO` with `mailto:`), and shows a Toast if no email app is found

---

## Concepts Used

- Model class (`Course`) with private fields and getters
- `RecyclerView` with Adapter and ViewHolder pattern
- `CardView` item layout
- `LinearLayoutManager`
- Item click handling through an `OnItemClickListener` interface
- Explicit Intents with `putExtra()` and `public static final` key constants
- Implicit Intent (`ACTION_SENDTO`) with try–catch

---

## Project Structure

```
LabTask2_RecyclerView_70151016/
├── app/src/main/java/com/example/uolcoursecatalogue/
│   ├── Course.java                 # model class
│   ├── CourseAdapter.java          # adapter, ViewHolder, click interface
│   ├── MainActivity.java           # course list and tap handling
│   └── CourseDetailActivity.java   # details screen and email button
├── app/src/main/res/layout/
│   ├── activity_main.xml           # RecyclerView (rvCourses)
│   ├── item_course.xml             # CardView of one course
│   └── activity_course_detail.xml  # details screen layout
└── README.md
```

---

## How the Tap Works

```
tap on card → click listener in ViewHolder → onItemClick(position)
→ courses.get(position) → Intent with that course's data → CourseDetailActivity
```

The position of the tapped card is the same as the index of that course in the list, so `courses.get(position)` always returns the tapped course.

---

## How to Run

1. Clone the repository:
   `git clone https://github.com/SomiaKhan-eng/Mobile-Application-Development-Course-Tasks.git`
2. Open the `LabTask2_RecyclerView_70151016` folder in **Android Studio**.
3. Wait for **Gradle sync** to finish.
4. Run on an emulator or a connected Android phone.

---

## Tech Stack

- **Language:** Java
- **IDE:** Android Studio
- **Libraries:** `androidx.recyclerview:recyclerview:1.3.2`, `androidx.cardview:cardview:1.0.0`
- **Build system:** Gradle (Kotlin DSL)
- **Version control:** Git & GitHub
