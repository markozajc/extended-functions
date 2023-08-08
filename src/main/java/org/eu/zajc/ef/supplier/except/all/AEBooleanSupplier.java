package org.eu.zajc.ef.supplier.except.all;

import java.util.function.BooleanSupplier;

import org.eu.zajc.ef.supplier.except.EBooleanSupplier;

/**
 * Variant of {@link BooleanSupplier} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 */
@FunctionalInterface
public interface AEBooleanSupplier extends EBooleanSupplier<Exception> {}
