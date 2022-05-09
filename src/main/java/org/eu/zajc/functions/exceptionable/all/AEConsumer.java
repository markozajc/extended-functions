package org.eu.zajc.functions.exceptionable.all;

import org.eu.zajc.functions.exceptionable.EConsumer;

@FunctionalInterface
public interface AEConsumer<T> extends EConsumer<T, Exception> {}
