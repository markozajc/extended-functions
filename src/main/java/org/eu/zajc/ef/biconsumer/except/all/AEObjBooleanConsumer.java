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
package org.eu.zajc.ef.biconsumer.except.all;

import java.util.function.BiConsumer;

import org.eu.zajc.ef.biconsumer.except.EObjBooleanConsumer;
import org.eu.zajc.ef.consumer.execpt.EBooleanConsumer;
import org.eu.zajc.ef.triconsumer.except.EObjObjBooleanConsumer;

/**
 * Represents an operation that accepts an object-valued and a {@code boolean}-valued
 * argument, and returns no result. This is the {@code (reference, boolean)}
 * specialization of {@link AEBiConsumer}. Unlike most other functional interfaces,
 * {@link AEObjBooleanConsumer} is expected to operate via side-effects.
 *
 * <p>
 * Additionally, the functional method is allowed to throw an {@link Exception}.
 *
 * <p>
 * This is a functional interface whose functional method is
 * {@link #acceptChecked(Object, boolean)}.
 *
 * @param <T>
 *            the type of the object argument to the operation
 *
 * @see BiConsumer
 * @see EBooleanConsumer
 * @see EObjObjBooleanConsumer
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface AEObjBooleanConsumer<T> extends EObjBooleanConsumer<T, Exception> {}
