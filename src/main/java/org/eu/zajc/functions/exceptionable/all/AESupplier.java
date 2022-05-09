package org.eu.zajc.functions.exceptionable.all;

import org.eu.zajc.functions.exceptionable.ESupplier;

@FunctionalInterface
public interface AESupplier<T> extends ESupplier<T, Exception> {}
