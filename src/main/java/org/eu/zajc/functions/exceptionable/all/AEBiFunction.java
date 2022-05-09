package org.eu.zajc.functions.exceptionable.all;

import org.eu.zajc.functions.exceptionable.EBiFunction;

@FunctionalInterface
public interface AEBiFunction<T, U, R> extends EBiFunction<T, U, R, Exception> {}
