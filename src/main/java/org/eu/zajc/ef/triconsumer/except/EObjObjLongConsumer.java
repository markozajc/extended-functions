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

import org.eu.zajc.ef.biconsumer.except.EObjLongConsumer;
import org.eu.zajc.ef.consumer.execpt.ELongConsumer;
import org.eu.zajc.ef.triconsumer.*;

/**
 * Represents an operation that accepts two object-valued and one {@code long}-valued
 * argument, and returns no result. This is the {@code (reference, reference, long)}
 * specialization of {@link ETriConsumer}. Unlike most other functional interfaces,
 * {@link EObjObjLongConsumer} is expected to operate via side-effects.
 *
 * <p>
 * Additionally, the functional method is allowed to throw a generic
 * {@link Throwable} of type {@code E}.
 *
 * <p>
 * This is a functional interface whose functional method is
 * {@link #acceptChecked(Object, Object, long)}.
 *
 * @param <T>
 *            the type of the object argument to the operation
 * @param <U>
 *            the type of the second argument to the operation
 * @param <E>
 *            {@link Throwable} type
 *
 * @see TriConsumer
 * @see ELongConsumer
 * @see EObjLongConsumer
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface EObjObjLongConsumer<T, U, E extends Throwable> extends ObjObjLongConsumer<T, U> {

	@Override
	default void accept(T t, U u, long p) {
		try {
			acceptChecked(t, u, p);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #accept(Object, Object, long)}, but throws a checked exception.
	 *
	 * @param t
	 *            the first input argument
	 * @param u
	 *            the second input argument
	 * @param p
	 *            the third ({$code long})input argument
	 *
	 * @throws E
	 *             the defined exception type
	 */
	void acceptChecked(T t, U u, long p) throws E;

}
