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
package org.eu.zajc.ef.unary.except;

import java.util.function.UnaryOperator;

import org.eu.zajc.ef.binary.except.EBinaryOperator;
import org.eu.zajc.ef.function.except.EFunction;

/**
 * Represents an operation on a single operand that produces a result of the same
 * type as its operand. This is a specialization of {@link EFunction} for the case
 * where the operand and result are of the same type.
 *
 * <p>
 * Additionally, the functional method is allowed to throw a generic
 * {@link Throwable} of type {@code E}.
 *
 * <p>
 * This is a functional interface whose functional method is
 * {@link #applyChecked(Object)}.
 *
 * @param <T>
 *            the type of the operand and result of the operator
 * @param <E>
 *            {@link Throwable} type
 *
 * @see UnaryOperator
 * @see EBinaryOperator
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface EUnaryOperator<T, E extends Throwable> extends UnaryOperator<T>, EFunction<T, T, E> {}
