package org.eu.zajc.ef.bipredicate.except.all;

import org.eu.zajc.ef.bipredicate.ObjIntPredicate;
import org.eu.zajc.ef.bipredicate.except.EObjIntPredicate;

/**
 * Variant of {@link ObjIntPredicate} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the predicate
 */
@FunctionalInterface
public interface AEObjIntPredicate<T> extends EObjIntPredicate<T, Exception> {}
