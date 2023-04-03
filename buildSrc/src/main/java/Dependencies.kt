object Dependencies {
    const val DAGGER_HILT = "dagger.hilt.android.plugin"

    // Kotlin
    const val kotlinVersion = "1.8.10"


    // Coil
    const val coil = "io.coil-kt:coil-compose:2.1.0"

    // Compose
    const val composeUiVersion = "1.4.0"
    const val composeFoundationVersion = "1.4.0"
    const val composeNavVersion = "2.5.3"
    const val composeActivityVersion = "1.7.0"
    const val composeConstraintVersion = "1.0.1"
    const val composeLifecycleVersion = "2.6.1"
    const val composeUI = "androidx.compose.ui:ui:$composeUiVersion"
    const val composeTooling = "androidx.compose.ui:ui-tooling:$composeUiVersion"
    const val composePreview = "androidx.compose.ui:ui-tooling-preview:$composeUiVersion"
    const val composeFoundation = "androidx.compose.foundation:foundation:$composeFoundationVersion"
    const val composeActivity = "androidx.activity:activity-compose:$composeActivityVersion"
    const val composeNavigation = "androidx.navigation:navigation-compose:$composeNavVersion"
    const val composeUtil = "androidx.compose.ui:ui-util:$composeUiVersion"
    const val composeContraint = "androidx.constraintlayout:constraintlayout-compose:$composeConstraintVersion"
    const val composeLifecycle = "androidx.lifecycle:lifecycle-runtime-compose:$composeLifecycleVersion"

    // Coroutines
    private const val coroutineVersion = "1.6.4"
    val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVersion"

    // Kotlinx
    private const val kotlinxSerialization = "1.3.3"
    const val serializationCore =
        "org.jetbrains.kotlinx:kotlinx-serialization-core:${kotlinxSerialization}"


    // Material3
    private const val materialVersion = "1.0.1"
    val material3 = "androidx.compose.material3:material3:$materialVersion"

    // Splash
    private const val splashVersion = "1.0.0"
    const val splashScreen = "androidx.core:core-splashscreen:$splashVersion"

    // Dagger Hilt
    const val hiltVersion = "2.45"
    const val hilt = "com.google.dagger:hilt-android:$hiltVersion"
    const val hiltKapt = "com.google.dagger:hilt-compiler:$hiltVersion"
    const val hiltCompose = "androidx.hilt:hilt-navigation-compose:1.0.0"

    // JUnit
    private const val jUnitversion = "4.13.2"
    const val jUnit = "junit:junit:$jUnitversion"
    private const val jUnitComposeVersion = "1.3.3"
    const val composeJunit = "androidx.compose.ui:ui-test-junit4:$jUnitComposeVersion"

    // Espresso
    private const val espressoVersion = "3.5.1"
    const val expresso = "androidx.test.espresso:espresso-core:$espressoVersion"

}