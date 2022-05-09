package org.eu.zajc.functions.exceptionable.all;

import org.eu.zajc.functions.exceptionable.EBiConsumer;

@FunctionalInterface
public interface AEBiConsumer<T, U> extends EBiConsumer<T, U, Exception> {}
