package com.github.markozajc.ef.function.except.all;

import java.util.function.IntFunction;

import com.github.markozajc.ef.function.except.EIntFunction;

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
