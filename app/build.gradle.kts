import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id(Dependencies.DAGGER_HILT)
}

android {
    namespace = "com.foodie"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.foodie"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary =  true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility  = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion  = "1.2.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
   implementation(Dependencies.composeUI)
    implementation(Dependencies.composeTooling)
    implementation(Dependencies.composePreview)
    implementation(Dependencies.composeFoundation)
    implementation(Dependencies.composeActivity)
    implementation(Dependencies.composeNavigation)
    implementation(Dependencies.composeUtil)
    implementation(Dependencies.material3)
    implementation(Dependencies.composeContraint)
    implementation(Dependencies.koinAndroid)
    implementation(Dependencies.coil)
    implementation(Dependencies.serializationCore)

    implementation(Dependencies.hilt)
    kapt(Dependencies.hiltKapt)


    testImplementation(Dependencies.jUnit)
    androidTestImplementation(Dependencies.expresso)
    androidTestImplementation(Dependencies.composeJunit)
}

kapt {
    correctErrorTypes = true
}