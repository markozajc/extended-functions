package org.eu.zajc.functions.exceptionable;

import static org.eu.zajc.functions.exceptionable.Utilities.asUnchecked;

import java.util.function.Function;

/**
 * Variant of {@link Function} capable of throwing a generic {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 * @param <R>
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface EFunction<T, R, E extends Throwable> extends Function<T, R> {

	@Override
	default R apply(T value) {
		try {
			return applyExceptionable(value);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	R applyExceptionable(T value) throws E;

}
