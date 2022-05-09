package org.eu.zajc.functions.exceptionable.all;

import org.eu.zajc.functions.exceptionable.EObjIntFunction;

@FunctionalInterface
public interface AEObjIntFunction<T, R> extends EObjIntFunction<T, R, Exception> {}
