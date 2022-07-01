package org.eu.zajc.functions.exceptionable;

class Utilities {

	// step 1) take Throwable
	// step 2) cast to generic X extends Throwable
	// step 3) java assumes X is unchecked (??)
	// step 4) throw
	// step 5) checked exception is now unchecked (????)
	@SuppressWarnings("unchecked")
	static <X extends Throwable> RuntimeException asUnchecked(Throwable ex) throws X {
		throw (X) ex;
	}

	private Utilities() {}

}
