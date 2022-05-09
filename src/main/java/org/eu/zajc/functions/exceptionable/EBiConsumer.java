package org.eu.zajc.functions.exceptionable;

import java.util.function.BiConsumer;

/**
 * Variant of {@link BiConsumer} capable of throwing a generic {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 * @param <U>
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface EBiConsumer<T, U, E extends Throwable> extends BiConsumer<T, U> {

	@Override
	default void accept(T t, U u) {
		try {
			acceptExceptionable(t, u);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw Utilities.asUnchecked(e);
		}
	}

	void acceptExceptionable(T t, U u) throws E;

}
