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

import org.eu.zajc.ef.predicate.except.all.AEBooleanPredicate;
import org.eu.zajc.ef.unary.BooleanUnaryOperator;
import org.eu.zajc.ef.unary.except.EBooleanUnaryOperator;

/**
 * A variant of {@link BooleanUnaryOperator} capable of throwing an
 * {@link Exception}.
 *
 * This is equivalent to {@link AEBooleanPredicate}
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface AEBooleanUnaryOperator extends EBooleanUnaryOperator<Exception> {}
