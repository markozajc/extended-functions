package org.eu.zajc.functions;

@FunctionalInterface
public interface ExceptionableConsumer<T, E extends Throwable> {

	void accept(T t) throws E;

}
