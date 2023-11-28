/*
 * Lincheck
 *
 * Copyright (C) 2019 - 2023 JetBrains s.r.o.
 *
 * This Source Code Form is subject to the terms of the
 * Mozilla Public License, v. 2.0. If a copy of the MPL was not distributed
 * with this file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.jetbrains.kotlinx.lincheck.strategy.managed.modelchecking.Trust

import org.jetbrains.kotlinx.lincheck.execution.ExecutionScenario
import org.jetbrains.kotlinx.lincheck.strategy.LincheckFailure
import org.jetbrains.kotlinx.lincheck.strategy.managed.ManagedStrategy
import org.jetbrains.kotlinx.lincheck.strategy.managed.modelchecking.ModelCheckingCTestConfiguration
import org.jetbrains.kotlinx.lincheck.verifier.Verifier
import java.lang.reflect.Method

class TrustStrategy(testCfg: TrustCTestConfiguration,
                    testClass: Class<*>,
                    scenario: ExecutionScenario,
                    validationFunctions: List<Method>,
                    stateRepresentation: Method?,
                    verifier: Verifier
) : ManagedStrategy(testClass, scenario, verifier, validationFunctions, stateRepresentation, testCfg){
    override fun runImpl(): LincheckFailure? {
        TODO("Not yet implemented")
    }

    override fun shouldSwitch(iThread: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun chooseThread(iThread: Int): Int {
        TODO("Not yet implemented")
    }
}