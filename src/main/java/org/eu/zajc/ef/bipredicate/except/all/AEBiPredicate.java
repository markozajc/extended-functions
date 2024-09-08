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

import org.eu.zajc.ef.bipredicate.except.EBiPredicate;
import org.eu.zajc.ef.predicate.except.EPredicate;
import org.eu.zajc.ef.predicate.except.all.AEPredicate;
import org.eu.zajc.ef.tripredicate.except.ETriPredicate;

/**
 * Represents a predicate (boolean-valued function) of two arguments. This is the
 * two-arity specialization of {@link AEPredicate}.
 *
 * <p>
 * Additionally, the functional method is allowed to throw an {@link Exception}.
 *
 * <p>
 * This is a functional interface whose functional method is
 * {@link #testChecked(Object, Object)}.
 *
 * @param <T>
 *            the type of the first argument to the predicate
 * @param <U>
 *            the type of the second argument the predicate
 *
 * @see BiPredicate
 * @see EPredicate
 * @see ETriPredicate
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface AEBiPredicate<T, U> extends EBiPredicate<T, U, Exception> {}
