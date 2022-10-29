package com.github.markozajc.ef.predicate.except;

import static com.github.markozajc.ef.Utilities.asUnchecked;

import java.util.function.LongPredicate;

/**
 * Variant of {@link LongPredicate} capable of throwing a generic {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface ELongPredicate<E extends Throwable> extends LongPredicate {

	@Override
	default boolean test(long p) {
		try {
			return testChecked(p);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #test(long)}, but throws a checked exception.
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
	boolean testChecked(long p) throws E;

}
