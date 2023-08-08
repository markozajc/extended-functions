
package org.eu.zajc.ef.trifunction.except;

import static org.eu.zajc.ef.Utilities.asUnchecked;

import org.eu.zajc.ef.trifunction.ObjObjByteFunction;

/**
 * Variant of {@link ObjObjByteFunction} capable of throwing a generic
 * {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the function
 * @param <U>
 *            the type of the second argument to the function
 * @param <R>
 *            the type of the result of the function
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface EObjObjByteFunction<T, U, R, E extends Throwable> extends ObjObjByteFunction<T, U, R> {

	@Override
	default R apply(T t, U u, byte p) {
		try {
			return applyChecked(t, u, p);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #apply(Object, Object, byte)}, but throws a checked exception.
	 *
	 * @param t
	 *            the first function argument
	 * @param u
	 *            the second function argument
	 * @param p
	 *            the third ({@code byte}) function argument
	 *
	 * @return the function result
	 *
	 * @throws E
	 *             the defined exception type
	 */
	R applyChecked(T t, U u, byte p) throws E;

}
