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
package org.eu.zajc.ef.predicate.except.all;

import java.util.function.Predicate;

import org.eu.zajc.ef.bipredicate.except.EObjBytePredicate;
import org.eu.zajc.ef.predicate.except.EBytePredicate;
import org.eu.zajc.ef.tripredicate.except.EObjObjBytePredicate;

/**
 * Represents a predicate (boolean-valued function) of one {@code byte}-valued
 * argument. This is the {@code byte}-consuming primitive type specialization of
 * {@link Predicate}.
 *
 * <p>
 * Additionally, the functional method is allowed to throw an {@link Exception}.
 *
 * <p>
 * This is a functional interface whose functional method is
 * {@link #testChecked(byte)}.
 *
 * @see Predicate
 * @see EObjBytePredicate
 * @see EObjObjBytePredicate
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface AEBytePredicate extends EBytePredicate<Exception> {}
