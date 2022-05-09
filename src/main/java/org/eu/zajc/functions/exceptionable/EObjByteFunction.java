package org.eu.zajc.functions.exceptionable;

import static org.eu.zajc.functions.exceptionable.Utilities.asUnchecked;

import org.eu.zajc.functions.ObjByteFunction;

/**
 * Variant of {@link ObjByteFunction} capable of throwing a generic
 * {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 * @param <R>
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface EObjByteFunction<T, R, E extends Throwable> extends ObjByteFunction<T, R> {

	@Override
	default R apply(T t, byte value) {
		try {
			return applyExceptionable(t, value);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	R applyExceptionable(T t, byte value) throws E;

}
