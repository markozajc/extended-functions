package com.github.markozajc.ef.supplier.except.all;

import java.util.function.BooleanSupplier;

import com.github.markozajc.ef.supplier.except.EBooleanSupplier;

/**
 * Variant of {@link BooleanSupplier} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 */
@FunctionalInterface
public interface AEBooleanSupplier extends EBooleanSupplier<Exception> {}
