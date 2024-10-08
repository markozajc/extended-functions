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

import org.eu.zajc.ef.biconsumer.except.EBiConsumer;
import org.eu.zajc.ef.consumer.execpt.EConsumer;
import org.eu.zajc.ef.triconsumer.TriConsumer;

/**
 * Represents an operation that accepts three input arguments and returns no result.
 * This is the three-arity specialization of {@link EConsumer}. Unlike most other
 * functional interfaces, {@link ETriConsumer} is expected to operate via
 * side-effects.
 *
 * <p>
 * This is a functional interface whose functional method is
 * {@link #acceptChecked(Object, Object, Object)}.
 *
 * @param <T>
 *            the type of the first argument to the operation
 * @param <U>
 *            the type of the second argument to the operation
 * @param <V>
 *            the type of the third argument to the operation
 * @param <E>
 *            {@link Throwable} type
 *
 * @see TriConsumer
 * @see EConsumer
 * @see EBiConsumer
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface ETriConsumer<T, U, V, E extends Throwable> extends TriConsumer<T, U, V> {

	@Override
	default void accept(T t, U u, V v) {
		try {
			acceptChecked(t, u, v);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #accept(Object, Object, Object)}, but throws a checked exception.
	 *
	 * @param t
	 *            the first input argument
	 * @param u
	 *            the second input argument
	 * @param v
	 *            the third input argument
	 *
	 * @throws E
	 *             the defined exception type
	 */
	void acceptChecked(T t, U u, V v) throws E;

}
