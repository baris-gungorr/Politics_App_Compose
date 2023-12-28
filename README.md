# Politics_App_Compose

📸 Screenshots
<table>
  <tr>
    <td align="center">
      <img src="https://github.com/baris-gungorr/Politics_App_Compose/assets/121685398/0b2e59a9-167d-4188-8df5-ed9804e4acf3" alt="POLITICS_APP" width="250">
    </td>
    <td align="center">
      <img src="https://github.com/baris-gungorr/Politics_App_Compose/assets/121685398/98806ac7-5bed-48bf-a1f6-dcf01029eb60" alt="POLITICS_APP" width="250">
    </td>
    <td align="center">
      <img src="https://github.com/baris-gungorr/Politics_App_Compose/assets/121685398/a420ed55-b822-4ec3-b5a1-31a0d13871f8" alt="POLITICS_APP" width="250">
    </td>
  </tr>
  <tr>
    <td align="center">
      <img src="https://github.com/baris-gungorr/Politics_App_Compose/assets/121685398/f8449dd5-c798-43f9-9e55-ae5017f2d30d" alt="NOTLARIM" width="250">
    </td>
    <td align="center">
      <img src="https://github.com/baris-gungorr/Politics_App_Compose/assets/121685398/3a0ccd39-2ca9-4634-a252-90f68ba780aa" alt="NOTLARIM" width="250">
    </td>
    <td align="center">
      <img src="https://github.com/baris-gungorr/Politics_App_Compose/assets/121685398/c908a6bd-01e2-4416-a9f1-e72bec06b995" alt="NOTLARIM" width="250">
    </td>
  </tr>
</table>


📸 Videos
 <!-- Video -->
<div align="left">

https://github.com/baris-gungorr/Politics_App_Compose/assets/121685398/567f1bd6-6078-47f3-b7da-520e4a2687fe


  <video src= "VIDEO.mp4"/>
</div>


👇 Structures Used

Application architecture: MVVM

- View Binding 
- Coroutine
- ViewModel
- Navigation
- Hilt
- Room
- Retrofit
- Paging
- Coil
- Glide
- ViewModel


  ✏️ Dependency
 ```gradle
   // Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.0")
    implementation("androidx.navigation:navigation-ui-ktx:2.5.0")

   // DataStore
    implementation ("androidx.datastore:datastore-preferences:1.0.0")

    //Splash Api
    implementation ("androidx.core:core-splashscreen:1.0.1")

    //Paging
    implementation ("androidx.paging:paging-compose:3.3.0-alpha02")
    implementation("androidx.paging:paging-runtime:3.3.0-alpha02")

    //Accompanist
    implementation ("com.google.accompanist:accompanist-systemuicontroller:0.31.4-beta")

    //Coil
    implementation("io.coil-kt:coil-compose:2.4.0")

    //Compose Foundation
    implementation ("androidx.compose.foundation:foundation:1.4.3")

    //Room
    implementation("androidx.room:room-runtime:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")

    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.6.0")
    implementation("com.google.code.gson:gson:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.5.0")

    //Glide
    implementation("com.github.bumptech.glide:glide:4.13.2")

    //ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel:2.5.1")
    implementation("androidx.activity:activity-ktx:1.6.1")

    //Hilt
    implementation("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-android-compiler:2.44")



```

```groovy
  plugins {

    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id ("com.google.dagger.hilt.android")
    id ("kotlin-parcelize")
}


```

```groovy
👇 API

- https://newsapi.org/

```
