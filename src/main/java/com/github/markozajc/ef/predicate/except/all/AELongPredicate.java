package com.github.markozajc.ef.predicate.except.all;

import com.github.markozajc.ef.predicate.LongPredicate;
import com.github.markozajc.ef.predicate.except.ELongPredicate;

/**
 * Variant of {@link LongPredicate} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface AELongPredicate extends ELongPredicate<Exception> {}
