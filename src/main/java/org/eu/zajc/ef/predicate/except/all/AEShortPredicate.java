package org.eu.zajc.ef.predicate.except.all;

import org.eu.zajc.ef.predicate.ShortPredicate;
import org.eu.zajc.ef.predicate.except.EShortPredicate;

/**
 * Variant of {@link ShortPredicate} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface AEShortPredicate extends EShortPredicate<Exception> {}
