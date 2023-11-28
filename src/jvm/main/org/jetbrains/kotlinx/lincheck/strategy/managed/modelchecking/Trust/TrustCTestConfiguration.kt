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

 import org.jetbrains.kotlinx.lincheck.CTestConfiguration
 import org.jetbrains.kotlinx.lincheck.execution.ExecutionGenerator
 import org.jetbrains.kotlinx.lincheck.execution.ExecutionScenario
 import org.jetbrains.kotlinx.lincheck.strategy.Strategy
 import org.jetbrains.kotlinx.lincheck.strategy.managed.ManagedCTestConfiguration
 import org.jetbrains.kotlinx.lincheck.strategy.managed.ManagedStrategyGuarantee
 import org.jetbrains.kotlinx.lincheck.strategy.managed.modelchecking.ModelCheckingStrategy
 import org.jetbrains.kotlinx.lincheck.verifier.Verifier
 import java.lang.reflect.Method

 class TrustCTestConfiguration(testClass: Class<*>, iterations: Int, threads: Int, actorsPerThread: Int, actorsBefore: Int,
                               actorsAfter: Int, generatorClass: Class<out ExecutionGenerator>, verifierClass: Class<out Verifier>,
                               checkObstructionFreedom: Boolean, hangingDetectionThreshold: Int, invocationsPerIteration: Int,
                               guarantees: List<ManagedStrategyGuarantee>, minimizeFailedScenario: Boolean,
                               sequentialSpecification: Class<*>, timeoutMs: Long, eliminateLocalObjects: Boolean,
                               customScenarios: List<ExecutionScenario>
 ) : ManagedCTestConfiguration(
     testClass = testClass,
     iterations = iterations,
     threads = threads,
     actorsPerThread = actorsPerThread,
     actorsBefore = actorsBefore,
     actorsAfter = actorsAfter,
     generatorClass = generatorClass,
     verifierClass = verifierClass,
     checkObstructionFreedom = checkObstructionFreedom,
     hangingDetectionThreshold = hangingDetectionThreshold,
     invocationsPerIteration = invocationsPerIteration,
     guarantees = guarantees,
     minimizeFailedScenario = minimizeFailedScenario,
     sequentialSpecification = sequentialSpecification,
     timeoutMs = timeoutMs,
     eliminateLocalObjects = eliminateLocalObjects,
     customScenarios = customScenarios
 ) {
     override fun createStrategy(
         testClass: Class<*>,
         scenario: ExecutionScenario,
         validationFunctions: List<Method>,
         stateRepresentationMethod: Method?,
         verifier: Verifier
     ): Strategy
         = TrustStrategy(this, testClass, scenario, validationFunctions, stateRepresentationMethod, verifier)
 }