package org.eu.zajc.functions.exceptionable.all;

import org.eu.zajc.functions.exceptionable.EFunction;

@FunctionalInterface
public interface AEFunction<T, R> extends EFunction<T, R, Exception> {}
