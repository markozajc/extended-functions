package com.github.markozajc.ef.supplier.except.all;

import com.github.markozajc.ef.supplier.ShortSupplier;
import com.github.markozajc.ef.supplier.except.EShortSupplier;

/**
 * Variant of {@link ShortSupplier} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 */
@FunctionalInterface
public interface AEShortSupplier extends EShortSupplier<Exception> {}
