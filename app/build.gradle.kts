plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.mohammedeliyaz.dogbreed"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mohammedeliyaz.dogbreed"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

        }
        dataBinding {
            enable
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.databinding:databinding-common:8.2.1")
    implementation("androidx.databinding:databinding-runtime:8.2.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Other dependencies...
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("androidx.recyclerview:recyclerview:1.2.1")

    // Glide library
    implementation ("com.github.bumptech.glide:glide:4.6.1")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.6.1")
// Volley library
// Recyclerview Library
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.android.volley:volley:1.2.0")
//noinspection GradleCompatible
    implementation ("androidx.recyclerview:recyclerview:1.3.1")
// For control over item selection of both touch and mouse driven selection
    implementation ("androidx.recyclerview:recyclerview-selection:1.1.0")
//Glide and Picasso for Images
    implementation ("com.github.bumptech.glide:glide:4.15.1")
    implementation ("com.squareup.picasso:picasso:2.71828")

    implementation ("com.squareup.picasso:picasso:2.71828")

    //multidex Jetpack Comp
    implementation ("com.android.support:multidex:1.0.0")
    ///for dimens
    implementation ("com.intuit.ssp:ssp-android:1.0.6")
    implementation ("com.intuit.sdp:sdp-android:1.0.6")
    // ViewModel and LiveData
    implementation ("androidx.lifecycle:lifecycle-extensions:2.1.0")
    annotationProcessor ("androidx.lifecycle:lifecycle-compiler:2.1.0")

}