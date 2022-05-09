package org.eu.zajc.functions.exceptionable.all;

import java.util.function.Consumer;

import org.eu.zajc.functions.exceptionable.EConsumer;

/**
 * Variant of {@link Consumer} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 */
@FunctionalInterface
public interface AEConsumer<T> extends EConsumer<T, Exception> {}
