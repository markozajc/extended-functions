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

import org.eu.zajc.ef.biconsumer.except.all.AEBiConsumer;
import org.eu.zajc.ef.consumer.execpt.all.AEConsumer;
import org.eu.zajc.ef.triconsumer.TriConsumer;
import org.eu.zajc.ef.triconsumer.except.ETriConsumer;

/**
 * Represents an operation that accepts three input arguments and returns no result.
 * This is the three-arity specialization of {@link AEConsumer}. Unlike most other
 * functional interfaces, {@link AETriConsumer} is expected to operate via
 * side-effects.
 *
 * <p>
 * Additionally, the functional method is allowed to throw an {@link Exception}.
 *
 * <p>
 * This is a functional interface whose functional method is
 * {@link #acceptChecked(Object, Object, Object)}.
 *
 * @param <T>
 *            the type of the first argument to the operation
 * @param <U>
 *            the type of the second argument to the operation
 * @param <V>
 *            the type of the third argument to the operation
 *
 * @see TriConsumer
 * @see AEConsumer
 * @see AEBiConsumer
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface AETriConsumer<T, U, V> extends ETriConsumer<T, U, V, Exception> {}
