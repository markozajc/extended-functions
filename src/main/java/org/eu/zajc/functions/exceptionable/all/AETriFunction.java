package org.eu.zajc.functions.exceptionable.all;

import org.eu.zajc.functions.TriConsumer;
import org.eu.zajc.functions.exceptionable.ETriFunction;

/**
 * Variant of {@link TriConsumer} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the function
 * @param <U>
 *            the type of the second argument to the function
 * @param <V>
 *            the type of the third argument to the function
 * @param <R>
 *            the type of the result of the function
 */
@FunctionalInterface
public interface AETriFunction<T, U, V, R> extends ETriFunction<T, U, V, R, Exception> {}