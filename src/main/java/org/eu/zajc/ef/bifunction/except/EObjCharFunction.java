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

import org.eu.zajc.ef.bifunction.ObjCharFunction;
import org.eu.zajc.ef.function.except.ECharFunction;
import org.eu.zajc.ef.trifunction.except.EObjObjCharFunction;

/**
 * Represents a function that accepts an object-valued and a {@code char}-valued
 * argument, and produces a result. This is the {@code (reference, char)}
 * specialization of {@link EBiFunction}.
 *
 * <p>
 * Additionally, the functional method is allowed to throw a generic
 * {@link Throwable} of type {@code E}.
 *
 * <p>
 * This is a functional interface whose functional method is
 * {@link #applyChecked(Object, char)}.
 *
 * @param <T>
 *            the type of the first argument to the function
 * @param <R>
 *            the type of the result of the function
 * @param <E>
 *            {@link Throwable} type
 *
 * @see BiFunction
 * @see ECharFunction
 * @see EObjObjCharFunction
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface EObjCharFunction<T, R, E extends Throwable> extends ObjCharFunction<T, R> {

	@Override
	default R apply(T t, char p) {
		try {
			return applyChecked(t, p);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #apply(Object, char)}, but throws a checked exception.
	 *
	 * @param t
	 *            the first function argument
	 * @param b
	 *            the second ({@code char}) function argument
	 *
	 * @return the function result
	 *
	 * @throws E
	 *             the defined exception type
	 */
	R applyChecked(T t, char b) throws E;

}
