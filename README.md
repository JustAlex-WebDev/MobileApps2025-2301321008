# **Description**

DoorIQ is a smart QR-based room information system designed to modernize university classroom management and improve student access to real-time academic information.

Instead of manually updating printed schedules on classroom doors, DoorIQ enables dynamic digital room updates powered by QR codes and cloud synchronization.

---

# **Project Idea**

Universities often update classroom schedules weekly using printed graphics placed on doors. This process is manual, inefficient, and prone to outdated information.

DoorIQ replaces static paper schedules with permanent QR codes placed on each classroom door.

When scanned, the QR code opens the DoorIQ mobile application and displays up-to-date information about:

- Current lecture
- Lecturer
- Time schedule
- Upcoming classes
- Announcements
- Room details

All information can be updated remotely by administrators through a centralized system powered by Supabase.

---

# **Key Features**

## **Student Mode**

- Scan classroom QR code
- View current lecture details
- View upcoming schedule
- View announcements
- Save rooms to favorites
- Offline access via local caching
- Light & Dark Material 3 theme

## **Admin Mode**

- Create new rooms
- Edit room information
- Update weekly schedules
- Post announcements
- Instantly sync changes via Supabase

## **QR Code System**

- Generate unique QR code per room
- QR encodes dynamic room ID
- Custom QR with editable room number in center
- Export QR as image

---

# **Architecture**

The application follows modern Android development practices:

- **Language:** Kotlin
- **Min SDK:** 24
- **Architecture:** MVVM + Repository pattern
- **Local Database:** Room
- **Remote Database:** Supabase (PostgreSQL + REST)
- **Networking:** Retrofit
- **Dependency Injection:** Hilt
- **QR Scanning:** ML Kit / ZXing
- **UI:** Material 3

The app uses a hybrid data approach:

- Supabase for real-time cloud updates
- Room for offline caching and persistence

---

# **How It Works**

1. Each classroom is assigned a unique Room ID.
2. A QR code containing the Room ID is generated and placed on the classroom door.
3. A student scans the QR code using the DoorIQ app.
4. The app retrieves the latest room data from Supabase.
5. Information is displayed and cached locally for offline access.

Administrators can update room schedules at any time without reprinting physical graphics.

---

# **Social Impact**

DoorIQ improves:

- Digital transformation of educational institutions
- Real-time access to academic information
- Reduction of paper waste
- Administrative efficiency
- Student experience

---

# **APK**

The release APK is available in:

/apk/app-release.apk

---

# **Testing**

- Unit tests cover core business logic (≥ 15%)
- UI test validates main scanning flow
- Application tested on physical Android device

---

# **How to Run**

1. Clone the repository
2. Open in Android Studio
3. Configure Supabase project credentials
4. Build and run on emulator or physical device

---

# **Screenshots**

(Insert screenshots here)
