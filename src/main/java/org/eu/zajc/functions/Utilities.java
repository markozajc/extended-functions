package org.eu.zajc.functions;

public class Utilities {

	@SuppressWarnings("unchecked")
	public static <X extends Throwable> RuntimeException asUnchecked(Throwable ex) throws X {
		throw (X) ex;
	}

	private Utilities() {}

}
