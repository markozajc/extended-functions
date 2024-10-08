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
package org.eu.zajc.ef.bipredicate;

import java.util.Objects;
import java.util.function.BiPredicate;

import javax.annotation.Nonnull;

import org.eu.zajc.ef.predicate.BytePredicate;
import org.eu.zajc.ef.tripredicate.ObjObjBytePredicate;

/**
 * Represents a predicate (boolean-valued function) of an object-valued and a
 * {@code byte}-valued argument. This is the {@code (reference, byte)} specialization
 * of {@link BiPredicate}.
 *
 * <p>
 * This is a functional interface whose functional method is
 * {@link #test(Object, byte)}.
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
public interface ObjBytePredicate<T> {

	/**
	 * Evaluates this predicate on the given arguments.
	 *
	 * @param t
	 *            the first input argument
	 * @param p
	 *            the second ({@code byte}) input argument
	 *
	 * @return {@code true} if the input arguments match the predicate, otherwise
	 *         {@code false}
	 */
	boolean test(T t, byte p);

	/**
	 * Returns a composed predicate that represents a short-circuiting logical AND of
	 * this predicate and another. When evaluating the composed predicate, if this
	 * predicate is {@code false}, then the {@code other} predicate is not evaluated.
	 *
	 * <p>
	 * Any exceptions thrown during evaluation of either predicate are relayed to the
	 * caller; if evaluation of this predicate throws an exception, the {@code other}
	 * predicate will not be evaluated.
	 *
	 * @param other
	 *            a predicate that will be logically-ANDed with this predicate
	 *
	 * @return a composed predicate that represents the short-circuiting logical AND of
	 *         this predicate and the {@code other} predicate
	 *
	 * @throws NullPointerException
	 *             if other is null
	 */
	@Nonnull
	default ObjBytePredicate<T> and(ObjBytePredicate<? super T> other) {
		Objects.requireNonNull(other);
		return (t, p) -> test(t, p) && other.test(t, p);
	}

	/**
	 * Returns a predicate that represents the logical negation of this predicate.
	 *
	 * @return a predicate that represents the logical negation of this predicate
	 */
	@Nonnull
	default ObjBytePredicate<T> negate() {
		return (t, p) -> !test(t, p);
	}

	/**
	 * Returns a composed predicate that represents a short-circuiting logical OR of this
	 * predicate and another. When evaluating the composed predicate, if this predicate
	 * is {@code true}, then the {@code other} predicate is not evaluated.
	 *
	 * <p>
	 * Any exceptions thrown during evaluation of either predicate are relayed to the
	 * caller; if evaluation of this predicate throws an exception, the {@code other}
	 * predicate will not be evaluated.
	 *
	 * @param other
	 *            a predicate that will be logically-ORed with this predicate
	 *
	 * @return a composed predicate that represents the short-circuiting logical OR of
	 *         this predicate and the {@code other} predicate
	 *
	 * @throws NullPointerException
	 *             if other is null
	 */
	@Nonnull
	default ObjBytePredicate<T> or(@Nonnull ObjBytePredicate<? super T> other) {
		Objects.requireNonNull(other);
		return (t, p) -> test(t, p) || other.test(t, p);
	}

}
