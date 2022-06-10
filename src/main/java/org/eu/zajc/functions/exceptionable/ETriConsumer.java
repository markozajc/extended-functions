package org.eu.zajc.functions.exceptionable;

import static org.eu.zajc.functions.exceptionable.Utilities.asUnchecked;

import org.eu.zajc.functions.TriConsumer;

/**
 * Variant of {@link TriConsumer} capable of throwing a generic {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 * @param <U>
 * @param <V>
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface ETriConsumer<T, U, V, E extends Throwable> extends TriConsumer<T, U, V> {

	@Override
	default void accept(T t, U u, V v) {
		try {
			acceptChecked(t, u, v);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	void acceptChecked(T t, U u, V v) throws E;

}
