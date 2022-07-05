package com.github.markozajc.functions.exceptionable.all;

import com.github.markozajc.functions.ObjLongFunction;
import com.github.markozajc.functions.exceptionable.EObjLongFunction;

/**
 * Variant of {@link ObjLongFunction} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the function
 * @param <R>
 *            the type of the result of the function
 */
@FunctionalInterface
public interface AEObjLongFunction<T, R> extends EObjLongFunction<T, R, Exception> {}
