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
package org.eu.zajc.ef.tripredicate.except;

import static org.eu.zajc.ef.Utilities.asUnchecked;

import org.eu.zajc.ef.tripredicate.ObjObjIntPredicate;

/**
 * A variant of {@link ObjObjIntPredicate} capable of throwing a generic
 * {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the predicate
 * @param <U>
 *            the type of the second argument the predicate
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface EObjObjIntPredicate<T, U, E extends Throwable> extends ObjObjIntPredicate<T, U> {

	@Override
	default boolean test(T t, U u, int p) {
		try {
			return testChecked(t, u, p);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #test(Object, Object, int)}, but throws a checked exception.
	 *
	 * @param t
	 *            the first input argument
	 * @param u
	 *            the second input argument
	 * @param p
	 *            the third ({@code int}) input argument
	 *
	 * @return {@code true} if the input arguments match the predicate, otherwise
	 *         {@code false}
	 *
	 * @throws E
	 *             the defined exception type
	 */
	boolean testChecked(T t, U u, int p) throws E;

}
