plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.org.jetbrains.kotlin.kapt)
    alias(libs.plugins.hilt)
    id("com.google.devtools.ksp")
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
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
    buildTypes {
        debug {
            val BASE_URL = "BASE_URL"
            val DEV_BASE_URL: String by project
            buildConfigField("String", BASE_URL,DEV_BASE_URL )

        }
        release {
            isMinifyEnabled = false
            val BASE_URL = "BASE_URL"
            val DEV_BASE_URL: String by project
            buildConfigField("String", BASE_URL,DEV_BASE_URL )
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
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
    implementation(project(":data"))
    implementation(project(":domainn"))
    implementation(project(":testutils"))
    implementation (libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.runtime.livedata)
    implementation(libs.androidx.hilt.common)
    implementation(libs.androidx.espresso.core)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation (libs.androidx.multidex)
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
    implementation (libs.androidx.hilt.navigation.compose)

    implementation (libs.androidx.work.rxjava2)

    //Room DB
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)

    //Work manager
    implementation (libs.androidx.work.runtime.ktx)
    implementation (libs.androidx.hilt.work)
    kapt (libs.androidx.hilt.compiler)

    //App center
    implementation (libs.appcenter.analytics)
    implementation (libs.appcenter.crashes)

    //Test dependencies
    implementation (libs.junit.jupiter.api)
    implementation (libs.kotlinx.coroutines.test)
    implementation (libs.mockk.android)
    testImplementation (libs.junit)
    testImplementation (libs.junit.jupiter.engine)
    testImplementation (libs.junit.jupiter.params)
    //noinspection UseTomlInstead
    testImplementation ("io.mockk:mockk-agent:1.13.5")
    androidTestImplementation (libs.androidx.junit)
    androidTestImplementation (libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.navigation.testing)
    androidTestImplementation (libs.kotlinx.coroutines.test.v171)

}

//kapt {
//    javacOptions {
//        option("-Adagger.hilt.android.internal.disableAndroidSuperclassValidation=true")
//    }
//}