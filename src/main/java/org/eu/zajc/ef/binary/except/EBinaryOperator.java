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

import org.eu.zajc.ef.bifunction.except.EBiFunction;

/**
 * A variant of {@link UnaryOperator} capable of throwing a generic
 * {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the operands and result of the operator
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface EBinaryOperator<T, E extends Throwable> extends BinaryOperator<T>, EBiFunction<T, T, T, E> {

	@Override
	default T apply(T left, T right) {
		try {
			return apply(left, right);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #apply(Object, Object)}, but throws a checked exception.
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
	@Override
	T applyChecked(T left, T right) throws E;

}
