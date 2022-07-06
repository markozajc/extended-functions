package com.github.markozajc.ef.triconsumer.except;

import static com.github.markozajc.ef.Utilities.asUnchecked;

import com.github.markozajc.ef.triconsumer.ObjObjBooleanConsumer;

/**
 * Variant of {@link ObjObjBooleanConsumer} capable of throwing a generic
 * {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the operation
 * @param <U>
 *            the type of the second argument to the operation
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface EObjObjBooleanConsumer<T, U, E extends Throwable> extends ObjObjBooleanConsumer<T, U> {

	@Override
	default void accept(T t, U u, boolean p) {
		try {
			acceptChecked(t, u, p);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #accept(Object, Object, boolean)}, but throws a checked exception.
	 *
	 * @param t
	 *            the first input argument
	 * @param u
	 *            the second input argument
	 * @param p
	 *            the third ({$code boolean})input argument
	 *
	 * @throws E
	 *             the defined exception type
	 */
	void acceptChecked(T t, U u, boolean p) throws E;

}
