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
package org.eu.zajc.ef.consumer.execpt.all;

import java.util.function.Consumer;

import org.eu.zajc.ef.biconsumer.except.all.AEBiConsumer;
import org.eu.zajc.ef.consumer.execpt.EConsumer;
import org.eu.zajc.ef.triconsumer.except.all.AETriConsumer;

/**
 * Represents an operation that accepts a single input argument and returns no
 * result. Unlike most other functional interfaces, {@link AEConsumer} is expected to
 * operate via side-effects.
 *
 * <p>
 * Additionally, the functional method is allowed to throw an {@link Exception}.
 *
 * <p>
 * This is a functional interface whose functional method is
 * {@link #acceptChecked(Object)}.
 *
 * @param <T>
 *            the type of the input to the operation
 *
 * @see Consumer
 * @see AEBiConsumer
 * @see AETriConsumer
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface AEConsumer<T> extends EConsumer<T, Exception> {}
