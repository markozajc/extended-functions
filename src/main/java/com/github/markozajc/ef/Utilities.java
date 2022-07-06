package com.github.markozajc.ef;

import javax.annotation.Nonnull;

/**
 * Utilities for internal use within extended-functions
 *
 * @author Marko Zajc
 */
public class Utilities {

	/**
	 * Rethrows a checked exception as unchecked using generics trickery (the exception
	 * is not changed or wrapped in a {@link RuntimeException} - it is thrown as-is).
	 *
	 * @param <X>
	 *            the exception type
	 * @param ex
	 *            the exception to throw as unchecked
	 *
	 * @return the exception itself to support {@code throws asUnchecked(e);}. Note that
	 *         it is thrown in this method and nothing is ever returned
	 *
	 * @throws X
	 *             the exception you provide. Always thrown.
	 */
	@SuppressWarnings("unchecked")
	public static <X extends Throwable> RuntimeException asUnchecked(@Nonnull Throwable ex) throws X {
		throw (X) ex;
	}

	private Utilities() {}

}
