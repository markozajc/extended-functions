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
package org.eu.zajc.ef.supplier.except;

import static org.eu.zajc.ef.Utilities.asUnchecked;

import java.util.function.Supplier;

import org.eu.zajc.ef.supplier.CharSupplier;

/**
 * Represents a supplier of {@code char}-valued results. This is the
 * {@code char}-producing primitive specialization of {@link ESupplier}.
 *
 * <p>
 * Additionally, the functional method is allowed to throw a generic
 * {@link Throwable} of type {@code E}.
 *
 * <p>
 * There is no requirement that a new or distinct result be returned each time the
 * supplier is invoked.
 *
 * <p>
 * This is a functional interface whose functional method is
 * {@link #getCheckedAsChar()}.
 *
 * @param <E>
 *            {@link Throwable} type
 *
 * @see Supplier
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface ECharSupplier<E extends Throwable> extends CharSupplier {

	@Override
	default char getAsChar() {
		try {
			return getCheckedAsChar();
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #getAsChar()}, but throws a checked exception.
	 *
	 * @return a result
	 *
	 * @throws E
	 *             the defined exception type
	 */
	char getCheckedAsChar() throws E;

	/**
	 * Same as {@link #getAsChar()}, but throws a checked exception.
	 *
	 * @return a result
	 *
	 * @throws E
	 *             the defined exception type
	 *
	 * @deprecated Since 1.5, for removal. Use {@link #getCheckedAsChar()} instead
	 */
	@Deprecated
	default char getChecked() throws E {
		return getCheckedAsChar();
	}

}
