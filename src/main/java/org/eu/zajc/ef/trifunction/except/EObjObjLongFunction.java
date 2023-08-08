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
package org.eu.zajc.ef.trifunction.except;

import static org.eu.zajc.ef.Utilities.asUnchecked;

import org.eu.zajc.ef.trifunction.ObjObjLongFunction;

/**
 * Variant of {@link ObjObjLongFunction} capable of throwing a generic
 * {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the function
 * @param <U>
 *            the type of the second argument to the function
 * @param <R>
 *            the type of the result of the function
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface EObjObjLongFunction<T, U, R, E extends Throwable> extends ObjObjLongFunction<T, U, R> {

	@Override
	default R apply(T t, U u, long p) {
		try {
			return applyChecked(t, u, p);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #apply(Object, Object, long)}, but throws a checked exception.
	 *
	 * @param t
	 *            the first function argument
	 * @param u
	 *            the second function argument
	 * @param p
	 *            the third ({@code long}) function argument
	 *
	 * @return the function result
	 *
	 * @throws E
	 *             the defined exception type
	 */
	R applyChecked(T t, U u, long p) throws E;

}
