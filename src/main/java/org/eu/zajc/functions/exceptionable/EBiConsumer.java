package org.eu.zajc.functions.exceptionable;

@FunctionalInterface
public interface EBiConsumer<T, U, E extends Throwable> {

	void accept(T t, U u) throws E;

}
