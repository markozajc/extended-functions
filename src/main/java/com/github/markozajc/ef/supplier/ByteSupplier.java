package com.github.markozajc.ef.supplier;

import java.util.function.Supplier;

/**
 * A {@link Supplier} variant that and returns a primitive byte.
 *
 * @author Marko Zajc
 */
public interface ByteSupplier {

	/**
	 * Gets a result.
	 *
	 * @return a result
	 */
	byte getAsByte();

}
