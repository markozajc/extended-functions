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
package org.eu.zajc.ef.biconsumer.except;

import static org.eu.zajc.ef.Utilities.asUnchecked;

import org.eu.zajc.ef.biconsumer.ObjBooleanConsumer;

/**
 * A variant of {@link ObjBooleanConsumer} capable of throwing a generic
 * {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the operation
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface EObjBooleanConsumer<T, E extends Throwable> extends ObjBooleanConsumer<T> {

	@Override
	default void accept(T t, boolean p) {
		try {
			acceptChecked(t, p);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #accept(Object, boolean)}, but throws a checked exception.
	 *
	 * @param t
	 *            the first input argument
	 * @param p
	 *            the second ({$code boolean})input argument
	 *
	 * @throws E
	 *             the defined exception type
	 */
	void acceptChecked(T t, boolean p) throws E;

}
