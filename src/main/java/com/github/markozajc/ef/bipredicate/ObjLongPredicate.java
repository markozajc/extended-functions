package com.github.markozajc.ef.bipredicate;

import java.util.function.BiPredicate;

/**
 * A variant of {@link BiPredicate} that takes a generic type and a primitive long.
 *
 * @param <T>
 *            the type of the first argument to the predicate
 *
 * @author Marko Zajc
 */
public interface ObjLongPredicate<T> {

	/**
	 * Evaluates this predicate on the given arguments.
	 *
	 * @param t
	 *            the first input argument
	 * @param p
	 *            the second ({@code long}) input argument
	 *
	 * @return {@code true} if the input arguments match the predicate, otherwise
	 *         {@code false}
	 */
	boolean test(T t, long p);

}
