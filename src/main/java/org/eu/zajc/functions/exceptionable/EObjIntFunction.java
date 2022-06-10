package org.eu.zajc.functions.exceptionable;

import static org.eu.zajc.functions.exceptionable.Utilities.asUnchecked;

import org.eu.zajc.functions.ObjIntFunction;

/**
 * Variant of {@link ObjIntFunction} capable of throwing a generic {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 * @param <R>
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface EObjIntFunction<T, R, E extends Throwable> extends ObjIntFunction<T, R> {

	@Override
	default R apply(T t, int value) {
		try {
			return applyChecked(t, value);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	R applyChecked(T t, int value) throws E;

}
