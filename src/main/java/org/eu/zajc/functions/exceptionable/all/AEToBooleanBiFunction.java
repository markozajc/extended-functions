package org.eu.zajc.functions.exceptionable.all;

import org.eu.zajc.functions.ToBooleanBiFunction;
import org.eu.zajc.functions.exceptionable.EToBooleanBiFunction;

/**
 * Variant of {@link ToBooleanBiFunction} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 * @param <U>
 */
@FunctionalInterface
public interface AEToBooleanBiFunction<T, U> extends EToBooleanBiFunction<T, U, Exception> {}
