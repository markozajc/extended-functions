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

import org.eu.zajc.ef.biconsumer.except.EBiConsumer;
import org.eu.zajc.ef.consumer.execpt.all.AEConsumer;
import org.eu.zajc.ef.triconsumer.except.all.AETriConsumer;

/**
 * Represents an operation that accepts two input arguments and returns no result.
 * This is the two-arity specialization of {@link AEConsumer}. Unlike most other
 * functional interfaces, {@link AEBiConsumer} is expected to operate via
 * side-effects.
 *
 * <p>
 * Additionally, the functional method is allowed to throw an {@link Exception}.
 *
 * <p>
 * This is a functional interface whose functional method is
 * {@link #acceptChecked(Object, Object)}.
 *
 * @param <T>
 *            the type of the first argument to the operation
 * @param <U>
 *            the type of the second argument to the operation
 *
 * @see BiConsumer
 * @see AEConsumer
 * @see AETriConsumer
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface AEBiConsumer<T, U> extends EBiConsumer<T, U, Exception> {}
