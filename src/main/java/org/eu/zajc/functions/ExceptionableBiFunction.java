package org.eu.zajc.functions;

@FunctionalInterface
public interface ExceptionableBiFunction<T, U, R, E extends Throwable> {

	R apply(T t, U u) throws E;

}
