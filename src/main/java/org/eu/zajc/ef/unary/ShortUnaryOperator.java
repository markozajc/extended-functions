// SPDX-License-Identifier: LGPL-3.0-only
/*
 * extended-functions
 * Copyright (C) 2021-2024 Marko Zajc
 *
 * This library is free software; you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License as published by the Free Software
 * Foundation, version 3.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with this
 * program. If not, see <https://www.gnu.org/licenses/>.
 */
package org.eu.zajc.ef.unary;

import java.util.Objects;
import java.util.function.UnaryOperator;

import javax.annotation.Nonnull;

/**
 * A {@link UnaryOperator} variant that takes and returns a primitive {@code short}.
 *
 * @author Marko Zajc
 */
public interface ShortUnaryOperator {

	/**
	 * Applies this operator to the given operand.
	 *
	 * @param operand
	 *            the operand
	 *
	 * @return the operator result
	 */
	short applyAsShort(short operand);

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
	 * @see #andThen(ShortUnaryOperator)
	 */
	@Nonnull
	default ShortUnaryOperator compose(@Nonnull ShortUnaryOperator before) {
		Objects.requireNonNull(before);
		return (short v) -> applyAsShort(before.applyAsShort(v));
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
	 * @see #compose(ShortUnaryOperator)
	 */
	default @Nonnull ShortUnaryOperator andThen(@Nonnull ShortUnaryOperator after) {
		Objects.requireNonNull(after);
		return (short t) -> after.applyAsShort(applyAsShort(t));
	}

	/**
	 * Returns a unary operator that always returns its input argument.
	 *
	 * @return a unary operator that always returns its input argument
	 */
	@Nonnull
	static ShortUnaryOperator identity() {
		return t -> t;
	}

}
