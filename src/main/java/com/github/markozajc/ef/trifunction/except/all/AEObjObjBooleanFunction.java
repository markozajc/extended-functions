package com.github.markozajc.ef.trifunction.except.all;

import com.github.markozajc.ef.trifunction.ObjObjBooleanFunction;
import com.github.markozajc.ef.trifunction.except.EObjObjBooleanFunction;

/**
 * Variant of {@link ObjObjBooleanFunction} capable of throwing an {@link Exception}.
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
public interface AEObjObjBooleanFunction<T, U, R> extends EObjObjBooleanFunction<T, U, R, Exception> {}
