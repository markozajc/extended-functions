package com.github.markozajc.functions.exceptionable.all;

import com.github.markozajc.functions.TriConsumer;
import com.github.markozajc.functions.exceptionable.ETriConsumer;

/**
 * Variant of {@link TriConsumer} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the operation
 * @param <U>
 *            the type of the second argument to the operation
 * @param <V>
 *            the type of the third argument to the operation
 */
@FunctionalInterface
public interface AETriConsumer<T, U, V> extends ETriConsumer<T, U, V, Exception> {}
