buildscript {
    val navigationSafeArgsGradlePluginVersion1 by extra("2.7.6")
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.3" apply false
}
val navigationSafeArgsGradlePluginVersion by extra("2.7.6")
val navigationSafeArgsGradlePluginVersion1 by extra(navigationSafeArgsGradlePluginVersion)
val navigationSafeArgsGradlePluginVersion2 by extra(navigationSafeArgsGradlePluginVersion)
