package org.eu.zajc.functions.exceptionable.all;

import org.eu.zajc.functions.ObjObjBooleanFunction;
import org.eu.zajc.functions.exceptionable.EObjObjBooleanFunction;

/**
 * Variant of {@link ObjObjBooleanFunction} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 * @param <U>
 * @param <R>
 */
@FunctionalInterface
public interface AEObjObjBooleanFunction<T, U, R> extends EObjObjBooleanFunction<T, U, R, Exception> {}
