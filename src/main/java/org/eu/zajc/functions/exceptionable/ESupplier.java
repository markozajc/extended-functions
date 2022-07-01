package org.eu.zajc.functions.exceptionable;

import static org.eu.zajc.functions.exceptionable.Utilities.asUnchecked;

import java.util.function.Supplier;

/**
 * Variant of {@link Supplier} capable of throwing a generic {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of results supplied by this supplier
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface ESupplier<T, E extends Throwable> extends Supplier<T> {

	@Override
	default T get() {
		try {
			return getChecked();
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #get()}, but throws a checked exception.
	 *
	 * @return a result
	 *
	 * @throws E
	 *             the defined exception type
	 */
	T getChecked() throws E;

}
