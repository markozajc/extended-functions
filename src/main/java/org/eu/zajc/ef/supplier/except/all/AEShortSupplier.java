package org.eu.zajc.ef.supplier.except.all;

import org.eu.zajc.ef.supplier.ShortSupplier;
import org.eu.zajc.ef.supplier.except.EShortSupplier;

/**
 * Variant of {@link ShortSupplier} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 */
@FunctionalInterface
public interface AEShortSupplier extends EShortSupplier<Exception> {}
