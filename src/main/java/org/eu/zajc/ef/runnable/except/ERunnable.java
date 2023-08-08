// SPDX-License-Identifier: LGPL-3.0-only
/*
 * extended-functions
 * Copyright (C) 2021-2023 Marko Zajc
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
package org.eu.zajc.ef.runnable.except;

import static org.eu.zajc.ef.Utilities.asUnchecked;

/**
 * Variant of {@link Runnable} capable of throwing a generic {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface ERunnable<E extends Throwable> extends Runnable {

	@Override
	default void run() {
		try {
			runChecked();
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #run()}, but throws a checked exception.
	 *
	 * @throws E
	 *             the defined exception type
	 */
	void runChecked() throws E;

}
