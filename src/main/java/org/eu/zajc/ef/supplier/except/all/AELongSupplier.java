package org.eu.zajc.ef.supplier.except.all;

import java.util.function.LongSupplier;

import org.eu.zajc.ef.supplier.except.ELongSupplier;

/**
 * Variant of {@link LongSupplier} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 */
@FunctionalInterface
public interface AELongSupplier extends ELongSupplier<Exception> {}
