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
package org.eu.zajc.ef.predicate.except.all;

import org.eu.zajc.ef.predicate.BooleanPredicate;
import org.eu.zajc.ef.predicate.except.EBooleanPredicate;
import org.eu.zajc.ef.unary.except.all.AEBooleanUnaryOperator;

/**
 * Variant of {@link BooleanPredicate} capable of throwing an {@link Exception}.
 *
 * This is equivalent to {@link AEBooleanUnaryOperator}
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface AEBooleanPredicate extends EBooleanPredicate<Exception> {}
