package org.eu.zajc.functions.exceptionable.all;

import org.eu.zajc.functions.TriConsumer;
import org.eu.zajc.functions.exceptionable.ETriFunction;

/**
 * Variant of {@link TriConsumer} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 * @param <U>
 * @param <V>
 * @param <R>
 */
@FunctionalInterface
public interface AETriFunction<T, U, V, R> extends ETriFunction<T, U, V, R, Exception> {}
