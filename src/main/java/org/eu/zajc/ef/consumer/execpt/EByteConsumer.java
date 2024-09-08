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
package org.eu.zajc.ef.consumer.execpt;

import static org.eu.zajc.ef.Utilities.asUnchecked;

import java.util.function.Consumer;

import org.eu.zajc.ef.biconsumer.except.EObjByteConsumer;
import org.eu.zajc.ef.consumer.ByteConsumer;
import org.eu.zajc.ef.triconsumer.except.EObjObjByteConsumer;

/**
 * Represents an operation that accepts a single {@code byte}-valued argument and
 * returns no result. This is the primitive type specialization of {@link EConsumer}
 * for {@code byte}. Unlike most other functional interfaces, {@link EByteConsumer}
 * is expected to operate via side-effects.
 *
 * <p>
 * Additionally, the functional method is allowed to throw a generic
 * {@link Throwable} of type {@code E}.
 *
 * <p>
 * This is a functional interface whose functional method is
 * {@link #acceptChecked(byte)}.
 *
 * @param <E>
 *            {@link Throwable} type
 *
 * @see Consumer
 * @see EObjByteConsumer
 * @see EObjObjByteConsumer
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface EByteConsumer<E extends Throwable> extends ByteConsumer {

	@Override
	default void accept(byte p) {
		try {
			acceptChecked(p);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #accept(byte)}, but throws a checked exception.
	 *
	 * @param p
	 *            the input argument
	 *
	 * @throws E
	 *             the defined exception type
	 */
	void acceptChecked(byte p) throws E;

}
