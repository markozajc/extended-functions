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
package org.eu.zajc.ef.bifunction;

import java.util.Objects;
import java.util.function.*;

import javax.annotation.Nonnull;

import org.eu.zajc.ef.function.BooleanFunction;
import org.eu.zajc.ef.trifunction.ObjObjBooleanFunction;

/**
 * Represents a function that accepts an object-valued and a {@code boolean}-valued
 * argument, and produces a result. This is the {@code (reference, boolean)}
 * specialization of {@link BiFunction}.
 *
 * <p>
 * This is a functional interface whose functional method is
 * {@link #apply(Object, boolean)}.
 *
 * @param <T>
 *            the type of the first argument to the function
 * @param <R>
 *            the type of the result of the function
 *
 * @see BiFunction
 * @see BooleanFunction
 * @see ObjObjBooleanFunction
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface ObjBooleanFunction<T, R> {

	/**
	 * Applies this function to the given arguments.
	 *
	 * @param t
	 *            the first function argument
	 * @param p
	 *            the second ({@code boolean}) function argument
	 *
	 * @return the function result
	 */
	R apply(T t, boolean p);

	/**
	 * Returns a composed function that first applies this function to its input, and
	 * then applies the {@code after} function to the result. If evaluation of either
	 * function throws an exception, it is relayed to the caller of the composed
	 * function.
	 *
	 * @param <V>
	 *            the type of output of the {@code after} function, and of the composed
	 *            function
	 * @param after
	 *            the function to apply after this function is applied
	 *
	 * @return a composed function that first applies this function and then applies the
	 *         {@code after} function
	 *
	 * @throws NullPointerException
	 *             if after is null
	 */
	@Nonnull
	default <V> ObjBooleanFunction<T, V> andThen(@Nonnull Function<? super R, ? extends V> after) {
		Objects.requireNonNull(after);
		return (t, p) -> after.apply(apply(t, p));
	}

}
