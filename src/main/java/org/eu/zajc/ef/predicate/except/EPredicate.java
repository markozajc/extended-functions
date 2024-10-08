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

import org.eu.zajc.ef.bipredicate.except.EBiPredicate;
import org.eu.zajc.ef.tripredicate.except.ETriPredicate;

/**
 * Represents a predicate (boolean-valued function) of one argument.
 *
 * <p>
 * Additionally, the functional method is allowed to throw a generic
 * {@link Throwable} of type {@code E}.
 *
 * <p>
 * This is a functional interface whose functional method is
 * {@link #testChecked(Object)}.
 *
 * @param <T>
 *            the type of the input to the predicate
 * @param <E>
 *            {@link Throwable} type
 *
 * @see Predicate
 * @see EBiPredicate
 * @see ETriPredicate
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface EPredicate<T, E extends Throwable> extends Predicate<T> {

	@Override
	default boolean test(T t) {
		try {
			return testChecked(t);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #test(Object)}, but throws a checked exception.
	 *
	 * @param t
	 *            the input argument
	 *
	 * @return {@code true} if the input argument matches the predicate, otherwise
	 *         {@code false}
	 *
	 * @throws E
	 *             the defined exception type
	 */
	boolean testChecked(T t) throws E;

}
