package com.github.markozajc.ef.consumer.execpt.all;

import java.util.function.Consumer;

import com.github.markozajc.ef.consumer.execpt.EConsumer;

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
