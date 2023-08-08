package org.eu.zajc.ef.bipredicate.except.all;

import org.eu.zajc.ef.bipredicate.ObjBooleanPredicate;
import org.eu.zajc.ef.bipredicate.except.EObjBooleanPredicate;

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
