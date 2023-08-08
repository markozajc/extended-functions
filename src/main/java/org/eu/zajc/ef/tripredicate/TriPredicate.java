package org.eu.zajc.ef.tripredicate;

import java.util.function.Predicate;

/**
 * A {@link Predicate} variant that takes three generic types.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the predicate
 * @param <U>
 *            the type of the second argument the predicate
 * @param <V>
 *            the type of the third argument the predicate
 */
@FunctionalInterface
public interface TriPredicate<T, U, V> {

	/**
	 * Evaluates this predicate on the given arguments.
	 *
	 * @param t
	 *            the first input argument
	 * @param u
	 *            the second input argument
	 * @param v
	 *            the third input argument
	 *
	 * @return {@code true} if the input arguments match the predicate, otherwise
	 *         {@code false}
	 */
	boolean test(T t, U u, V v);

}
