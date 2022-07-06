package com.github.markozajc.ef.predicate.except;

import static com.github.markozajc.ef.Utilities.asUnchecked;

import com.github.markozajc.ef.predicate.IntPredicate;

/**
 * Variant of {@link IntPredicate} capable of throwing a generic {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface EIntPredicate<E extends Throwable> extends IntPredicate {

	@Override
	default boolean test(int p) {
		try {
			return testChecked(p);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #test(int)}, but throws a checked exception.
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
	boolean testChecked(int p) throws E;

}
