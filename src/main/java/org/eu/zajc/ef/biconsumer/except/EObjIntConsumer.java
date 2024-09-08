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

import java.util.function.*;

import org.eu.zajc.ef.consumer.execpt.EIntConsumer;
import org.eu.zajc.ef.triconsumer.except.EObjObjIntConsumer;

/**
 * Represents an operation that accepts an object-valued and an {@code int}-valued
 * argument, and returns no result. This is the {@code (reference, int)}
 * specialization of {@link EBiConsumer}. Unlike most other functional interfaces,
 * {@link EObjIntConsumer} is expected to operate via side-effects.
 *
 * <p>
 * Additionally, the functional method is allowed to throw a generic
 * {@link Throwable} of type {@code E}.
 *
 * <p>
 * This is a functional interface whose functional method is
 * {@link #acceptChecked(Object, int)}.
 *
 * @param <T>
 *            the type of the object argument to the operation
 * @param <E>
 *            {@link Throwable} type
 *
 * @see BiConsumer
 * @see EIntConsumer
 * @see EObjObjIntConsumer
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface EObjIntConsumer<T, E extends Throwable> extends ObjIntConsumer<T> {

	@Override
	default void accept(T t, int p) {
		try {
			acceptChecked(t, p);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #accept(Object, int)}, but throws a checked exception.
	 *
	 * @param t
	 *            the first input argument
	 * @param p
	 *            the second ({$code int})input argument
	 *
	 * @throws E
	 *             the defined exception type
	 */
	void acceptChecked(T t, int p) throws E;

}
