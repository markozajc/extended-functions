package com.github.markozajc.ef.predicate.except.all;

import com.github.markozajc.ef.predicate.BooleanPredicate;
import com.github.markozajc.ef.predicate.except.EBooleanPredicate;

/**
 * Variant of {@link BooleanPredicate} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface AEBooleanPredicate extends EBooleanPredicate<Exception> {}
