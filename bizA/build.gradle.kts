plugins {
    kotlin("multiplatform")
}

kotlin {
    ohosArm64("ohosArm64") {
        compilations.all {
            compilerOptions.configure {
                freeCompilerArgs.add("-Xbinary=emitRuntime=noruntime")
                freeCompilerArgs.add("-Xbinary=kotlinModuleFilter=bizB")
                freeCompilerArgs.add("-Xbinary=moduleExclude=stdlib")
                // freeCompilerArgs.add("-Xbinary=moduleIncludeOnly=stdlib")
                // freeCompilerArgs.add("-Xsave-llvm-ir-after=Codegen")
                // freeCompilerArgs.add("-Xsave-llvm-ir-directory=/Users/haoli/Desktop/kmp/module/bc_file")
                // freeCompilerArgs.add("-Xphases-to-dump-after=all")
            }
        }
        binaries {
            sharedLib {
                baseName = "bizA"
                // linkerOpts("-L/Users/haoli/Desktop/kmp/module/separate", "-lruntime")
                // linkerOpts("-L/Users/haoli/Desktop/kmp/module/separate", "-lbizB")
                // linkerOpts("-L/Users/haoli/Desktop/kmp/module/separate", "-lstd")
            }
        }
    }

    sourceSets {
        val ohosArm64Main by getting {
            dependencies {
                implementation(project(":bizB"))
            }
        }
    }
}
