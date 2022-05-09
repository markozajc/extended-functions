package org.eu.zajc.functions.exceptionable;

import static org.eu.zajc.functions.Utilities.asUnchecked;

import java.util.function.Supplier;

@FunctionalInterface
public interface ESupplier<T, E extends Throwable> extends Supplier<T> {

	@Override
	default T get() {
		try {
			return getExceptionable();
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	T getExceptionable() throws E;

}
