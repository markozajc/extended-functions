package com.github.markozajc.ef.supplier.except.all;

import java.util.function.Supplier;

import com.github.markozajc.ef.supplier.except.ESupplier;

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
