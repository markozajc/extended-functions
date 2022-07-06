package com.github.markozajc.ef.bipredicate.except.all;

import com.github.markozajc.ef.bipredicate.ObjLongPredicate;
import com.github.markozajc.ef.bipredicate.except.EObjLongPredicate;

/**
 * Variant of {@link ObjLongPredicate} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the predicate
 */
@FunctionalInterface
public interface AEObjLongPredicate<T> extends EObjLongPredicate<T, Exception> {}
