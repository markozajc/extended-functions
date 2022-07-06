package com.github.markozajc.ef.tripredicate;

/**
 * A variant of {@link TriPredicate} that takes two generic types and a primitive
 * boolean.
 *
 * @param <T>
 *            the type of the first argument to the predicate
 * @param <U>
 *            the type of the second argument to the predicate
 *
 * @author Marko Zajc
 */
public interface ObjObjBooleanPredicate<T, U> {

	/**
	 * Evaluates this predicate on the given arguments.
	 *
	 * @param t
	 *            the first input argument
	 * @param u
	 *            the second input argument
	 * @param p
	 *            the second ({@code boolean}) input argument
	 *
	 * @return {@code true} if the input arguments match the predicate, otherwise
	 *         {@code false}
	 */
	boolean test(T t, U u, boolean p);

}
