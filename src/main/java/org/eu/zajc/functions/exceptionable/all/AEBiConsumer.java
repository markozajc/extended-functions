package org.eu.zajc.functions.exceptionable.all;

import java.util.function.BiConsumer;

import org.eu.zajc.functions.exceptionable.EBiConsumer;

/**
 * Variant of {@link BiConsumer} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the operation
 * @param <U>
 *            the type of the second argument to the operation
 */
@FunctionalInterface
public interface AEBiConsumer<T, U> extends EBiConsumer<T, U, Exception> {}
