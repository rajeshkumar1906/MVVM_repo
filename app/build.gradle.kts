plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.org.jetbrains.kotlin.kapt)
}

android {
    namespace = "com.raaz.mvvm_repo"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.raaz.mvvm_repo"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            val BASE_URL = "BASE_URL"
            val DEV_BASE_URL: String by project
            buildConfigField("String", BASE_URL,DEV_BASE_URL )
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

   flavorDimensions ("MVVM")

    productFlavors {
      val BASE_URL = "BASE_URL"
        create("dev") {
            versionNameSuffix = "-Dev"
            val DEV_BASE_URL: String by project
            buildConfigField("String", BASE_URL,DEV_BASE_URL )
        }
        create("staging") {
            versionNameSuffix = "-Stage"
            val DEV_BASE_URL: String by project
            buildConfigField("String", BASE_URL,DEV_BASE_URL )
        }
        create("production") {
            versionNameSuffix = "-Production"
            val DEV_BASE_URL: String by project
            buildConfigField("String", BASE_URL,DEV_BASE_URL )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    // DI Hilt

    implementation (libs.hilt.android)
    kapt (libs.hilt.android.compiler)
    // Retrofit for network calling
    implementation (libs.retrofit)
    implementation (libs.converter.gson)
    implementation (libs.logging.interceptor)
    //Coroutines
    implementation (libs.kotlinx.coroutines.android)
    implementation (libs.kotlinx.coroutines.core)
}