package com.github.markozajc.ef.predicate.except.all;

import com.github.markozajc.ef.predicate.BytePredicate;
import com.github.markozajc.ef.predicate.except.EBytePredicate;

/**
 * Variant of {@link BytePredicate} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface AEBytePredicate extends EBytePredicate<Exception> {}
