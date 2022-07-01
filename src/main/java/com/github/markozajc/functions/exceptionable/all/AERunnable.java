package com.github.markozajc.functions.exceptionable.all;

import com.github.markozajc.functions.exceptionable.ERunnable;

/**
 * Variant of {@link Runnable} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface AERunnable extends ERunnable<Exception> {}
