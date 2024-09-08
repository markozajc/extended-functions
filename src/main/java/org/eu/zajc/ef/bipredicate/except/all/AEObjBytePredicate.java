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
package org.eu.zajc.ef.bipredicate.except.all;

import java.util.function.BiPredicate;

import org.eu.zajc.ef.bipredicate.except.EObjBytePredicate;
import org.eu.zajc.ef.predicate.BytePredicate;
import org.eu.zajc.ef.tripredicate.ObjObjBytePredicate;

/**
 * Represents a predicate (boolean-valued function) of an object-valued and a
 * {@code byte}-valued argument. This is the {@code (reference, byte)} specialization
 * of {@link AEBiPredicate}.
 *
 * <p>
 * Additionally, the functional method is allowed to throw an {@link Exception}.
 *
 * <p>
 * This is a functional interface whose functional method is
 * {@link #testChecked(Object, byte)}.
 *
 * @param <T>
 *            the type of the first argument to the predicate
 *
 * @see BiPredicate
 * @see BytePredicate
 * @see ObjObjBytePredicate
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface AEObjBytePredicate<T> extends EObjBytePredicate<T, Exception> {}
