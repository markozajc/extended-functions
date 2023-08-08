package org.eu.zajc.ef.consumer.execpt.all;

import java.util.function.Consumer;

import org.eu.zajc.ef.consumer.execpt.EShortConsumer;

/**
 * Variant of {@link Consumer} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface AEShortConsumer extends EShortConsumer<Exception> {}
