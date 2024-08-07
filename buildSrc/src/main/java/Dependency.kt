object Dependency {

    private const val CORE_VERSION = "1.10.1"
    private const val CONSTRAINT_LAYOUT_VERSION = "1.0.1"
    private const val COIL_VERSION = "2.4.0"
    private const val JUNIT_VERSION = "4.13.2"
    private const val JUNIT_KTS_VERSION = "1.1.5"
    private const val ESPRESSO_VERSION = "3.5.1"
    private const val HILT_VERSION = "2.51.1"
    private const val DAGGER_VERSION = "2.51.1"
    private const val RETROFIT_VERSION = "2.9.0"
    private const val LOGGING_VERSION = "5.0.0-alpha.11"
    private const val KOTLIN_COROUTINES_VERSION = "1.6.4"
    private const val LIFECYCLE_VERSION = "2.6.1"
    private const val KOTLIN_SERIALIZATION_VERSION = "1.5.0"
    private const val LOTTIE_VERSION = "6.0.1"
    private const val DATASTORE_VERSION = "1.0.0"
    private const val ROOM_VERSION = "2.5.1"
    private const val SPLASH_SCREEN_VERSION = "1.0.0"
    private const val KOTLIN_BOM = "1.8.0"
    private const val ACTIVITY_COMPOSE = "1.7.2"
    private const val COMPOSE_BOM = "2024.06.00"
    private const val NAVIGATION_COMPOSE = "2.8.0-beta02"
    private const val HILT_NAVIGATION_VERSION = "1.0.0"
    private const val MATERIAL3_VERSION = "1.1.0-beta01"
    private const val COMPOSE_FOUNDATION_VERSION = "1.4.3"
    private const val ANDROID_COMPAT_VERSION = "1.6.1"
    private const val GOOGLE_MATERIAL_VERSION = "1.9.0"
    private const val SYSTEM_UI_CONTROLLER_VERSION = "0.31.0-alpha"
    private const val ACCOMPANIST = "0.31.0-alpha"
    private const val COMPOSE_BETA = "1.7.0-beta06"

    const val androidxCore = "androidx.core:core-ktx:$CORE_VERSION"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout-compose:$CONSTRAINT_LAYOUT_VERSION"
    const val kotlinBom = "org.jetbrains.kotlin:kotlin-bom:$KOTLIN_BOM"
    const val junit = "junit:junit:$JUNIT_VERSION"
    const val junitExtension = "androidx.test.ext:junit:$JUNIT_KTS_VERSION"
    const val espresso = "androidx.test.espresso:espresso-core:$ESPRESSO_VERSION"

    const val hilt = "com.google.dagger:hilt-android:$HILT_VERSION"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:$HILT_VERSION"
    const val hiltNavigation = "androidx.hilt:hilt-navigation-compose:$HILT_NAVIGATION_VERSION"

    const val dagger = "com.google.dagger:dagger-android:$DAGGER_VERSION"

    const val retrofit = "com.squareup.retrofit2:retrofit:$RETROFIT_VERSION"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:$RETROFIT_VERSION"

    const val logging = "com.squareup.okhttp3:logging-interceptor:$LOGGING_VERSION"

    const val coroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:$KOTLIN_COROUTINES_VERSION"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:$LIFECYCLE_VERSION"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$LIFECYCLE_VERSION"
    const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:$LIFECYCLE_VERSION"

    const val activityCompose = "androidx.activity:activity-compose:$ACTIVITY_COMPOSE"
    const val composeBom = "androidx.compose:compose-bom:$COMPOSE_BOM"
    const val composeUi = "androidx.compose.ui:ui"
    const val composeRuntime = "androidx.compose.runtime:runtime"
    const val composeUiGraphics = "androidx.compose.ui:ui-graphics"
    const val composeUiPreviewTool = "androidx.compose.ui:ui-tooling-preview"
    const val composeMaterial3 = "androidx.compose.material3:material3"
    const val composeJunit = "androidx.compose.ui:ui-test-junit4"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling"
    const val composeTestManifest = "androidx.compose.ui:ui-test-manifest"
    const val navigationCompose = "androidx.navigation:navigation-compose:$NAVIGATION_COMPOSE"
    const val appCompat = "androidx.appcompat:appcompat:$ANDROID_COMPAT_VERSION"
    const val kotlinxSerialization =
        "org.jetbrains.kotlinx:kotlinx-serialization-json:$KOTLIN_SERIALIZATION_VERSION"
    const val googleMaterial = "com.google.android.material:material:$GOOGLE_MATERIAL_VERSION"

    const val lottie = "com.airbnb.android:lottie-compose:$LOTTIE_VERSION"

    const val coil = "io.coil-kt:coil-compose:$COIL_VERSION"

    const val dataStore = "androidx.datastore:datastore-preferences:$DATASTORE_VERSION"
    const val roomRuntime = "androidx.room:room-runtime:$ROOM_VERSION"
    const val roomCompiler = "androidx.room:room-compiler:$ROOM_VERSION"
    const val roomKtx = "androidx.room:room-ktx:$ROOM_VERSION"

    const val splashScreen = "androidx.core:core-splashscreen:$SPLASH_SCREEN_VERSION-beta02"

    const val composeFoundation =
        "androidx.compose.foundation:foundation:$COMPOSE_FOUNDATION_VERSION"

    const val encryptedSharedPreference = "androidx.security:security-crypto:1.1.0-alpha06"

    @JvmField
    val composeGroup = listOf(
        activityCompose,
        composeBom,
        composeUi,
        composeRuntime,
        composeUiGraphics,
        composeUiPreviewTool,
        composeMaterial3,
        composeJunit,
        composeUiTooling,
        composeTestManifest,
        navigationCompose,
        composeFoundation
    )
}