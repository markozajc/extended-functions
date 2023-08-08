package org.eu.zajc.ef.bifunction.except.all;

import org.eu.zajc.ef.bifunction.ObjIntFunction;
import org.eu.zajc.ef.bifunction.except.EObjIntFunction;

/**
 * Variant of {@link ObjIntFunction} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the function
 * @param <R>
 *            the type of the result of the function
 */
@FunctionalInterface
public interface AEObjIntFunction<T, R> extends EObjIntFunction<T, R, Exception> {}
