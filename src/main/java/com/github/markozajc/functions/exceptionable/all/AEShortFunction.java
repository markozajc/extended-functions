package com.github.markozajc.functions.exceptionable.all;

import com.github.markozajc.functions.ShortFunction;
import com.github.markozajc.functions.exceptionable.EShortFunction;

/**
 * Variant of {@link ShortFunction} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <R>
 *            the type of the result of the function
 */
@FunctionalInterface
public interface AEShortFunction<R> extends EShortFunction<R, Exception> {}
