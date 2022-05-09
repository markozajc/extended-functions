package org.eu.zajc.functions.exceptionable;

import static org.eu.zajc.functions.Utilities.asUnchecked;

@FunctionalInterface
public interface ERunnable<E extends Throwable> extends Runnable {

	@Override
	default void run() {
		try {
			runExceptionable();
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	void runExceptionable() throws E;

}
