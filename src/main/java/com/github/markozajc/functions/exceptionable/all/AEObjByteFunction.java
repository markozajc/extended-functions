package com.github.markozajc.functions.exceptionable.all;

import com.github.markozajc.functions.ObjByteFunction;
import com.github.markozajc.functions.exceptionable.EObjByteFunction;

/**
 * Variant of {@link ObjByteFunction} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the function
 * @param <R>
 *            the type of the result of the function
 */
@FunctionalInterface
public interface AEObjByteFunction<T, R> extends EObjByteFunction<T, R, Exception> {}
