package org.eu.zajc.functions.exceptionable.all;

import java.util.function.BiFunction;

import org.eu.zajc.functions.exceptionable.EBiFunction;

/**
 * Variant of {@link BiFunction} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the function
 * @param <U>
 *            the type of the second argument to the function
 * @param <R>
 *            the type of the result of the function
 */
@FunctionalInterface
public interface AEBiFunction<T, U, R> extends EBiFunction<T, U, R, Exception> {}
