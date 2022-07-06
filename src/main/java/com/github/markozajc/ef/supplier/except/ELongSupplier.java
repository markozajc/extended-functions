package com.github.markozajc.ef.supplier.except;

import static com.github.markozajc.ef.Utilities.asUnchecked;

import java.util.function.LongSupplier;

/**
 * Variant of {@link LongSupplier} capable of throwing a generic {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface ELongSupplier<E extends Throwable> extends LongSupplier {

	@Override
	default long getAsLong() {
		try {
			return getChecked();
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #getAsLong()}, but throws a checked exception.
	 *
	 * @return a result
	 *
	 * @throws E
	 *             the defined exception type
	 */
	long getChecked() throws E;

}
