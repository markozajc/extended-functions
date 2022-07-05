package com.github.markozajc.ef.supplier.except.all;

import java.util.function.LongSupplier;

import com.github.markozajc.ef.supplier.except.ELongSupplier;

/**
 * Variant of {@link LongSupplier} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 */
@FunctionalInterface
public interface AELongSupplier extends ELongSupplier<Exception> {}
