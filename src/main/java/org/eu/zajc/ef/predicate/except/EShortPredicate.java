package org.eu.zajc.ef.predicate.except;

import static org.eu.zajc.ef.Utilities.asUnchecked;

import org.eu.zajc.ef.predicate.ShortPredicate;

/**
 * Variant of {@link ShortPredicate} capable of throwing a generic {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface EShortPredicate<E extends Throwable> extends ShortPredicate {

	@Override
	default boolean test(short p) {
		try {
			return testChecked(p);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #test(short)}, but throws a checked exception.
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
	boolean testChecked(short p) throws E;

}
