package org.eu.zajc.ef.supplier.except.all;

import java.util.function.Supplier;

import org.eu.zajc.ef.supplier.except.ESupplier;

/**
 * Variant of {@link Supplier} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of results supplied by this supplier
 */
@FunctionalInterface
public interface AESupplier<T> extends ESupplier<T, Exception> {}
