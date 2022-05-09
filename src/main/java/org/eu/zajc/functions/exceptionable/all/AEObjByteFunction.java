package org.eu.zajc.functions.exceptionable.all;

import org.eu.zajc.functions.ObjByteFunction;
import org.eu.zajc.functions.exceptionable.EObjByteFunction;

/**
 * Variant of {@link ObjByteFunction} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 * @param <R>
 */
@FunctionalInterface
public interface AEObjByteFunction<T, R> extends EObjByteFunction<T, R, Exception> {}
