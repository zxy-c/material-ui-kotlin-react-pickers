plugins {
    id("org.jetbrains.kotlin.js") version "1.4.21"
    `maven-publish`
}

group = "com.zxy"
version = "0.0.1"

repositories {
    mavenLocal()
    maven("https://kotlin.bintray.com/kotlin-js-wrappers/")
    maven("https://dl.bintray.com/samgarasx/kotlin-js-wrappers")
    mavenCentral()
    jcenter()
}

dependencies {
    val reactVersion = "17.0.0"
    val kotlinReactVersion = "17.0.0-pre.129"
    implementation(kotlin("stdlib-js"))

    implementation("org.jetbrains:kotlin-react:$kotlinReactVersion-kotlin-1.4.21")
    implementation("org.jetbrains:kotlin-react-dom:$kotlinReactVersion-kotlin-1.4.21")
    implementation("org.jetbrains:kotlin-styled:5.2.0-pre.129-kotlin-1.4.21")

    implementation("com.ccfraser.muirwik:muirwik-components:0.6.3_0")
    implementation(npm("@material-ui/pickers", "v4.0.0-alpha.12"))
}

kotlin {
    js {
        browser {
            webpackTask {
                cssSupport.enabled = true
            }

            runTask {
                cssSupport.enabled = true
            }

            testTask {
                useKarma {
                    useChromeHeadless()
                    webpackConfig.cssSupport.enabled = true
                }
            }
        }
        binaries.executable()
    }
}

publishing {
    repositories {
        mavenLocal()
    }
    publications {
        create<MavenPublication>("maven") {
            groupId = groupId
            artifactId = "material-ui-kotlin-react-pickers"
            version = version

            from(components["kotlin"])
        }
    }
}