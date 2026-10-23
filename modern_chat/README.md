# Modern Chat — Android Studio (Java + XML + Firebase)

A refreshed native Android real-time chat starter based on the supplied `com.teeniv.whatsapp` project. It uses Material 3 components, a clean green-and-neutral visual system, Firebase Authentication, Realtime Database, Firebase Storage, RecyclerView, and Glide.

## Features
- Email/password registration and login, with Firebase-backed sessions
- Live user directory with search
- One-to-one real-time text conversations
- Share photos from the device gallery
- Profile display name and profile-photo upload
- Modern layouts, rounded message bubbles, timestamps, and responsive scrolling

## Open in Android Studio
1. Extract the ZIP and open the `ModernChat` folder (the folder containing `settings.gradle.kts`).
2. Use JDK 17 and allow Gradle sync to finish.
3. The included `app/google-services.json` is copied from the supplied project and is configured for package `com.teeniv.whatsapp`. If you want to use a different Firebase project, replace it with the config downloaded from Firebase Console.
4. In Firebase Console, enable **Authentication → Email/Password**, **Realtime Database**, and **Storage**.
5. Set the Realtime Database and Storage security rules before testing (starter examples are in `firebase-rules/`).
6. Run on an emulator or physical Android device with internet access. Register two test accounts to test chat between users.

## Database shape
- `users/{uid}` — `uid`, `name`, `email`, `photoUrl`
- `chats/{sortedUidA_sortedUidB}/messages/{messageId}` — `id`, `senderId`, `text`, `imageUrl`, `timestamp`
- `profilePhotos/{uid}.jpg` and `chatPhotos/{chatId}/{randomId}.jpg` in Storage

## Security — important
The example rules restrict access to signed-in users, but production chat apps should enforce chat membership and storage ownership server-side. Do not ship permissive public read/write rules. Add App Check, abuse controls, reporting/blocking, and notification delivery before production release.

### Realtime Database rules starter
See `firebase-rules/database.rules.json`. It permits authenticated user-directory reads and authenticated chat access for easier development. Tighten it before production so only conversation members can read/write each chat and users can only edit their own profile.

### Storage rules starter
See `firebase-rules/storage.rules`. Configure these in Firebase Console → Storage → Rules.

## Notes
- This project has not been built against your local Android SDK in this environment. Gradle sync/build and Firebase configuration must be verified in Android Studio.
- Firebase client configuration is not a substitute for database/storage security rules.
