package com.github.markozajc.ef.runnable.except.all;

import com.github.markozajc.ef.runnable.except.ERunnable;

/**
 * Variant of {@link Runnable} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface AERunnable extends ERunnable<Exception> {}
