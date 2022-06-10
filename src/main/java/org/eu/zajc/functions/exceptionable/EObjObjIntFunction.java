package org.eu.zajc.functions.exceptionable;

import static org.eu.zajc.functions.exceptionable.Utilities.asUnchecked;

import org.eu.zajc.functions.ObjObjIntFunction;

/**
 * Variant of {@link ObjObjIntFunction} capable of throwing a generic
 * {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 * @param <U>
 * @param <R>
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface EObjObjIntFunction<T, U, R, E extends Throwable> extends ObjObjIntFunction<T, U, R> {

	@Override
	default R apply(T t, U u, int value) {
		try {
			return applyChecked(t, u, value);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	R applyChecked(T t, U u, int value) throws E;

}
