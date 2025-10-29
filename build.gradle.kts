plugins {
    kotlin("multiplatform") version "2.0.255-SNAPSHOT"
}

group = "com.example"
version = "1.0-SNAPSHOT"

kotlin {
    ohosArm64("bizA") {
        binaries {
            sharedLib {
                baseName = "bizA"
                freeCompilerArgs += listOf("-Xbinary=emitRuntime=all", "-Xbinary=splitBCfile=false")
                linkerOpts += listOf(
                    "-L/Users/haoli/Desktop/hjc/c2k-runtime", "-lruntime",
                    "-L/Users/haoli/Desktop/kmp/kn_samples_add", "-lbizB"  // 添加bizB动态库的路径和链接
                )
            }
        }
        
        // 配置 cinterop 来调用 B.so 中的函数
        compilations["main"].cinterops {
            val bizB by creating {
                defFile(project.file("src/bizAMain/interop/bizB.def"))
            }
        }
    }
    
    sourceSets {
        val bizAMain by getting {
            dependsOn(getByName("commonMain"))
            // 移除了对bizBMain的依赖
        }
    }
}
