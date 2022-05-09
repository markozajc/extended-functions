package org.eu.zajc.functions.exceptionable.all;

import org.eu.zajc.functions.exceptionable.EObjObjIntFunction;

@FunctionalInterface
public interface AEObjObjIntFunction<T, U, R> extends EObjObjIntFunction<T, U, R, Exception> {}
