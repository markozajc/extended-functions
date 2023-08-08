package org.eu.zajc.ef.bifunction.except.all;

import org.eu.zajc.ef.bifunction.ObjLongFunction;
import org.eu.zajc.ef.bifunction.except.EObjLongFunction;

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
