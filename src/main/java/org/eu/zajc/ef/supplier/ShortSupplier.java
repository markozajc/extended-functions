package org.eu.zajc.ef.supplier;

import java.util.function.Supplier;

/**
 * A {@link Supplier} variant that and returns a primitive short.
 *
 * @author Marko Zajc
 */
public interface ShortSupplier {

	/**
	 * Gets a result.
	 *
	 * @return a result
	 */
	short getAsShort();

}
