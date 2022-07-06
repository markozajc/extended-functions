package com.github.markozajc.ef.bipredicate.except;

import static com.github.markozajc.ef.Utilities.asUnchecked;

import java.util.function.BiPredicate;

/**
 * Variant of {@link BiPredicate} capable of throwing a generic {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the predicate
 * @param <U>
 *            the type of the second argument the predicate
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface EBiPredicate<T, U, E extends Throwable> extends BiPredicate<T, U> {

	@Override
	default boolean test(T t, U u) {
		try {
			return testChecked(t, u);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #test(Object, Object)}, but throws a checked exception.
	 *
	 * @param t
	 *            the first input argument
	 * @param u
	 *            the second input argument
	 *
	 * @return {@code true} if the input arguments match the predicate, otherwise
	 *         {@code false}
	 *
	 * @throws E
	 *             the defined exception type
	 */
	boolean testChecked(T t, U u) throws E;

}
