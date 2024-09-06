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
package org.eu.zajc.ef.unary.except;

import java.util.function.UnaryOperator;

import org.eu.zajc.ef.function.except.EFunction;

/**
 * A variant of {@link UnaryOperator} capable of throwing a generic
 * {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the operand and result of the operator
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface EUnaryOperator<T, E extends Throwable> extends UnaryOperator<T>, EFunction<T, T, E> {}
