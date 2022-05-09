package org.eu.zajc.functions.exceptionable;

import static org.eu.zajc.functions.exceptionable.Utilities.asUnchecked;

import org.eu.zajc.functions.ToBooleanBiFunction;

/**
 * Variant of {@link ToBooleanBiFunction} capable of throwing a generic
 * {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 * @param <U>
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface EToBooleanBiFunction<T, U, E extends Throwable> extends ToBooleanBiFunction<T, U> {

	@Override
	default boolean apply(T t, U u) {
		try {
			return applyExceptionable(t, u);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	boolean applyExceptionable(T t, U u) throws E;

}
