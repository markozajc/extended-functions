package org.eu.zajc.functions.exceptionable.all;

import org.eu.zajc.functions.exceptionable.ERunnable;

/**
 * Variant of {@link Runnable} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface AERunnable extends ERunnable<Exception> {}
