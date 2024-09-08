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
package org.eu.zajc.ef.consumer;

import java.util.Objects;
import java.util.function.Consumer;

import javax.annotation.Nonnull;

import org.eu.zajc.ef.biconsumer.ObjCharConsumer;
import org.eu.zajc.ef.triconsumer.ObjObjCharConsumer;

/**
 * Represents an operation that accepts a single {@code char}-valued argument and
 * returns no result. This is the primitive type specialization of {@link Consumer}
 * for {@code char}. Unlike most other functional interfaces, {@link CharConsumer} is
 * expected to operate via side-effects.
 *
 * <p>
 * This is a functional interface whose functional method is {@link #accept(char)}.
 *
 * @see Consumer
 * @see ObjCharConsumer
 * @see ObjObjCharConsumer
 *
 * @author Marko Zajc
 */
public interface CharConsumer {

	/**
	 * Performs this operation on the given argument.
	 *
	 * @param p
	 *            the input argument
	 */
	void accept(char p);

	/**
	 * Returns a composed {@link CharConsumer} that performs, in sequence, this operation
	 * followed by the {@code after} operation. If performing either operation throws an
	 * exception, it is relayed to the caller of the composed operation. If performing
	 * this operation throws an exception, the {@code after} operation will not be
	 * performed.
	 *
	 * @param after
	 *            the operation to perform after this operation
	 *
	 * @return a composed {@link CharConsumer} that performs in sequence this operation
	 *         followed by the {@code after} operation
	 *
	 * @throws NullPointerException
	 *             if {@code after} is null
	 */
	@Nonnull
	default CharConsumer andThen(@Nonnull CharConsumer after) {
		Objects.requireNonNull(after);
		return t -> {
			accept(t);
			after.accept(t);
		};
	}

}
