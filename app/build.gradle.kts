plugins {
  id("com.android.application")
  id("org.jetbrains.kotlin.android")
  id("kotlin-kapt")
  id("com.google.dagger.hilt.android")
}

android {
  namespace = "com.yael.todoapp"
  compileSdk = 34

  defaultConfig {
    applicationId = "com.yael.todoapp"
    minSdk = 24
    targetSdk = 34
    versionCode = 1
    versionName = "1.0.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    vectorDrawables {
      useSupportLibrary = true
    }
  }

  buildTypes {
    debug {

    }
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  kotlinOptions {
    jvmTarget = "1.8"
  }
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = "1.5.1"
  }
  packaging {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
}

kapt{
  correctErrorTypes = true
}

dependencies {

  //splash screen api
  implementation("androidx.core:core-splashscreen:1.0.0")
  //shared preference
  implementation("androidx.datastore:datastore-preferences:1.0.0")
  //navigation compose
  implementation("androidx.navigation:navigation-compose:2.5.3")
  //retrofit
  implementation("com.squareup.retrofit2:retrofit:2.9.0")
  implementation("com.google.code.gson:gson:2.9.0")
  implementation("com.squareup.retrofit2:converter-gson:2.9.0")
  implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")
  //dagger hilt
  implementation("com.google.dagger:hilt-android:2.51.1")
  kapt("com.google.dagger:hilt-android-compiler:2.51.1")
  implementation ("androidx.hilt:hilt-navigation-compose:1.0.0")
  //live data
  implementation("androidx.compose.runtime:runtime-livedata:1.6.8")


  implementation("androidx.core:core-ktx:1.13.1")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.2")
  implementation("androidx.activity:activity-compose:1.9.0")
  implementation(platform("androidx.compose:compose-bom:2023.08.00"))
  implementation("androidx.compose.ui:ui")
  implementation("androidx.compose.ui:ui-graphics")
  implementation("androidx.compose.ui:ui-tooling-preview")
  implementation("androidx.compose.material3:material3")
  testImplementation("junit:junit:4.13.2")
  androidTestImplementation("androidx.test.ext:junit:1.2.1")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
  androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
  androidTestImplementation("androidx.compose.ui:ui-test-junit4")
  debugImplementation("androidx.compose.ui:ui-tooling")
  debugImplementation("androidx.compose.ui:ui-test-manifest")
}