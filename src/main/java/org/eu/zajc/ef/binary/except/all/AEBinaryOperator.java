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
package org.eu.zajc.ef.binary.except.all;

import java.util.function.BinaryOperator;

import org.eu.zajc.ef.bifunction.except.all.AEBiFunction;
import org.eu.zajc.ef.binary.except.EBinaryOperator;
import org.eu.zajc.ef.unary.except.all.AEUnaryOperator;

/**
 * Represents an operation upon two operands of the same type, producing a result of
 * the same type as the operands. This is a specialization of {@link AEBiFunction}
 * for the case where the operands and the result are all of the same type.
 *
 * <p>
 * Additionally, the functional method is allowed to throw an {@link Exception}.
 *
 * <p>
 * This is a functional interface whose functional method is
 * {@link #applyChecked(Object, Object)}.
 *
 * @param <T>
 *            the type of the operands and result of the operator
 *
 * @see BinaryOperator
 * @see AEUnaryOperator
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface AEBinaryOperator<T> extends EBinaryOperator<T, Exception> {}
