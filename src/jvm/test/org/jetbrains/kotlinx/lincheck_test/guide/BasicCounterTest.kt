/*
 * Lincheck
 *
 * Copyright (C) 2019 - 2023 JetBrains s.r.o.
 *
 * This Source Code Form is subject to the terms of the
 * Mozilla Public License, v. 2.0. If a copy of the MPL was not distributed
 * with this file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.jetbrains.kotlinx.lincheck_test.guide

import org.jetbrains.kotlinx.lincheck.*
import org.jetbrains.kotlinx.lincheck.annotations.*
import org.jetbrains.kotlinx.lincheck.strategy.managed.modelchecking.*
import org.jetbrains.kotlinx.lincheck.strategy.managed.modelchecking.Trust.TrustOptions
import org.jetbrains.kotlinx.lincheck.strategy.stress.*
import org.junit.*

class Counter {
    @Volatile
    private var value = 0

    fun inc(): Int = ++value
    fun get() = value
}

class BasicCounterTest {
    private val c = Counter() // initial state

    // operations on the Counter
    @Operation
    fun inc() = c.inc()

    @Operation
    fun get() = c.get()

    //@Test // TODO: Please, uncomment me and comment the line below to run the test and get the output
    @Test(expected = AssertionError::class)
    fun stressTest() = StressOptions().check(this::class) // the magic button

    //@Test // TODO: Please, uncomment me and comment the line below to run the test and get the output
    //@Test(expected = AssertionError::class)

    //@Test // TODO: Please, uncomment me and comment the line below to run the test and get the output
    fun modelCheckingTest() = ModelCheckingOptions().check(this::class)

    /*
     * The following line will invoke the trust model checking procedure for verifying concurrent scenarios
     */
    //@Test // TODO: Please, uncomment me and comment the line below to run the test and get the output
    //fun trustTest() = TrustOptions().check(this::class)

}