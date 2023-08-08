package org.eu.zajc.ef.supplier.except.all;

import org.eu.zajc.ef.supplier.ByteSupplier;
import org.eu.zajc.ef.supplier.except.EByteSupplier;

/**
 * Variant of {@link ByteSupplier} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 */
@FunctionalInterface
public interface AEByteSupplier extends EByteSupplier<Exception> {}
