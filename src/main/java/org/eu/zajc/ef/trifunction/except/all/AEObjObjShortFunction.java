package org.eu.zajc.ef.trifunction.except.all;

import org.eu.zajc.ef.trifunction.ObjObjShortFunction;
import org.eu.zajc.ef.trifunction.except.EObjObjShortFunction;

/**
 * Variant of {@link ObjObjShortFunction} capable of throwing an {@link Exception}.
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
public interface AEObjObjShortFunction<T, U, R> extends EObjObjShortFunction<T, U, R, Exception> {}
