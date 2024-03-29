// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {

    }
}

plugins {
    id("com.android.application") version "8.1.1" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("com.android.library") version "8.1.1" apply false
    id("org.jetbrains.kotlin.jvm") version "1.8.10" apply false
    id("com.google.dagger.hilt.android") version "2.46.1" apply false
    kotlin("kapt") version "1.9.0"
}