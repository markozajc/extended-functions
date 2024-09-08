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
package org.eu.zajc.ef.supplier.except.all;

import java.util.function.Supplier;

import org.eu.zajc.ef.supplier.except.EByteSupplier;

/**
 * Represents a supplier of {@code byte}-valued results. This is the
 * {@code byte}-producing primitive specialization of {@link AESupplier}.
 *
 * <p>
 * Additionally, the functional method is allowed to throw an {@link Exception}.
 *
 * <p>
 * There is no requirement that a new or distinct result be returned each time the
 * supplier is invoked.
 *
 * <p>
 * This is a functional interface whose functional method is
 * {@link #getCheckedAsByte()}.
 *
 * @see Supplier
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface AEByteSupplier extends EByteSupplier<Exception> {}
