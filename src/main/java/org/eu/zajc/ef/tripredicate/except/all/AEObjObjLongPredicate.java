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
package org.eu.zajc.ef.tripredicate.except.all;

import org.eu.zajc.ef.bipredicate.except.all.AEObjLongPredicate;
import org.eu.zajc.ef.predicate.except.all.AELongPredicate;
import org.eu.zajc.ef.tripredicate.TriPredicate;
import org.eu.zajc.ef.tripredicate.except.EObjObjLongPredicate;

/**
 * Represents a predicate (boolean-valued function) of two object-valued and one
 * {@code long}-valued arguments. This is the {@code (reference, reference, long)}
 * specialization of {@link AETriPredicate}.
 *
 * <p>
 * Additionally, the functional method is allowed to throw an {@link Exception}.
 *
 * <p>
 * This is a functional interface whose functional method is
 * {@link #testChecked(Object, Object, long)}.
 *
 * @param <T>
 *            the type of the first argument to the predicate
 * @param <U>
 *            the type of the second argument the predicate
 *
 * @see TriPredicate
 * @see AELongPredicate
 * @see AEObjLongPredicate
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface AEObjObjLongPredicate<T, U> extends EObjObjLongPredicate<T, U, Exception> {}
