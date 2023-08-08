package org.eu.zajc.ef.predicate.except.all;

import org.eu.zajc.ef.predicate.BooleanPredicate;
import org.eu.zajc.ef.predicate.except.EBooleanPredicate;

/**
 * Variant of {@link BooleanPredicate} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface AEBooleanPredicate extends EBooleanPredicate<Exception> {}
