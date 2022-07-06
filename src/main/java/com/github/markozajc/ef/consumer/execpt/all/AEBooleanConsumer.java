package com.github.markozajc.ef.consumer.execpt.all;

import java.util.function.Consumer;

import com.github.markozajc.ef.consumer.execpt.EBooleanConsumer;

/**
 * Variant of {@link Consumer} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface AEBooleanConsumer extends EBooleanConsumer<Exception> {}
