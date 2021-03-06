/*
 * MIT License
 *
 * Copyright (c) 2019 Nicholas Doglio
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

/**
 * Find which updates are available by running
 *     `$ ./gradlew buildSrcVersions`
 * This will only update the comments.
 *
 * YOU are responsible for updating manually the dependency version. */
object Versions {
    const val appcompat: String = "1.0.2"

    const val constraintlayout: String = "2.0.0-alpha2"

    const val espresso_core: String = "3.1.1"

    const val androidx_test_runner: String = "1.1.1"

    const val com_airbnb_android: String = "3.3.1"

    const val com_android_tools_build_gradle: String = "3.3.2"

    const val lint_gradle: String = "26.3.2"

    const val de_fayard_buildsrcversions_gradle_plugin: String = "0.3.2"

    const val rxandroid: String = "2.1.1"

    const val rxjava: String = "2.2.7"

    const val junit: String = "4.12"

    const val org_gradle_kotlin_kotlin_dsl_gradle_plugin: String = "1.2.5"

    const val org_jetbrains_kotlin: String = "1.3.21" 

    /**
     *
     *   To update Gradle, edit the wrapper file at path:
     *      ./gradle/wrapper/gradle-wrapper.properties
     */
    object Gradle {
        const val runningVersion: String = "5.3"

        const val currentVersion: String = "5.3"

        const val nightlyVersion: String = "5.4-20190323000031+0000"

        const val releaseCandidate: String = ""
    }
}
