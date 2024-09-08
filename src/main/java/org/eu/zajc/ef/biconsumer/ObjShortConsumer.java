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
package org.eu.zajc.ef.biconsumer;

import java.util.Objects;
import java.util.function.BiConsumer;

import javax.annotation.Nonnull;

import org.eu.zajc.ef.consumer.ShortConsumer;
import org.eu.zajc.ef.triconsumer.ObjObjShortConsumer;

/**
 * Represents an operation that accepts an object-valued and a {@code short}-valued
 * argument, and returns no result. This is the {@code (reference, short)}
 * specialization of {@link BiConsumer}. Unlike most other functional interfaces,
 * {@link ObjShortConsumer} is expected to operate via side-effects.
 *
 * <p>
 * This is a functional interface whose functional method is
 * {@link #accept(Object, short)}.
 *
 * @param <T>
 *            the type of the object argument to the operation
 *
 * @see BiConsumer
 * @see ShortConsumer
 * @see ObjObjShortConsumer
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface ObjShortConsumer<T> {

	/**
	 * Performs this operation on the given arguments.
	 *
	 * @param t
	 *            the first input argument
	 * @param p
	 *            the second ({@code short}) input argument
	 */
	void accept(T t, short p);

	/**
	 * Returns a composed {@link ObjShortConsumer} that performs, in sequence, this
	 * operation followed by the {@code after} operation. If performing either operation
	 * throws an exception, it is relayed to the caller of the composed operation. If
	 * performing this operation throws an exception, the {@code after} operation will
	 * not be performed.
	 *
	 * @param after
	 *            the operation to perform after this operation
	 *
	 * @return a composed {@link ObjShortConsumer} that performs in sequence this
	 *         operation followed by the {@code after} operation
	 *
	 * @throws NullPointerException
	 *             if {@code after} is null
	 */
	@Nonnull
	default ObjShortConsumer<T> andThen(@Nonnull ObjShortConsumer<T> after) {
		Objects.requireNonNull(after);
		return (t, p) -> {
			accept(t, p);
			after.accept(t, p);
		};
	}

}
