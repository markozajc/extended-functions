package org.eu.zajc.ef.runnable.except.all;

import org.eu.zajc.ef.runnable.except.ERunnable;

/**
 * Variant of {@link Runnable} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface AERunnable extends ERunnable<Exception> {}
