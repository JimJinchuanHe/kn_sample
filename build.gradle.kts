plugins {
    kotlin("multiplatform") version "2.0.255-SNAPSHOT"
}

group = "com.example"
version = "1.0-SNAPSHOT"

kotlin {
    ohosArm64("bizB") {
        binaries {
            sharedLib {
                baseName = "bizB"
                freeCompilerArgs += listOf("-Xbinary=emitRuntime=noruntime", "-Xbinary=splitBCfile=false")
                linkerOpts += listOf("-L/Users/haoli/Desktop/hjc/c2k-runtime", "-lruntime")
            }
        }
    }
    
    sourceSets {
        val bizBMain by getting {
            dependsOn(getByName("commonMain"))
        }
    }
}
