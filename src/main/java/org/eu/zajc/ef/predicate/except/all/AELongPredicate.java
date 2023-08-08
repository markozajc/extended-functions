package org.eu.zajc.ef.predicate.except.all;

import java.util.function.LongPredicate;

import org.eu.zajc.ef.predicate.except.ELongPredicate;

/**
 * Variant of {@link LongPredicate} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface AELongPredicate extends ELongPredicate<Exception> {}
