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

import java.util.function.*;

import org.eu.zajc.ef.bipredicate.except.EObjLongPredicate;
import org.eu.zajc.ef.tripredicate.except.EObjObjLongPredicate;

/**
 * Represents a predicate (boolean-valued function) of one {@code long}-valued
 * argument. This is the {@code long}-consuming primitive type specialization of
 * {@link Predicate}.
 *
 * <p>
 * Additionally, the functional method is allowed to throw a generic
 * {@link Throwable} of type {@code E}.
 *
 * <p>
 * This is a functional interface whose functional method is
 * {@link #testChecked(long)}.
 *
 * @param <E>
 *            {@link Throwable} type
 *
 * @see Predicate
 * @see EObjLongPredicate
 * @see EObjObjLongPredicate
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface ELongPredicate<E extends Throwable> extends LongPredicate {

	@Override
	default boolean test(long p) {
		try {
			return testChecked(p);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #test(long)}, but throws a checked exception.
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
	boolean testChecked(long p) throws E;

}
