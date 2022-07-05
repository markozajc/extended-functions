package com.github.markozajc.functions.exceptionable.all;

import java.util.function.LongFunction;

import com.github.markozajc.functions.exceptionable.ELongFunction;

/**
 * Variant of {@link LongFunction} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <R>
 *            the type of the result of the function
 */
@FunctionalInterface
public interface AELongFunction<R> extends ELongFunction<R, Exception> {}
