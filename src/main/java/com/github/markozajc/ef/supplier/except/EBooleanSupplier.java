package com.github.markozajc.ef.supplier.except;

import static com.github.markozajc.ef.Utilities.asUnchecked;

import java.util.function.BooleanSupplier;

/**
 * Variant of {@link BooleanSupplier} capable of throwing a generic
 * {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface EBooleanSupplier<E extends Throwable> extends BooleanSupplier {

	@Override
	default boolean getAsBoolean() {
		try {
			return getChecked();
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #getAsBoolean()}, but throws a checked exception.
	 *
	 * @return a result
	 *
	 * @throws E
	 *             the defined exception type
	 */
	boolean getChecked() throws E;

}
