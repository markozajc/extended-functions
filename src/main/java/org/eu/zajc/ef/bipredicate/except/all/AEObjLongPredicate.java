package org.eu.zajc.ef.bipredicate.except.all;

import org.eu.zajc.ef.bipredicate.ObjLongPredicate;
import org.eu.zajc.ef.bipredicate.except.EObjLongPredicate;

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
