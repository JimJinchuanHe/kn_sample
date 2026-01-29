pluginManagement {
    repositories {
        maven("/Users/haoli/Desktop/kmp/KuiklyBase-kotlin-module/build/repo")
        maven("/Volumes/disk/git/kmp/20/build/repo")
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        maven("/Users/haoli/Desktop/kmp/KuiklyBase-kotlin-module/build/repo")
        maven("/Volumes/disk/git/kmp/20/build/repo")
        mavenCentral()
    }
}

rootProject.name = "c2k"

include(":bizA", ":bizB")
