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
package org.eu.zajc.ef.triconsumer.except.all;

import org.eu.zajc.ef.biconsumer.except.all.AEObjCharConsumer;
import org.eu.zajc.ef.consumer.execpt.all.AECharConsumer;
import org.eu.zajc.ef.triconsumer.TriConsumer;
import org.eu.zajc.ef.triconsumer.except.EObjObjCharConsumer;

/**
 * Represents an operation that accepts two object-valued and one {@code char}-valued
 * argument, and returns no result. This is the {@code (reference, reference, char)}
 * specialization of {@link AETriConsumer}. Unlike most other functional interfaces,
 * {@link AEObjObjCharConsumer} is expected to operate via side-effects.
 *
 * <p>
 * Additionally, the functional method is allowed to throw an {@link Exception}.
 *
 * <p>
 * Additionally, the functional method is allowed to throw a generic
 * {@link Throwable} of type {@code E}.
 *
 * <p>
 * This is a functional interface whose functional method is
 * {@link #acceptChecked(Object, Object, char)}.
 *
 * @param <T>
 *            the type of the object argument to the operation
 * @param <U>
 *            the type of the second argument to the operation
 *
 * @see TriConsumer
 * @see AECharConsumer
 * @see AEObjCharConsumer
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface AEObjObjCharConsumer<T, U> extends EObjObjCharConsumer<T, U, Exception> {}
