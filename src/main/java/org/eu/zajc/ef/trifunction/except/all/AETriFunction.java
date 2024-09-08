// SPDX-License-Identifier: Apache-2.0
/*
 * extended-functions
 * Copyright 2021-2024 Marko Zajc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.eu.zajc.ef.trifunction.except.all;

import org.eu.zajc.ef.bifunction.except.EBiFunction;
import org.eu.zajc.ef.function.except.EFunction;
import org.eu.zajc.ef.function.except.all.AEFunction;
import org.eu.zajc.ef.trifunction.TriFunction;
import org.eu.zajc.ef.trifunction.except.ETriFunction;

/**
 * Represents a function that accepts two arguments and produces a result. This is
 * the three-arity specialization of {@link AEFunction}.
 *
 * <p>
 * Additionally, the functional method is allowed to throw an {@link Exception}.
 *
 * <p>
 * This is a functional interface whose functional method is
 * {@link #applyChecked(Object, Object, Object)}.
 *
 * @param <T>
 *            the type of the first argument to the function
 * @param <U>
 *            the type of the second argument to the function
 * @param <V>
 *            the type of the third argument to the function
 * @param <R>
 *            the type of the result of the function
 *
 * @see TriFunction
 * @see EFunction
 * @see EBiFunction
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface AETriFunction<T, U, V, R> extends ETriFunction<T, U, V, R, Exception> {}
