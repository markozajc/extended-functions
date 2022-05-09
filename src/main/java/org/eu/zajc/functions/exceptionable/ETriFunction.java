package org.eu.zajc.functions.exceptionable;

import static org.eu.zajc.functions.exceptionable.Utilities.asUnchecked;

import org.eu.zajc.functions.TriFunction;

/**
 * Variant of {@link TriFunction} capable of throwing a generic {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 * @param <U>
 * @param <V>
 * @param <R>
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface ETriFunction<T, U, V, R, E extends Throwable> extends TriFunction<T, U, V, R> {

	@Override
	default R apply(T t, U u, V v) {
		try {
			return applyExceptionable(t, u, v);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	R applyExceptionable(T t, U u, V v) throws E;

}
