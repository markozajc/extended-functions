package org.eu.zajc.functions.exceptionable.all;

import org.eu.zajc.functions.TriConsumer;
import org.eu.zajc.functions.exceptionable.ETriConsumer;

/**
 * Variant of {@link TriConsumer} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 * @param <U>
 * @param <V>
 */
@FunctionalInterface
public interface AETriConsumer<T, U, V> extends ETriConsumer<T, U, V, Exception> {}
