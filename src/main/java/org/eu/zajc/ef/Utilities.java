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
package org.eu.zajc.ef;

import javax.annotation.Nonnull;

/**
 * Utilities for internal use within extended-functions
 *
 * @author Marko Zajc
 */
public class Utilities {

	/**
	 * Rethrows a checked exception as unchecked using generics trickery (the exception
	 * is not changed or wrapped in a {@link RuntimeException} - it is thrown as-is).
	 *
	 * @param <X>
	 *            the exception type
	 * @param ex
	 *            the exception to throw as unchecked
	 *
	 * @return the exception itself to support {@code throws asUnchecked(e);}. Note that
	 *         it is thrown in this method and nothing is ever returned
	 *
	 * @throws X
	 *             the exception you provide. Always thrown.
	 */
	@SuppressWarnings("unchecked")
	public static <X extends Throwable> RuntimeException asUnchecked(@Nonnull Throwable ex) throws X {
		throw (X) ex;
	}

	private Utilities() {}

}
