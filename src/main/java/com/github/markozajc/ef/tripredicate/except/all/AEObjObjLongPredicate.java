package com.github.markozajc.ef.tripredicate.except.all;

import com.github.markozajc.ef.tripredicate.ObjObjLongPredicate;
import com.github.markozajc.ef.tripredicate.except.EObjObjLongPredicate;

/**
 * Variant of {@link ObjObjLongPredicate} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the predicate
 * @param <U>
 *            the type of the second argument the predicate
 */
@FunctionalInterface
public interface AEObjObjLongPredicate<T, U> extends EObjObjLongPredicate<T, U, Exception> {}
