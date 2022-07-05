package com.github.markozajc.functions.exceptionable.all;

import com.github.markozajc.functions.ObjShortFunction;
import com.github.markozajc.functions.exceptionable.EObjShortFunction;

/**
 * Variant of {@link ObjShortFunction} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the function
 * @param <R>
 *            the type of the result of the function
 */
@FunctionalInterface
public interface AEObjShortFunction<T, R> extends EObjShortFunction<T, R, Exception> {}
