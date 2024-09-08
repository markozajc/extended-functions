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
package org.eu.zajc.ef.triconsumer;

import java.util.Objects;
import java.util.function.*;

import javax.annotation.Nonnull;

/**
 * Represents an operation that accepts two object-valued and one {@code long}-valued
 * argument, and returns no result. This is the {@code (reference, reference, long)}
 * specialization of {@link TriConsumer}. Unlike most other functional interfaces,
 * {@link ObjObjLongConsumer} is expected to operate via side-effects.
 *
 * <p>
 * This is a functional interface whose functional method is
 * {@link #accept(Object, Object, long)}.
 *
 * @param <T>
 *            the type of the object argument to the operation
 * @param <U>
 *            the type of the second argument to the operation
 *
 * @see TriConsumer
 * @see LongConsumer
 * @see ObjLongConsumer
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface ObjObjLongConsumer<T, U> {

	/**
	 * Performs this operation on the given arguments.
	 *
	 * @param t
	 *            the first input argument
	 * @param u
	 *            the second input argument
	 * @param p
	 *            the third ({@code long}) input argument
	 */
	void accept(T t, U u, long p);

	/**
	 * Returns a composed {@link ObjObjLongConsumer} that performs, in sequence, this
	 * operation followed by the {@code after} operation. If performing either operation
	 * throws an exception, it is relayed to the caller of the composed operation. If
	 * performing this operation throws an exception, the {@code after} operation will
	 * not be performed.
	 *
	 * @param after
	 *            the operation to perform after this operation
	 *
	 * @return a composed {@link ObjObjLongConsumer} that performs in sequence this
	 *         operation followed by the {@code after} operation
	 *
	 * @throws NullPointerException
	 *             if {@code after} is null
	 */
	@Nonnull
	default ObjObjLongConsumer<T, U> andThen(@Nonnull ObjObjLongConsumer<? super T, ? super U> after) {
		Objects.requireNonNull(after);

		return (t, u, p) -> {
			accept(t, u, p);
			after.accept(t, u, p);
		};
	}

}
