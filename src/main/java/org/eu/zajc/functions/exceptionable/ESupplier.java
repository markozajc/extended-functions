package org.eu.zajc.functions.exceptionable;

import static org.eu.zajc.functions.exceptionable.Utilities.asUnchecked;

import java.util.function.Supplier;

/**
 * Variant of {@link Supplier} capable of throwing a generic {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface ESupplier<T, E extends Throwable> extends Supplier<T> {

	@Override
	default T get() {
		try {
			return getExceptionable();
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	T getExceptionable() throws E;

}
