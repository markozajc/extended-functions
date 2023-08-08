package org.eu.zajc.ef.predicate.except;

import static org.eu.zajc.ef.Utilities.asUnchecked;

import org.eu.zajc.ef.predicate.BytePredicate;

/**
 * Variant of {@link BytePredicate} capable of throwing a generic {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface EBytePredicate<E extends Throwable> extends BytePredicate {

	@Override
	default boolean test(byte p) {
		try {
			return testChecked(p);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #test(byte)}, but throws a checked exception.
	 *
	 * @param p
	 *            the input argument
	 *
	 * @return {@code true} if the input argument matches the predicate, otherwise
	 *         {@code false}
	 *
	 * @throws E
	 *             the defined exception type
	 */
	boolean testChecked(byte p) throws E;

}
