plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.org.jetbrains.kotlin.kapt)
}

android {
    namespace = "com.raaz.testutils"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation (libs.rxjava)

    // DI Hilt
    implementation (libs.hilt.android.v2461)
    kapt (libs.hilt.android.compiler.v2461)

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