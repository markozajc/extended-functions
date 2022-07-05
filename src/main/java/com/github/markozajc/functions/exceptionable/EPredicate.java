package com.github.markozajc.functions.exceptionable;

import static com.github.markozajc.functions.exceptionable.Utilities.asUnchecked;

import java.util.function.Predicate;

/**
 * Variant of {@link Predicate} capable of throwing a generic {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the input to the predicate
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface EPredicate<T, E extends Throwable> extends Predicate<T> {

	@Override
	default boolean test(T t) {
		try {
			return testChecked(t);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #test(Object)}, but throws a checked exception.
	 *
	 * @param t
	 *            the input argument
	 *
	 * @return {@code true} if the input argument matches the predicate, otherwise
	 *         {@code false}
	 *
	 * @throws E
	 *             the defined exception type
	 */
	boolean testChecked(T t) throws E;

}
