package org.eu.zajc.ef.tripredicate.except.all;

import org.eu.zajc.ef.tripredicate.ObjObjIntPredicate;
import org.eu.zajc.ef.tripredicate.except.EObjObjIntPredicate;

/**
 * Variant of {@link ObjObjIntPredicate} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the predicate
 * @param <U>
 *            the type of the second argument the predicate
 */
@FunctionalInterface
public interface AEObjObjIntPredicate<T, U> extends EObjObjIntPredicate<T, U, Exception> {}
