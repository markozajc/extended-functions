package com.github.markozajc.functions.exceptionable.all;

import com.github.markozajc.functions.ByteFunction;
import com.github.markozajc.functions.exceptionable.EByteFunction;

/**
 * Variant of {@link ByteFunction} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <R>
 *            the type of the result of the function
 */
@FunctionalInterface
public interface AEByteFunction<R> extends EByteFunction<R, Exception> {}
