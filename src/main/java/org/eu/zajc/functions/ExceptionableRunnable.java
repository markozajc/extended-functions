package org.eu.zajc.functions;


@FunctionalInterface
public interface ExceptionableRunnable<E extends Throwable> {

	void run() throws E;

}
