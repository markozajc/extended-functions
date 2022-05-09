package org.eu.zajc.functions.exceptionable;

@FunctionalInterface
public interface EBooleanBiFunction<T, U, E extends Throwable> {

	boolean apply(T t, U u) throws E;

}
