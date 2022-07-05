package com.github.markozajc.functions.exceptionable.all;

import java.util.function.IntFunction;

import com.github.markozajc.functions.exceptionable.EIntFunction;

/**
 * Variant of {@link IntFunction} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <R>
 *            the type of the result of the function
 */
@FunctionalInterface
public interface AEIntFunction<R> extends EIntFunction<R, Exception> {}
