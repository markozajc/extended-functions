package org.eu.zajc.ef.trifunction.except.all;

import org.eu.zajc.ef.trifunction.ObjObjByteFunction;
import org.eu.zajc.ef.trifunction.except.EObjObjByteFunction;

/**
 * Variant of {@link ObjObjByteFunction} capable of throwing an {@link Exception}.
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
public interface AEObjObjByteFunction<T, U, R> extends EObjObjByteFunction<T, U, R, Exception> {}
