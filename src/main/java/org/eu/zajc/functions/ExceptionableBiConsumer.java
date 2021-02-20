package org.eu.zajc.functions;

@FunctionalInterface
public interface ExceptionableBiConsumer<T, U, E extends Throwable> {

	void accept(T t, U u) throws E;

}
