package org.eu.zajc.functions.exceptionable;

import static org.eu.zajc.functions.Utilities.asUnchecked;

import java.util.function.BiFunction;

@FunctionalInterface
public interface EBiFunction<T, U, R, E extends Throwable> extends BiFunction<T, U, R> {

	@Override
	default R apply(T t, U u) {
		try {
			return applyExceptionable(t, u);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	R applyExceptionable(T t, U u) throws E;

}
