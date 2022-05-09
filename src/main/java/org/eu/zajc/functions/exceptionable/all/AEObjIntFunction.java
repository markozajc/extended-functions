package org.eu.zajc.functions.exceptionable.all;

import org.eu.zajc.functions.ObjIntFunction;
import org.eu.zajc.functions.exceptionable.EObjIntFunction;

/**
 * Variant of {@link ObjIntFunction} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 * @param <R>
 */
@FunctionalInterface
public interface AEObjIntFunction<T, R> extends EObjIntFunction<T, R, Exception> {}
