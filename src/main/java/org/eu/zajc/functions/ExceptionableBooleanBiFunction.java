package org.eu.zajc.functions;

@FunctionalInterface
public interface ExceptionableBooleanBiFunction<T, U, E extends Throwable> {

	boolean apply(T t, U u) throws E;

}
