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
package org.eu.zajc.ef.function.except;

import static org.eu.zajc.ef.Utilities.asUnchecked;

import java.util.function.Function;

import org.eu.zajc.ef.bifunction.except.EObjCharFunction;
import org.eu.zajc.ef.function.CharFunction;
import org.eu.zajc.ef.trifunction.except.EObjObjCharFunction;

/**
 * Represents a function that accepts a char-valued argument and produces a result.
 * This is the {@code char}-consuming primitive specialization for {@link EFunction}.
 *
 * <p>
 * Additionally, the functional method is allowed to throw a generic
 * {@link Throwable} of type {@code E}.
 *
 * <p>
 * This is a functional interface whose functional method is
 * {@link #applyChecked(char)}.
 *
 * @param <R>
 *            the type of the result of the function
 * @param <E>
 *            {@link Throwable} type
 *
 * @see Function
 * @see EObjCharFunction
 * @see EObjObjCharFunction
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface ECharFunction<R, E extends Throwable> extends CharFunction<R> {

	@Override
	default R apply(char p) {
		try {
			return applyChecked(p);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #apply(char)}, but throws a checked exception.
	 *
	 * @param p
	 *            the function argument
	 *
	 * @return the function result
	 *
	 * @throws E
	 *             the defined exception type
	 */
	R applyChecked(char p) throws E;

}
