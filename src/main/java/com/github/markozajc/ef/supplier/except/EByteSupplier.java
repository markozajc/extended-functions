package com.github.markozajc.ef.supplier.except;

import static com.github.markozajc.ef.Utilities.asUnchecked;

import com.github.markozajc.ef.supplier.ByteSupplier;

/**
 * Variant of {@link ByteSupplier} capable of throwing a generic {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface EByteSupplier<E extends Throwable> extends ByteSupplier {

	@Override
	default byte getAsByte() {
		try {
			return getChecked();
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #getAsByte()}, but throws a checked exception.
	 *
	 * @return a result
	 *
	 * @throws E
	 *             the defined exception type
	 */
	byte getChecked() throws E;

}
