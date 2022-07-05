package com.github.markozajc.ef.supplier.except.all;

import java.util.function.IntSupplier;

import com.github.markozajc.ef.supplier.except.EIntSupplier;

/**
 * Variant of {@link IntSupplier} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 */
@FunctionalInterface
public interface AEIntSupplier extends EIntSupplier<Exception> {}
