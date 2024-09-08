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
package org.eu.zajc.ef.bipredicate.except;

import static org.eu.zajc.ef.Utilities.asUnchecked;

import java.util.function.BiPredicate;

import org.eu.zajc.ef.bipredicate.ObjBytePredicate;
import org.eu.zajc.ef.predicate.BytePredicate;
import org.eu.zajc.ef.tripredicate.ObjObjBytePredicate;

/**
 * Represents a predicate (boolean-valued function) of an object-valued and a
 * {@code byte}-valued argument. This is the {@code (reference, byte)} specialization
 * of {@link EBiPredicate}.
 *
 * <p>
 * Additionally, the functional method is allowed to throw a generic
 * {@link Throwable} of type {@code E}.
 *
 * <p>
 * This is a functional interface whose functional method is
 * {@link #testChecked(Object, byte)}.
 *
 * @param <T>
 *            the type of the first argument to the predicate
 * @param <E>
 *            {@link Throwable} type
 *
 * @see BiPredicate
 * @see BytePredicate
 * @see ObjObjBytePredicate
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface EObjBytePredicate<T, E extends Throwable> extends ObjBytePredicate<T> {

	@Override
	default boolean test(T t, byte p) {
		try {
			return testChecked(t, p);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #test(Object, byte)}, but throws a checked exception.
	 *
	 * @param t
	 *            the first input argument
	 * @param p
	 *            the second {@code byte} input argument
	 *
	 * @return {@code true} if the input arguments match the predicate, otherwise
	 *         {@code false}
	 *
	 * @throws E
	 *             the defined exception type
	 */
	boolean testChecked(T t, byte p) throws E;

}
