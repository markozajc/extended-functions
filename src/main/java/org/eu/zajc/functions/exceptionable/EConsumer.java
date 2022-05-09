package org.eu.zajc.functions.exceptionable;

import static org.eu.zajc.functions.Utilities.asUnchecked;

import java.util.function.Consumer;

@FunctionalInterface
public interface EConsumer<T, E extends Throwable> extends Consumer<T> {

	@Override
	default void accept(T value) {
		try {
			acceptExceptionable(value);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	void acceptExceptionable(T value) throws E;

}
