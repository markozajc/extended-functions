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

import org.eu.zajc.ef.supplier.CharSupplier;

/**
 * A variant of {@link CharSupplier} capable of throwing a generic {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface ECharSupplier<E extends Throwable> extends CharSupplier {

	@Override
	default char getAsChar() {
		try {
			return getChecked();
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
	char getChecked() throws E;

}
