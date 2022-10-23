package com.github.markozajc.ef.supplier.except;

import static com.github.markozajc.ef.Utilities.asUnchecked;

import java.util.concurrent.Callable;
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
public interface ESupplier<T, E extends Throwable> extends Supplier<T>, Callable<T> {

	@Override
	default T get() {
		try {
			return getChecked();
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	@Override
	default T call() throws Exception {
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
