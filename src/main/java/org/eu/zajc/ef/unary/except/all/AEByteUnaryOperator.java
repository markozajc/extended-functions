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
package org.eu.zajc.ef.unary.except.all;

import java.util.function.UnaryOperator;

import org.eu.zajc.ef.binary.except.all.AEByteBinaryOperator;
import org.eu.zajc.ef.unary.except.EByteUnaryOperator;

/**
 * Represents an operation on a single {@code byte}-valued operand that produces an
 * {@code byte}-valued result. This is the primitive type specialization of
 * {@link AEUnaryOperator} for {@code byte}.
 *
 * <p>
 * Additionally, the functional method is allowed to throw an {@link Exception}.
 *
 * <p>
 * This is a functional interface whose functional method is
 * {@link #applyCheckedAsByte(byte)}.
 *
 * @see UnaryOperator
 * @see AEByteBinaryOperator
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface AEByteUnaryOperator extends EByteUnaryOperator<Exception> {}
