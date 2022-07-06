package com.github.markozajc.ef.predicate;

import java.util.function.Predicate;

/**
 * A variant of {@link Predicate} that takes a primitive long.
 *
 * @author Marko Zajc
 */
public interface LongPredicate {

	/**
	 * Evaluates this predicate on the given argument.
	 *
	 * @param p
	 *            the input argument
	 *
	 * @return {@code true} if the input argument matches the predicate, otherwise
	 *         {@code false}
	 */
	long test(long p);

}
