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
package org.eu.zajc.ef.triconsumer.except;

import static org.eu.zajc.ef.Utilities.asUnchecked;

import org.eu.zajc.ef.biconsumer.except.EObjBooleanConsumer;
import org.eu.zajc.ef.consumer.execpt.EBooleanConsumer;
import org.eu.zajc.ef.triconsumer.*;

/**
 * Represents an operation that accepts two object-valued and one
 * {@code boolean}-valued argument, and returns no result. This is the
 * {@code (reference, reference, boolean)} specialization of {@link ETriConsumer}.
 * Unlike most other functional interfaces, {@link EObjObjBooleanConsumer} is
 * expected to operate via side-effects.
 *
 * <p>
 * Additionally, the functional method is allowed to throw a generic
 * {@link Throwable} of type {@code E}.
 *
 * <p>
 * This is a functional interface whose functional method is
 * {@link #acceptChecked(Object, Object, boolean)}.
 *
 * @param <T>
 *            the type of the object argument to the operation
 * @param <U>
 *            the type of the second argument to the operation
 * @param <E>
 *            {@link Throwable} type
 *
 * @see TriConsumer
 * @see EBooleanConsumer
 * @see EObjBooleanConsumer
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface EObjObjBooleanConsumer<T, U, E extends Throwable> extends ObjObjBooleanConsumer<T, U> {

	@Override
	default void accept(T t, U u, boolean p) {
		try {
			acceptChecked(t, u, p);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #accept(Object, Object, boolean)}, but throws a checked exception.
	 *
	 * @param t
	 *            the first input argument
	 * @param u
	 *            the second input argument
	 * @param p
	 *            the third ({$code boolean})input argument
	 *
	 * @throws E
	 *             the defined exception type
	 */
	void acceptChecked(T t, U u, boolean p) throws E;

}
