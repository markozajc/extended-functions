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
package org.eu.zajc.ef.unary.except;

import static org.eu.zajc.ef.Utilities.asUnchecked;

import org.eu.zajc.ef.predicate.except.EBooleanPredicate;
import org.eu.zajc.ef.unary.BooleanUnaryOperator;

/**
 * A variant of {@link BooleanUnaryOperator} capable of throwing a generic
 * {@link Throwable}.
 *
 * This is equivalent to {@link EBooleanPredicate}
 *
 * @author Marko Zajc
 *
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface EBooleanUnaryOperator<E extends Throwable> extends BooleanUnaryOperator {

	@Override
	default boolean applyAsBoolean(boolean operand) {
		try {
			return applyCheckedAsBoolean(operand);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #applyAsBoolean(boolean)}, but throws a checked exception.
	 *
	 * @param operand
	 *            the operand
	 *
	 * @return the operator result
	 *
	 * @throws E
	 *             the defined exception type
	 */
	boolean applyCheckedAsBoolean(boolean operand) throws E;

}
