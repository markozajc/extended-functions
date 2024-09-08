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

import java.util.function.BinaryOperator;

import org.eu.zajc.ef.binary.ByteBinaryOperator;
import org.eu.zajc.ef.unary.except.EByteUnaryOperator;

/**
 * Represents an operation upon two {@code byte}-valued operands and producing a
 * {@code byte}-valued result. This is the primitive type specialization of
 * {@link EBinaryOperator} for {@code byte}.
 *
 * <p>
 * Additionally, the functional method is allowed to throw a generic
 * {@link Throwable} of type {@code E}.
 *
 * <p>
 * This is a functional interface whose functional method is
 * {@link #applyCheckedAsByte(byte, byte)}.
 *
 * @param <E>
 *            {@link Throwable} type
 *
 * @see BinaryOperator
 * @see EByteUnaryOperator
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface EByteBinaryOperator<E extends Throwable> extends ByteBinaryOperator {

	@Override
	default byte applyAsByte(byte left, byte right) {
		try {
			return applyCheckedAsByte(left, right);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #applyAsByte(byte, byte)}, but throws a checked exception.
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
	byte applyCheckedAsByte(byte left, byte right) throws E;

}
