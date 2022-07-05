package com.github.markozajc.ef.supplier.except.all;

import com.github.markozajc.ef.supplier.ByteSupplier;
import com.github.markozajc.ef.supplier.except.EByteSupplier;

/**
 * Variant of {@link ByteSupplier} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 */
@FunctionalInterface
public interface AEByteSupplier extends EByteSupplier<Exception> {}
