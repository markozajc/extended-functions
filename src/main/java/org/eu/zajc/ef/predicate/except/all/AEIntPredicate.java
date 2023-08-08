package org.eu.zajc.ef.predicate.except.all;

import java.util.function.IntPredicate;

import org.eu.zajc.ef.predicate.except.EIntPredicate;

/**
 * Variant of {@link IntPredicate} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface AEIntPredicate extends EIntPredicate<Exception> {}
