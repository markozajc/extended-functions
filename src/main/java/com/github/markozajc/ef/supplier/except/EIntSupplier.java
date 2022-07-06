package com.github.markozajc.ef.supplier.except;

import static com.github.markozajc.ef.Utilities.asUnchecked;

import java.util.function.IntSupplier;

/**
 * Variant of {@link IntSupplier} capable of throwing a generic {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface EIntSupplier<E extends Throwable> extends IntSupplier {

	@Override
	default int getAsInt() {
		try {
			return getChecked();
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #getAsInt()}, but throws a checked exception.
	 *
	 * @return a result
	 *
	 * @throws E
	 *             the defined exception type
	 */
	int getChecked() throws E;

}
