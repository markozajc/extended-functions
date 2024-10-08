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
package org.eu.zajc.ef.bifunction.except;

import static org.eu.zajc.ef.Utilities.asUnchecked;

import java.util.function.BiFunction;

import org.eu.zajc.ef.function.except.EFunction;
import org.eu.zajc.ef.trifunction.except.ETriFunction;

/**
 * Represents a function that accepts two arguments and produces a result. This is
 * the two-arity specialization of {@link EFunction}.
 *
 * <p>
 * Additionally, the functional method is allowed to throw a generic
 * {@link Throwable} of type {@code E}.
 *
 * <p>
 * This is a functional interface whose functional method is
 * {@link #applyChecked(Object, Object)}.
 *
 * @param <T>
 *            the type of the first argument to the function
 * @param <U>
 *            the type of the second argument to the function
 * @param <R>
 *            the type of the result of the function
 * @param <E>
 *            {@link Throwable} type
 *
 * @see BiFunction
 * @see EFunction
 * @see ETriFunction
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface EBiFunction<T, U, R, E extends Throwable> extends BiFunction<T, U, R> {

	@Override
	default R apply(T t, U u) {
		try {
			return applyChecked(t, u);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #apply(Object, Object)}, but throws a checked exception.
	 *
	 * @param t
	 *            the first function argument
	 * @param u
	 *            the second function argument
	 *
	 * @return the function result
	 *
	 * @throws E
	 *             the defined exception type
	 */
	R applyChecked(T t, U u) throws E;

}
