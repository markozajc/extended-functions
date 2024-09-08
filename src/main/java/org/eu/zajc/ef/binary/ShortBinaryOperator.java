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
package org.eu.zajc.ef.binary;

import java.util.function.BinaryOperator;

import org.eu.zajc.ef.unary.ShortUnaryOperator;

/**
 * Represents an operation upon two {@code short}-valued operands and producing a
 * {@code short}-valued result. This is the primitive type specialization of
 * {@link BinaryOperator} for {@code short}.
 *
 * <p>
 * This is a functional interface whose functional method is
 * {@link #applyAsShort(short, short)}.
 *
 * @see BinaryOperator
 * @see ShortUnaryOperator
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface ShortBinaryOperator {

	/**
	 * Applies this operator to the given operands.
	 *
	 * @param left
	 *            the first operand
	 * @param right
	 *            the second operand
	 *
	 * @return the operator result
	 */
	short applyAsShort(short left, short right);

}
