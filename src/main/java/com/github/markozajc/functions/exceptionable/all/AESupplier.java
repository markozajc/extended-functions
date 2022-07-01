package com.github.markozajc.functions.exceptionable.all;

import java.util.function.Supplier;

import com.github.markozajc.functions.exceptionable.ESupplier;

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
