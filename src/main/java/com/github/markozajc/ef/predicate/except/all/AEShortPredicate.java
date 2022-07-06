package com.github.markozajc.ef.predicate.except.all;

import com.github.markozajc.ef.predicate.ShortPredicate;
import com.github.markozajc.ef.predicate.except.EShortPredicate;

/**
 * Variant of {@link ShortPredicate} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface AEShortPredicate extends EShortPredicate<Exception> {}
