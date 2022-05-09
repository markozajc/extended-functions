package org.eu.zajc.functions.exceptionable.all;

import org.eu.zajc.functions.ObjObjIntFunction;
import org.eu.zajc.functions.exceptionable.EObjObjIntFunction;

/**
 * Variant of {@link ObjObjIntFunction} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 * @param <U>
 * @param <R>
 */
@FunctionalInterface
public interface AEObjObjIntFunction<T, U, R> extends EObjObjIntFunction<T, U, R, Exception> {}
