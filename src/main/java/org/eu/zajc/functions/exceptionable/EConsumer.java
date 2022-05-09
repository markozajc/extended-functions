package org.eu.zajc.functions.exceptionable;

import static org.eu.zajc.functions.exceptionable.Utilities.asUnchecked;

import java.util.function.Consumer;

/**
 * Variant of {@link Consumer} capable of throwing a generic {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 * @param <E>
 *            {@link Throwable} type
 */
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
