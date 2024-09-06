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
package org.eu.zajc.ef.predicate.except;

import static org.eu.zajc.ef.Utilities.asUnchecked;

import java.util.function.Predicate;

/**
 * Variant of {@link Predicate} capable of throwing a generic {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the input to the predicate
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface EPredicate<T, E extends Throwable> extends Predicate<T> {

	@Override
	default boolean test(T t) {
		try {
			return testChecked(t);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #test(Object)}, but throws a checked exception.
	 *
	 * @param t
	 *            the input argument
	 *
	 * @return {@code true} if the input argument matches the predicate, otherwise
	 *         {@code false}
	 *
	 * @throws E
	 *             the defined exception type
	 */
	boolean testChecked(T t) throws E;

}
