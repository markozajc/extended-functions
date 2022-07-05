package com.github.markozajc.ef.function.except.all;

import com.github.markozajc.ef.function.ObjShortFunction;
import com.github.markozajc.ef.function.except.EObjShortFunction;

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
