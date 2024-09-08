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
package org.eu.zajc.ef.predicate.except;

import static org.eu.zajc.ef.Utilities.asUnchecked;

import java.util.function.Predicate;

import org.eu.zajc.ef.bipredicate.except.EObjCharPredicate;
import org.eu.zajc.ef.predicate.CharPredicate;
import org.eu.zajc.ef.tripredicate.except.EObjObjCharPredicate;

/**
 * Represents a predicate (boolean-valued function) of one {@code char}-valued
 * argument. This is the {@code char}-consuming primitive type specialization of
 * {@link Predicate}.
 *
 * <p>
 * Additionally, the functional method is allowed to throw a generic
 * {@link Throwable} of type {@code E}.
 *
 * <p>
 * This is a functional interface whose functional method is
 * {@link #testChecked(char)}.
 *
 * @param <E>
 *            {@link Throwable} type
 *
 * @see Predicate
 * @see EObjCharPredicate
 * @see EObjObjCharPredicate
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface ECharPredicate<E extends Throwable> extends CharPredicate {

	@Override
	default boolean test(char p) {
		try {
			return testChecked(p);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #test(char)}, but throws a checked exception.
	 *
	 * @param p
	 *            the input argument
	 *
	 * @return {@code true} if the input argument matches the predicate, otherwise
	 *         {@code false}
	 *
	 * @throws E
	 *             the defined exception type
	 */
	boolean testChecked(char p) throws E;

}
