package com.github.markozajc.ef.consumer.execpt.all;

import java.util.function.Consumer;

import com.github.markozajc.ef.consumer.execpt.ELongConsumer;

/**
 * Variant of {@link Consumer} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface AELongConsumer extends ELongConsumer<Exception> {}
