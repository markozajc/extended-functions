package com.github.markozajc.functions.exceptionable.all;

import java.util.function.Consumer;

import com.github.markozajc.functions.exceptionable.EConsumer;

/**
 * Variant of {@link Consumer} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the input to the operation
 */
@FunctionalInterface
public interface AEConsumer<T> extends EConsumer<T, Exception> {}
