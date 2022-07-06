package com.github.markozajc.ef.tripredicate.except.all;

import com.github.markozajc.ef.tripredicate.ObjObjBytePredicate;
import com.github.markozajc.ef.tripredicate.except.EObjObjBytePredicate;

/**
 * Variant of {@link ObjObjBytePredicate} capable of throwing an
 * {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the predicate
 * @param <U>
 *            the type of the second argument the predicate
 */
@FunctionalInterface
public interface AEObjObjBytePredicate<T, U> extends EObjObjBytePredicate<T, U, Exception> {}
