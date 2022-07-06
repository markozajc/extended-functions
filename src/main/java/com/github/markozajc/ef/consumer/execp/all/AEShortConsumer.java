package com.github.markozajc.ef.consumer.execp.all;

import java.util.function.Consumer;

import com.github.markozajc.ef.consumer.execp.EShortConsumer;

/**
 * Variant of {@link Consumer} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface AEShortConsumer extends EShortConsumer<Exception> {}
