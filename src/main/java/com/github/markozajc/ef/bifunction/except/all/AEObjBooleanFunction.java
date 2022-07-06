package com.github.markozajc.ef.bifunction.except.all;

import com.github.markozajc.ef.bifunction.ObjBooleanFunction;
import com.github.markozajc.ef.bifunction.except.EObjBooleanFunction;

/**
 * Variant of {@link ObjBooleanFunction} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the function
 * @param <R>
 *            the type of the result of the function
 */
@FunctionalInterface
public interface AEObjBooleanFunction<T, R> extends EObjBooleanFunction<T, R, Exception> {}
