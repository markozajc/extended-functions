package org.eu.zajc.ef.predicate.except.all;

import org.eu.zajc.ef.predicate.BytePredicate;
import org.eu.zajc.ef.predicate.except.EBytePredicate;

/**
 * Variant of {@link BytePredicate} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface AEBytePredicate extends EBytePredicate<Exception> {}
