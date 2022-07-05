package com.github.markozajc.ef.trifunction.except.all;

import com.github.markozajc.ef.trifunction.ObjObjLongFunction;
import com.github.markozajc.ef.trifunction.except.EObjObjLongFunction;

/**
 * Variant of {@link ObjObjLongFunction} capable of throwing an {@link Exception}.
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
public interface AEObjObjLongFunction<T, U, R> extends EObjObjLongFunction<T, U, R, Exception> {}
