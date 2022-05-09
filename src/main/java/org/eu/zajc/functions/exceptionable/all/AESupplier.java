package org.eu.zajc.functions.exceptionable.all;

import java.util.function.Supplier;

import org.eu.zajc.functions.exceptionable.ESupplier;

/**
 * Variant of {@link Supplier} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 */
@FunctionalInterface
public interface AESupplier<T> extends ESupplier<T, Exception> {}
