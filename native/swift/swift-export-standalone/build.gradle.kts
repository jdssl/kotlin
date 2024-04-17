import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile
import org.jetbrains.kotlin.kotlinNativeDist

plugins {
    kotlin("jvm")
    id("jps-compatible")
}

description = "Runner for Swift Export"

kotlin {
    explicitApi()
}

dependencies {
    compileOnly(kotlinStdlib())

    implementation(project(":native:swift:sir"))
    implementation(project(":native:swift:sir-compiler-bridge"))
    implementation(project(":native:swift:sir-light-classes"))
    implementation(project(":native:swift:sir-printer"))

    implementation(project(":analysis:analysis-api"))
    implementation(project(":analysis:analysis-api-standalone"))

    implementation(project(":native:analysis-api-klib-reader"))

    testApi(platform(libs.junit.bom))
    testRuntimeOnly(libs.junit.jupiter.engine)
    testImplementation(libs.junit.jupiter.api)

    testRuntimeOnly(projectTests(":analysis:low-level-api-fir"))
    testRuntimeOnly(projectTests(":analysis:analysis-api-impl-base"))
    testImplementation(projectTests(":analysis:analysis-api-fir"))
    testImplementation(projectTests(":analysis:analysis-test-framework"))
    testImplementation(projectTests(":compiler:tests-common"))
    testImplementation(projectTests(":compiler:tests-common-new"))
    testImplementation(projectTests(":native:native.tests"))
}

sourceSets {
    "main" { projectDefault() }
    "test" {
        projectDefault()
        generatedTestDir()
    }
}

val testDataDir = projectDir.resolve("testData")

val test by nativeTest("test", null) {
    systemProperty("kotlin.native.home", kotlinNativeDist.absolutePath)
    inputs.dir(testDataDir)
    workingDir = rootDir
    useJUnitPlatform { }
}

if (kotlinBuildProperties.isSwiftExportPluginPublishingEnabled) {
    publish()
}

runtimeJar()
sourcesJar()
javadocJar()

testsJar()

tasks.withType<KotlinJvmCompile> {
    compilerOptions.freeCompilerArgs.add("-Xcontext-receivers")
}
