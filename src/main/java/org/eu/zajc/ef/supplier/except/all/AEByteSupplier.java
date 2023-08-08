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
package org.eu.zajc.ef.supplier.except.all;

import org.eu.zajc.ef.supplier.ByteSupplier;
import org.eu.zajc.ef.supplier.except.EByteSupplier;

/**
 * Variant of {@link ByteSupplier} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 */
@FunctionalInterface
public interface AEByteSupplier extends EByteSupplier<Exception> {}
