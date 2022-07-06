package com.github.markozajc.ef.bipredicate.except.all;

import com.github.markozajc.ef.bipredicate.ObjBooleanPredicate;
import com.github.markozajc.ef.bipredicate.except.EObjBooleanPredicate;

/**
 * Variant of {@link ObjBooleanPredicate} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the predicate
 */
@FunctionalInterface
public interface AEObjBooleanPredicate<T> extends EObjBooleanPredicate<T, Exception> {}
