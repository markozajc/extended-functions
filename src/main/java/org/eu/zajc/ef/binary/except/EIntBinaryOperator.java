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
package org.eu.zajc.ef.binary.except;

import static org.eu.zajc.ef.Utilities.asUnchecked;

import java.util.function.*;

import org.eu.zajc.ef.unary.except.EIntUnaryOperator;

/**
 * Represents an operation upon two {@code int}-valued operands and producing an
 * {@code int}-valued result. This is the primitive type specialization of
 * {@link EBinaryOperator} for {@code int}.
 *
 * <p>
 * Additionally, the functional method is allowed to throw a generic
 * {@link Throwable} of type {@code E}.
 *
 * <p>
 * This is a functional interface whose functional method is
 * {@link #applyCheckedAsInt(int, int)}.
 *
 * @param <E>
 *            {@link Throwable} type
 *
 * @see BinaryOperator
 * @see EIntUnaryOperator
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface EIntBinaryOperator<E extends Throwable> extends IntBinaryOperator {

	@Override
	default int applyAsInt(int left, int right) {
		try {
			return applyCheckedAsInt(left, right);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #applyAsInt(int, int)}, but throws a checked exception.
	 *
	 * @param left
	 *            the first operand
	 * @param right
	 *            the second operand
	 *
	 * @return the operator result
	 *
	 * @throws E
	 *             the defined exception type
	 */
	int applyCheckedAsInt(int left, int right) throws E;

}
