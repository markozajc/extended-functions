package com.github.markozajc.functions.exceptionable.all;

import com.github.markozajc.functions.ObjObjIntFunction;
import com.github.markozajc.functions.exceptionable.EObjObjIntFunction;

/**
 * Variant of {@link ObjObjIntFunction} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the function
 * @param <U>
 *            the type of the second argument to the function
 * @param <R>
 *            the type of the result of the function
 */
@FunctionalInterface
public interface AEObjObjIntFunction<T, U, R> extends EObjObjIntFunction<T, U, R, Exception> {}
