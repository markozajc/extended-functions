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
package org.eu.zajc.ef.unary;

import java.util.Objects;
import java.util.function.UnaryOperator;

import javax.annotation.Nonnull;

import org.eu.zajc.ef.binary.ByteBinaryOperator;

/**
 * Represents an operation on a single {@code byte}-valued operand that produces an
 * {@code byte}-valued result. This is the primitive type specialization of
 * {@link UnaryOperator} for {@code byte}.
 *
 * <p>
 * This is a functional interface whose functional method is
 * {@link #applyAsByte(byte)}.
 *
 * @see UnaryOperator
 * @see ByteBinaryOperator
 *
 * @author Marko Zajc
 */
public interface ByteUnaryOperator {

	/**
	 * Applies this operator to the given operand.
	 *
	 * @param operand
	 *            the operand
	 *
	 * @return the operator result
	 */
	byte applyAsByte(byte operand);

	/**
	 * Returns a composed operator that first applies the {@code before} operator to its
	 * input, and then applies this operator to the result. If evaluation of either
	 * operator throws an exception, it is relayed to the caller of the composed
	 * operator.
	 *
	 * @param before
	 *            the operator to apply before this operator is applied
	 *
	 * @return a composed operator that first applies the {@code before} operator and
	 *         then applies this operator
	 *
	 * @throws NullPointerException
	 *             if before is null
	 *
	 * @see #andThen(ByteUnaryOperator)
	 */
	@Nonnull
	default ByteUnaryOperator compose(@Nonnull ByteUnaryOperator before) {
		Objects.requireNonNull(before);
		return (byte v) -> applyAsByte(before.applyAsByte(v));
	}

	/**
	 * Returns a composed operator that first applies this operator to its input, and
	 * then applies the {@code after} operator to the result. If evaluation of either
	 * operator throws an exception, it is relayed to the caller of the composed
	 * operator.
	 *
	 * @param after
	 *            the operator to apply after this operator is applied
	 *
	 * @return a composed operator that first applies this operator and then applies the
	 *         {@code after} operator
	 *
	 * @throws NullPointerException
	 *             if after is null
	 *
	 * @see #compose(ByteUnaryOperator)
	 */
	@Nonnull
	default ByteUnaryOperator andThen(@Nonnull ByteUnaryOperator after) {
		Objects.requireNonNull(after);
		return (byte t) -> after.applyAsByte(applyAsByte(t));
	}

	/**
	 * Returns a unary operator that always returns its input argument.
	 *
	 * @return a unary operator that always returns its input argument
	 */
	@Nonnull
	static ByteUnaryOperator identity() {
		return t -> t;
	}

}
