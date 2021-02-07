package org.eu.zajc.functions;


public interface ExceptionableConsumer<T, E extends Throwable> {

	void accept(T t) throws E;

}
