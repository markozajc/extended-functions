package org.eu.zajc.functions.exceptionable.all;

import java.util.function.BiFunction;

import org.eu.zajc.functions.exceptionable.EBiFunction;

/**
 * Variant of {@link BiFunction} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 * @param <U>
 * @param <R>
 */
@FunctionalInterface
public interface AEBiFunction<T, U, R> extends EBiFunction<T, U, R, Exception> {}
