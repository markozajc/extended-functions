package org.eu.zajc.functions.exceptionable;

class Utilities {

	@SuppressWarnings("unchecked")
	static <X extends Throwable> RuntimeException asUnchecked(Throwable ex) throws X {
		throw (X) ex;
	}

	private Utilities() {}

}
