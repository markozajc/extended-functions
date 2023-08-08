package org.eu.zajc.ef;

import static org.eu.zajc.ef.Utilities.asUnchecked;

import java.util.concurrent.Callable;
import java.util.function.*;

import javax.annotation.Nonnull;

import org.eu.zajc.ef.biconsumer.*;
import org.eu.zajc.ef.biconsumer.except.*;
import org.eu.zajc.ef.bifunction.*;
import org.eu.zajc.ef.bifunction.except.*;
import org.eu.zajc.ef.bipredicate.*;
import org.eu.zajc.ef.bipredicate.except.*;
import org.eu.zajc.ef.consumer.*;
import org.eu.zajc.ef.consumer.execpt.*;
import org.eu.zajc.ef.function.*;
import org.eu.zajc.ef.function.except.*;
import org.eu.zajc.ef.predicate.*;
import org.eu.zajc.ef.predicate.except.*;
import org.eu.zajc.ef.runnable.except.ERunnable;
import org.eu.zajc.ef.supplier.*;
import org.eu.zajc.ef.supplier.except.*;
import org.eu.zajc.ef.triconsumer.*;
import org.eu.zajc.ef.trifunction.*;
import org.eu.zajc.ef.tripredicate.*;

/**
 * A class containing various helper utilities for exceptionable (E*) functions and
 * {@link Callable} ({@link ESupplier}).
 *
 * @author Marko Zajc
 */
public class EHandle {

	/*
	 * ================== Consumers ==================
	 */

	/**
	 * Handles a generic exception type that may occur in the handled consumer with a
	 * provided handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed consumer
	 */
	@Nonnull
	public static <T, E extends Throwable> Consumer<T> handle(@Nonnull EConsumer<T, E> handled,
															  @Nonnull BiConsumer<Throwable, T> handler) {
		return t -> {
			try {
				handled.acceptChecked(t);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				handler.accept(e, t);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled consumer by
	 * throwing a different exception.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param <X>
	 *            The exception type to throw
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed consumer
	 *
	 * @throws X
	 *             The exception returned by the handler
	 */
	@Nonnull
	@SuppressWarnings({ "null", "unused" })
	public static <T, E extends Throwable, X extends Throwable> Consumer<T> handleThrowing(@Nonnull EConsumer<T, E> handled,
																						   @Nonnull Function<Throwable, X> handler) throws X {
		return t -> {
			try {
				handled.acceptChecked(t);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(handler.apply(e));
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled consumer by
	 * throwing it explicitly.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 *
	 * @return An exception-proofed consumer
	 *
	 * @throws E
	 *             The checked exception
	 */
	@Nonnull
	@SuppressWarnings("unused")
	public static <T, E extends Throwable> Consumer<T> handleThrowing(@Nonnull EConsumer<T, E> handled) throws E {
		return t -> {
			try {
				handled.acceptChecked(t);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(e);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled consumer by
	 * throwing a different exception.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed consumer
	 */
	@Nonnull
	public static <E extends Throwable> BooleanConsumer handle(@Nonnull EBooleanConsumer<E> handled,
															   @Nonnull ObjBooleanConsumer<Throwable> handler) {
		return p -> {
			try {
				handled.acceptChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				handler.accept(e, p);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled consumer by
	 * throwing a different exception.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param <X>
	 *            The exception type to throw
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed consumer
	 *
	 * @throws X
	 *             The exception returned by the handler
	 */
	@Nonnull
	@SuppressWarnings({ "null", "unused" })
	public static <E extends Throwable, X extends Throwable> BooleanConsumer handleThrowing(@Nonnull EBooleanConsumer<E> handled,
																							@Nonnull Function<Throwable, X> handler) throws X {
		return p -> {
			try {
				handled.acceptChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(handler.apply(e));
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled consumer by
	 * throwing it explicitly.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 *
	 * @return An exception-proofed consumer
	 *
	 * @throws E
	 *             The checked exception
	 */
	@Nonnull
	@SuppressWarnings("unused")
	public static <E extends Throwable> BooleanConsumer handleThrowing(@Nonnull EBooleanConsumer<E> handled) throws E {
		return p -> {
			try {
				handled.acceptChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(e);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled consumer with a
	 * provided handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed consumer
	 */
	@Nonnull
	public static <E extends Throwable> ByteConsumer handle(@Nonnull EByteConsumer<E> handled,
															@Nonnull ObjByteConsumer<Throwable> handler) {
		return p -> {
			try {
				handled.acceptChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				handler.accept(e, p);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled consumer by
	 * throwing a different exception.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param <X>
	 *            The exception type to throw
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed consumer
	 *
	 * @throws X
	 *             The exception returned by the handler
	 */
	@Nonnull
	@SuppressWarnings({ "null", "unused" })
	public static <E extends Throwable, X extends Throwable> ByteConsumer handleThrowing(@Nonnull EByteConsumer<E> handled,
																						 @Nonnull Function<Throwable, X> handler) throws X {
		return p -> {
			try {
				handled.acceptChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(handler.apply(e));
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled consumer by
	 * throwing it explicitly.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 *
	 * @return An exception-proofed consumer
	 *
	 * @throws E
	 *             The checked exception
	 */
	@Nonnull
	@SuppressWarnings("unused")
	public static <E extends Throwable> ByteConsumer handleThrowing(@Nonnull EByteConsumer<E> handled) throws E {
		return p -> {
			try {
				handled.acceptChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(e);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled consumer with a
	 * provided handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed consumer
	 */
	@Nonnull
	public static <E extends Throwable> IntConsumer handle(@Nonnull EIntConsumer<E> handled,
														   @Nonnull ObjIntConsumer<Throwable> handler) {
		return p -> {
			try {
				handled.acceptChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				handler.accept(e, p);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled consumer by
	 * throwing a different exception.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param <X>
	 *            The exception type to throw
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed consumer
	 *
	 * @throws X
	 *             The exception returned by the handler
	 */
	@Nonnull
	@SuppressWarnings({ "null", "unused" })
	public static <E extends Throwable, X extends Throwable> IntConsumer handleThrowing(@Nonnull EIntConsumer<E> handled,
																						@Nonnull Function<Throwable, X> handler) throws X {
		return p -> {
			try {
				handled.acceptChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(handler.apply(e));
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled consumer by
	 * throwing it explicitly.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 *
	 * @return An exception-proofed consumer
	 *
	 * @throws E
	 *             The checked exception
	 */
	@Nonnull
	@SuppressWarnings("unused")
	public static <E extends Throwable> IntConsumer handleThrowing(@Nonnull EIntConsumer<E> handled) throws E {
		return p -> {
			try {
				handled.acceptChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(e);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled consumer with a
	 * provided handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed consumer
	 */
	@Nonnull
	public static <E extends Throwable> LongConsumer handle(@Nonnull ELongConsumer<E> handled,
															@Nonnull ObjLongConsumer<Throwable> handler) {
		return p -> {
			try {
				handled.acceptChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				handler.accept(e, p);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled consumer by
	 * throwing a different exception.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param <X>
	 *            The exception type to throw
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed consumer
	 *
	 * @throws X
	 *             The exception returned by the handler
	 */
	@Nonnull
	@SuppressWarnings({ "null", "unused" })
	public static <E extends Throwable, X extends Throwable> LongConsumer handleThrowing(@Nonnull ELongConsumer<E> handled,
																						 @Nonnull Function<Throwable, X> handler) throws X {
		return p -> {
			try {
				handled.acceptChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(handler.apply(e));
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled consumer by
	 * throwing it explicitly.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 *
	 * @return An exception-proofed consumer
	 *
	 * @throws E
	 *             The checked exception
	 */
	@Nonnull
	@SuppressWarnings("unused")
	public static <E extends Throwable> LongConsumer handleThrowing(@Nonnull ELongConsumer<E> handled) throws E {
		return p -> {
			try {
				handled.acceptChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(e);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled consumer with a
	 * provided handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed consumer
	 */
	@Nonnull
	public static <E extends Throwable> ShortConsumer handle(@Nonnull EShortConsumer<E> handled,
															 @Nonnull ObjShortConsumer<Throwable> handler) {
		return p -> {
			try {
				handled.acceptChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				handler.accept(e, p);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled consumer by
	 * throwing a different exception.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param <X>
	 *            The exception type to throw
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed consumer
	 *
	 * @throws X
	 *             The exception returned by the handler
	 */
	@Nonnull
	@SuppressWarnings({ "null", "unused" })
	public static <E extends Throwable, X extends Throwable> ShortConsumer handleThrowing(@Nonnull EShortConsumer<E> handled,
																						  @Nonnull Function<Throwable, X> handler) throws X {
		return p -> {
			try {
				handled.acceptChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(handler.apply(e));
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled consumer by
	 * throwing it explicitly.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 *
	 * @return An exception-proofed consumer
	 *
	 * @throws E
	 *             The checked exception
	 */
	@Nonnull
	@SuppressWarnings("unused")
	public static <E extends Throwable> ShortConsumer handleThrowing(@Nonnull EShortConsumer<E> handled) throws E {
		return p -> {
			try {
				handled.acceptChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(e);
			}
		};
	}

	/*
	 * ================== BiConsumers ==================
	 */

	/**
	 * Handles a generic exception type that may occur in the handled consumer with a
	 * provided handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed consumer
	 */
	@Nonnull
	public static <T, U, E extends Throwable> BiConsumer<T, U> handle(@Nonnull EBiConsumer<T, U, E> handled,
																	  @Nonnull TriConsumer<Throwable, T, U> handler) {
		return (t, u) -> {
			try {
				handled.acceptChecked(t, u);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				handler.accept(e, t, u);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled consumer by
	 * throwing a different exception.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param <X>
	 *            The exception type to throw
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed consumer
	 *
	 * @throws X
	 *             The exception returned by the handler
	 */
	@Nonnull
	@SuppressWarnings({ "null", "unused" })
	public static <T, U, E extends Throwable, X extends Throwable> BiConsumer<T, U> handleThrowing(@Nonnull EBiConsumer<T, U, E> handled,
																								   @Nonnull Function<Throwable, X> handler) throws X {
		return (t, u) -> {
			try {
				handled.acceptChecked(t, u);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(handler.apply(e));
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled consumer by
	 * throwing it explicitly.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 *
	 * @return An exception-proofed consumer
	 *
	 * @throws E
	 *             The checked exception
	 */
	@Nonnull
	@SuppressWarnings("unused")
	public static <T, U, E extends Throwable> BiConsumer<T, U> handleThrowing(@Nonnull EBiConsumer<T, U, E> handled) throws E {
		return (t, u) -> {
			try {
				handled.acceptChecked(t, u);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(e);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled consumer with a
	 * provided handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed consumer
	 */
	@Nonnull
	public static <T, E extends Throwable> ObjBooleanConsumer<T> handle(@Nonnull EObjBooleanConsumer<T, E> handled,
																		@Nonnull ObjObjBooleanConsumer<Throwable, T> handler) {
		return (t, p) -> {
			try {
				handled.acceptChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				handler.accept(e, t, p);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled consumer by
	 * throwing a different exception.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param <X>
	 *            The exception type to throw
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed consumer
	 *
	 * @throws X
	 *             The exception returned by the handler
	 */
	@Nonnull
	@SuppressWarnings({ "null", "unused" })
	public static <T, E extends Throwable, X extends Throwable> ObjBooleanConsumer<T> handleThrowing(@Nonnull EObjBooleanConsumer<T, E> handled,
																									 @Nonnull Function<Throwable, X> handler) throws X {
		return (t, p) -> {
			try {
				handled.acceptChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(handler.apply(e));
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled consumer by
	 * throwing it explicitly.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 *
	 * @return An exception-proofed consumer
	 *
	 * @throws E
	 *             The checked exception
	 */
	@Nonnull
	@SuppressWarnings("unused")
	public static <T, E extends Throwable> ObjBooleanConsumer<T> handleThrowing(@Nonnull EObjBooleanConsumer<T, E> handled) throws E {
		return (t, p) -> {
			try {
				handled.acceptChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(e);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled consumer with a
	 * provided handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed consumer
	 */
	@Nonnull
	public static <T, E extends Throwable> ObjByteConsumer<T> handle(@Nonnull EObjByteConsumer<T, E> handled,
																	 @Nonnull ObjObjByteConsumer<Throwable, T> handler) {
		return (t, p) -> {
			try {
				handled.acceptChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				handler.accept(e, t, p);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled consumer by
	 * throwing a different exception.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param <X>
	 *            The exception type to throw
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed consumer
	 *
	 * @throws X
	 *             The exception returned by the handler
	 */
	@Nonnull
	@SuppressWarnings({ "null", "unused" })
	public static <T, E extends Throwable, X extends Throwable> ObjByteConsumer<T> handleThrowing(@Nonnull EObjByteConsumer<T, E> handled,
																								  @Nonnull Function<Throwable, X> handler) throws X {
		return (t, p) -> {
			try {
				handled.acceptChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(handler.apply(e));
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled consumer by
	 * throwing it explicitly.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 *
	 * @return An exception-proofed consumer
	 *
	 * @throws E
	 *             The checked exception
	 */
	@Nonnull
	@SuppressWarnings("unused")
	public static <T, E extends Throwable> ObjByteConsumer<T> handleThrowing(@Nonnull EObjByteConsumer<T, E> handled) throws E {
		return (t, p) -> {
			try {
				handled.acceptChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(e);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled consumer with a
	 * provided handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed consumer
	 */
	@Nonnull
	public static <T, E extends Throwable> ObjIntConsumer<T> handle(@Nonnull EObjIntConsumer<T, E> handled,
																	@Nonnull ObjObjIntConsumer<Throwable, T> handler) {
		return (t, p) -> {
			try {
				handled.acceptChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				handler.accept(e, t, p);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled consumer by
	 * throwing a different exception.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param <X>
	 *            The exception type to throw
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed consumer
	 *
	 * @throws X
	 *             The exception returned by the handler
	 */
	@Nonnull
	@SuppressWarnings({ "null", "unused" })
	public static <T, E extends Throwable, X extends Throwable> ObjIntConsumer<T> handleThrowing(@Nonnull EObjIntConsumer<T, E> handled,
																								 @Nonnull Function<Throwable, X> handler) throws X {
		return (t, p) -> {
			try {
				handled.acceptChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(handler.apply(e));
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled consumer by
	 * throwing it explicitly.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 *
	 * @return An exception-proofed consumer
	 *
	 * @throws E
	 *             The checked exception
	 */
	@Nonnull
	@SuppressWarnings("unused")
	public static <T, E extends Throwable> ObjIntConsumer<T> handleThrowing(@Nonnull EObjIntConsumer<T, E> handled) throws E {
		return (t, p) -> {
			try {
				handled.acceptChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(e);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled consumer with a
	 * provided handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed consumer
	 */
	@Nonnull
	public static <T, E extends Throwable> ObjLongConsumer<T> handle(@Nonnull EObjLongConsumer<T, E> handled,
																	 @Nonnull ObjObjLongConsumer<Throwable, T> handler) {
		return (t, p) -> {
			try {
				handled.acceptChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				handler.accept(e, t, p);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled consumer by
	 * throwing a different exception.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param <X>
	 *            The exception type to throw
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed consumer
	 *
	 * @throws X
	 *             The exception returned by the handler
	 */
	@Nonnull
	@SuppressWarnings({ "null", "unused" })
	public static <T, E extends Throwable, X extends Throwable> ObjLongConsumer<T> handleThrowing(@Nonnull EObjLongConsumer<T, E> handled,
																								  @Nonnull Function<Throwable, X> handler) throws X {
		return (t, p) -> {
			try {
				handled.acceptChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(handler.apply(e));
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled consumer by
	 * throwing it explicitly.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 *
	 * @return An exception-proofed consumer
	 *
	 * @throws E
	 *             The checked exception
	 */
	@Nonnull
	@SuppressWarnings("unused")
	public static <T, E extends Throwable> ObjLongConsumer<T> handleThrowing(@Nonnull EObjLongConsumer<T, E> handled) throws E {
		return (t, p) -> {
			try {
				handled.acceptChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(e);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled consumer with a
	 * provided handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed consumer
	 */
	@Nonnull
	public static <T, E extends Throwable> ObjShortConsumer<T> handle(@Nonnull EObjShortConsumer<T, E> handled,
																	  @Nonnull ObjObjShortConsumer<Throwable, T> handler) {
		return (t, p) -> {
			try {
				handled.acceptChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				handler.accept(e, t, p);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled consumer by
	 * throwing a different exception.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param <X>
	 *            The exception type to throw
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed consumer
	 *
	 * @throws X
	 *             The exception returned by the handler
	 */
	@Nonnull
	@SuppressWarnings({ "null", "unused" })
	public static <T, E extends Throwable, X extends Throwable> ObjShortConsumer<T> handleThrowing(@Nonnull EObjShortConsumer<T, E> handled,
																								   @Nonnull Function<Throwable, X> handler) throws X {
		return (t, p) -> {
			try {
				handled.acceptChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(handler.apply(e));
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled consumer by
	 * throwing it explicitly.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 *
	 * @return An exception-proofed consumer
	 *
	 * @throws E
	 *             The checked exception
	 */
	@Nonnull
	@SuppressWarnings("unused")
	public static <T, E extends Throwable> ObjShortConsumer<T> handleThrowing(@Nonnull EObjShortConsumer<T, E> handled) throws E {
		return (t, p) -> {
			try {
				handled.acceptChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(e);
			}
		};
	}

	/*
	 * ================== Functions ==================
	 */

	/**
	 * Handles a generic exception type that may occur in the handled function with a
	 * provided handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <T, R, E extends Throwable> Function<T, R> handle(@Nonnull EFunction<T, R, E> handled,
																	@Nonnull BiFunction<Throwable, T, R> handler) {
		return t -> {
			try {
				return handled.applyChecked(t);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.apply(e, t);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled function by
	 * throwing a different exception.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param <X>
	 *            The exception type to throw
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 *
	 * @throws X
	 *             The exception returned by the handler
	 */
	@Nonnull
	@SuppressWarnings({ "null", "unused" })
	public static <T, R, E extends Throwable, X extends Throwable> Function<T, R> handleThrowing(@Nonnull EFunction<T, R, E> handled,
																								 @Nonnull Function<Throwable, X> handler) throws X {
		return t -> {
			try {
				return handled.applyChecked(t);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(handler.apply(e));
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled function by
	 * throwing it explicitly.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 *
	 * @return An exception-proofed function
	 *
	 * @throws E
	 *             The checked exception
	 */
	@Nonnull
	@SuppressWarnings("unused")
	public static <T, R, E extends Throwable> Function<T, R> handleThrowing(@Nonnull EFunction<T, R, E> handled) throws E {
		return t -> {
			try {
				return handled.applyChecked(t);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(e);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled function with a
	 * provided handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <R, E extends Throwable> BooleanFunction<R> handle(@Nonnull EBooleanFunction<R, E> handled,
																	 @Nonnull ObjBooleanFunction<Throwable, R> handler) {
		return p -> {
			try {
				return handled.applyChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.apply(e, p);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled function by
	 * throwing a different exception.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param <X>
	 *            The exception type to throw
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 *
	 * @throws X
	 *             The exception returned by the handler
	 */
	@Nonnull
	@SuppressWarnings({ "null", "unused" })
	public static <R, E extends Throwable, X extends Throwable> BooleanFunction<R> handleThrowing(@Nonnull EBooleanFunction<R, E> handled,
																								  @Nonnull Function<Throwable, X> handler) throws X {
		return p -> {
			try {
				return handled.applyChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(handler.apply(e));
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled function by
	 * throwing it explicitly.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 *
	 * @return An exception-proofed function
	 *
	 * @throws E
	 *             The checked exception
	 */
	@Nonnull
	@SuppressWarnings("unused")
	public static <R, E extends Throwable> BooleanFunction<R> handleThrowing(@Nonnull EBooleanFunction<R, E> handled) throws E {
		return p -> {
			try {
				return handled.applyChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(e);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled function with a
	 * provided handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <R, E extends Throwable> ByteFunction<R> handle(@Nonnull EByteFunction<R, E> handled,
																  @Nonnull ObjByteFunction<Throwable, R> handler) {
		return p -> {
			try {
				return handled.applyChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.apply(e, p);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled function by
	 * throwing a different exception.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param <X>
	 *            The exception type to throw
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 *
	 * @throws X
	 *             The exception returned by the handler
	 */
	@Nonnull
	@SuppressWarnings({ "null", "unused" })
	public static <R, E extends Throwable, X extends Throwable> ByteFunction<R> handleThrowing(@Nonnull EByteFunction<R, E> handled,
																							   @Nonnull Function<Throwable, X> handler) throws X {
		return p -> {
			try {
				return handled.applyChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(handler.apply(e));
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled function by
	 * throwing it explicitly.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 *
	 * @return An exception-proofed function
	 *
	 * @throws E
	 *             The checked exception
	 */
	@Nonnull
	@SuppressWarnings("unused")
	public static <R, E extends Throwable> ByteFunction<R> handleThrowing(@Nonnull EByteFunction<R, E> handled) throws E {
		return p -> {
			try {
				return handled.applyChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(e);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled function with a
	 * provided handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <R, E extends Throwable> IntFunction<R> handle(@Nonnull EIntFunction<R, E> handled,
																 @Nonnull ObjIntFunction<Throwable, R> handler) {
		return p -> {
			try {
				return handled.applyChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.apply(e, p);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled function by
	 * throwing a different exception.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param <X>
	 *            The exception type to throw
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 *
	 * @throws X
	 *             The exception returned by the handler
	 */
	@Nonnull
	@SuppressWarnings({ "null", "unused" })
	public static <R, E extends Throwable, X extends Throwable> IntFunction<R> handleThrowing(@Nonnull EIntFunction<R, E> handled,
																							  @Nonnull Function<Throwable, X> handler) throws X {
		return p -> {
			try {
				return handled.applyChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(handler.apply(e));
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled function by
	 * throwing it explicitly.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 *
	 * @return An exception-proofed function
	 *
	 * @throws E
	 *             The checked exception
	 */
	@Nonnull
	@SuppressWarnings("unused")
	public static <R, E extends Throwable> IntFunction<R> handleThrowing(@Nonnull EIntFunction<R, E> handled) throws E {
		return p -> {
			try {
				return handled.applyChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(e);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled function with a
	 * provided handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <R, E extends Throwable> LongFunction<R> handle(@Nonnull ELongFunction<R, E> handled,
																  @Nonnull ObjLongFunction<Throwable, R> handler) {
		return p -> {
			try {
				return handled.applyChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.apply(e, p);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled function by
	 * throwing a different exception.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param <X>
	 *            The exception type to throw
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 *
	 * @throws X
	 *             The exception returned by the handler
	 */
	@Nonnull
	@SuppressWarnings({ "null", "unused" })
	public static <R, E extends Throwable, X extends Throwable> LongFunction<R> handleThrowing(@Nonnull ELongFunction<R, E> handled,
																							   @Nonnull Function<Throwable, X> handler) throws X {
		return p -> {
			try {
				return handled.applyChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(handler.apply(e));
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled function by
	 * throwing it explicitly.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 *
	 * @return An exception-proofed function
	 *
	 * @throws E
	 *             The checked exception
	 */
	@Nonnull
	@SuppressWarnings("unused")
	public static <R, E extends Throwable, X extends Throwable> LongFunction<R> handleThrowing(@Nonnull ELongFunction<R, E> handled) throws E {
		return p -> {
			try {
				return handled.applyChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(e);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled function with a
	 * provided handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <R, E extends Throwable> ShortFunction<R> handle(@Nonnull EShortFunction<R, E> handled,
																   @Nonnull ObjShortFunction<Throwable, R> handler) {
		return p -> {
			try {
				return handled.applyChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.apply(e, p);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled function by
	 * throwing a different exception.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param <X>
	 *            The exception type to throw
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 *
	 * @throws X
	 *             The exception returned by the handler
	 */
	@Nonnull
	@SuppressWarnings({ "null", "unused" })
	public static <R, E extends Throwable, X extends Throwable> ShortFunction<R> handleThrowing(@Nonnull EShortFunction<R, E> handled,
																								@Nonnull Function<Throwable, X> handler) throws X {
		return p -> {
			try {
				return handled.applyChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(handler.apply(e));
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled function by
	 * throwing it explicitly.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 *
	 * @return An exception-proofed function
	 *
	 * @throws E
	 *             The checked exception
	 */
	@Nonnull
	@SuppressWarnings("unused")
	public static <R, E extends Throwable> ShortFunction<R> handleThrowing(@Nonnull EShortFunction<R, E> handled) throws E {
		return p -> {
			try {
				return handled.applyChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(e);
			}
		};
	}

	/*
	 * ================== BiFunctions ==================
	 */

	/**
	 * Handles a generic exception type that may occur in the handled function with a
	 * provided handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <T, U, R, E extends Throwable> BiFunction<T, U, R> handle(@Nonnull EBiFunction<T, U, R, E> handled,
																			@Nonnull TriFunction<Throwable, T, U, R> handler) {
		return (t, u) -> {
			try {
				return handled.applyChecked(t, u);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.apply(e, t, u);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled function by
	 * throwing a different exception.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param <X>
	 *            The exception type to throw
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 *
	 * @throws X
	 *             The exception returned by the handler
	 */
	@Nonnull
	@SuppressWarnings({ "null", "unused" })
	public static <T, U, R, E extends Throwable, X extends Throwable> BiFunction<T, U, R> handleThrowing(@Nonnull EBiFunction<T, U, R, E> handled,
																										 @Nonnull Function<Throwable, X> handler) throws X {
		return (t, u) -> {
			try {
				return handled.applyChecked(t, u);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(handler.apply(e));
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled function by
	 * throwing it explicitly.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 *
	 * @return An exception-proofed function
	 *
	 * @throws E
	 *             The checked exception
	 */
	@Nonnull
	@SuppressWarnings("unused")
	public static <T, U, R, E extends Throwable> BiFunction<T, U, R> handleThrowing(@Nonnull EBiFunction<T, U, R, E> handled) throws E {
		return (t, u) -> {
			try {
				return handled.applyChecked(t, u);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(e);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled function with a
	 * provided handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <T, R, E extends Throwable> ObjBooleanFunction<T, R> handle(@Nonnull EObjBooleanFunction<T, R, E> handled,
																			  @Nonnull ObjObjBooleanFunction<Throwable, T, R> handler) {
		return (t, p) -> {
			try {
				return handled.applyChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.apply(e, t, p);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled function by
	 * throwing a different exception.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param <X>
	 *            The exception type to throw
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 *
	 * @throws X
	 *             The exception returned by the handler
	 */
	@Nonnull
	@SuppressWarnings({ "null", "unused" })
	public static <T, R, E extends Throwable, X extends Throwable> ObjBooleanFunction<T, R> handleThrowing(@Nonnull EObjBooleanFunction<T, R, E> handled,
																										   @Nonnull Function<Throwable, X> handler) throws X {
		return (t, p) -> {
			try {
				return handled.applyChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(handler.apply(e));
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled function by
	 * throwing it explicitly.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 *
	 * @return An exception-proofed function
	 *
	 * @throws E
	 *             The checked exception
	 */
	@Nonnull
	@SuppressWarnings("unused")
	public static <T, R, E extends Throwable> ObjBooleanFunction<T, R> handleThrowing(@Nonnull EObjBooleanFunction<T, R, E> handled) throws E {
		return (t, p) -> {
			try {
				return handled.applyChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(e);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled function with a
	 * provided handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <T, R, E extends Throwable> ObjByteFunction<T, R> handle(@Nonnull EObjByteFunction<T, R, E> handled,
																		   @Nonnull ObjObjByteFunction<Throwable, T, R> handler) {
		return (t, p) -> {
			try {
				return handled.applyChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.apply(e, t, p);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled function by
	 * throwing a different exception.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param <X>
	 *            The exception type to throw
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 *
	 * @throws X
	 *             The exception returned by the handler
	 */
	@Nonnull
	@SuppressWarnings({ "null", "unused" })
	public static <T, R, E extends Throwable, X extends Throwable> ObjByteFunction<T, R> handleThrowing(@Nonnull EObjByteFunction<T, R, E> handled,
																										@Nonnull Function<Throwable, X> handler) throws X {
		return (t, p) -> {
			try {
				return handled.applyChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(handler.apply(e));
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled function by
	 * throwing it explicitly.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 *
	 * @return An exception-proofed function
	 *
	 * @throws E
	 *             The checked exception
	 */
	@Nonnull
	@SuppressWarnings("unused")
	public static <T, R, E extends Throwable> ObjByteFunction<T, R> handleThrowing(@Nonnull EObjByteFunction<T, R, E> handled) throws E {
		return (t, p) -> {
			try {
				return handled.applyChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(e);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled function with a
	 * provided handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <T, R, E extends Throwable> ObjIntFunction<T, R> handle(@Nonnull EObjIntFunction<T, R, E> handled,
																		  @Nonnull ObjObjIntFunction<Throwable, T, R> handler) {
		return (t, p) -> {
			try {
				return handled.applyChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.apply(e, t, p);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled function by
	 * throwing a different exception.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param <X>
	 *            The exception type to throw
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 *
	 * @throws X
	 *             The exception returned by the handler
	 */
	@Nonnull
	@SuppressWarnings({ "null", "unused" })
	public static <T, R, E extends Throwable, X extends Throwable> ObjIntFunction<T, R> handleThrowing(@Nonnull EObjIntFunction<T, R, E> handled,
																									   @Nonnull Function<Throwable, X> handler) throws X {
		return (t, p) -> {
			try {
				return handled.applyChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(handler.apply(e));
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled function by
	 * throwing it explicitly.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 *
	 * @return An exception-proofed function
	 *
	 * @throws E
	 *             The checked exception
	 */
	@Nonnull
	@SuppressWarnings("unused")
	public static <T, R, E extends Throwable> ObjIntFunction<T, R> handleThrowing(@Nonnull EObjIntFunction<T, R, E> handled) throws E {
		return (t, p) -> {
			try {
				return handled.applyChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(e);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled function with a
	 * provided handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <T, R, E extends Throwable> ObjLongFunction<T, R> handle(@Nonnull EObjLongFunction<T, R, E> handled,
																		   @Nonnull ObjObjLongFunction<Throwable, T, R> handler) {
		return (t, p) -> {
			try {
				return handled.applyChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.apply(e, t, p);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled function by
	 * throwing a different exception.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param <X>
	 *            The exception type to throw
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 *
	 * @throws X
	 *             The exception returned by the handler
	 */
	@Nonnull
	@SuppressWarnings({ "null", "unused" })
	public static <T, R, E extends Throwable, X extends Throwable> ObjLongFunction<T, R> handleThrowing(@Nonnull EObjLongFunction<T, R, E> handled,
																										@Nonnull Function<Throwable, X> handler) throws X {
		return (t, p) -> {
			try {
				return handled.applyChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(handler.apply(e));
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled function by
	 * throwing it explicitly.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 *
	 * @return An exception-proofed function
	 *
	 * @throws E
	 *             The checked exception
	 */
	@Nonnull
	@SuppressWarnings("unused")
	public static <T, R, E extends Throwable> ObjLongFunction<T, R> handleThrowing(@Nonnull EObjLongFunction<T, R, E> handled) throws E {
		return (t, p) -> {
			try {
				return handled.applyChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(e);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled function with a
	 * provided handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <T, R, E extends Throwable> ObjShortFunction<T, R> handle(@Nonnull EObjShortFunction<T, R, E> handled,
																			@Nonnull ObjObjShortFunction<Throwable, T, R> handler) {
		return (t, p) -> {
			try {
				return handled.applyChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.apply(e, t, p);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled function by
	 * throwing a different exception.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param <X>
	 *            The exception type to throw
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 *
	 * @throws X
	 *             The exception returned by the handler
	 */
	@Nonnull
	@SuppressWarnings({ "null", "unused" })
	public static <T, R, E extends Throwable, X extends Throwable> ObjShortFunction<T, R> handleThrowing(@Nonnull EObjShortFunction<T, R, E> handled,
																										 @Nonnull Function<Throwable, X> handler) throws X {
		return (t, p) -> {
			try {
				return handled.applyChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(handler.apply(e));
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled function by
	 * throwing it explicitly.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 *
	 * @return An exception-proofed function
	 *
	 * @throws E
	 *             The checked exception
	 */
	@Nonnull
	@SuppressWarnings("unused")
	public static <T, R, E extends Throwable> ObjShortFunction<T, R> handleThrowing(@Nonnull EObjShortFunction<T, R, E> handled) throws E {
		return (t, p) -> {
			try {
				return handled.applyChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(e);
			}
		};
	}

	/*
	 * ================== Predicates ==================
	 */

	/**
	 * Handles a generic exception type that may occur in the handled predicate with a
	 * provided handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed predicate
	 */
	@Nonnull
	public static <T, E extends Throwable> Predicate<T> handle(@Nonnull EPredicate<T, E> handled,
															   @Nonnull BiPredicate<Throwable, T> handler) {
		return t -> {
			try {
				return handled.testChecked(t);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.test(e, t);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled predicate by
	 * throwing a different exception.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param <X>
	 *            The exception type to throw
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed predicate
	 *
	 * @throws X
	 *             The exception returned by the handler
	 */
	@Nonnull
	@SuppressWarnings({ "null", "unused" })
	public static <T, E extends Throwable, X extends Throwable> Predicate<T> handleThrowing(@Nonnull EPredicate<T, E> handled,
																							@Nonnull Function<Throwable, X> handler) throws X {
		return t -> {
			try {
				return handled.testChecked(t);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(handler.apply(e));
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled predicate by
	 * throwing it explicitly.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 *
	 * @return An exception-proofed predicate
	 *
	 * @throws E
	 *             The checked exception
	 */
	@Nonnull
	@SuppressWarnings("unused")
	public static <T, E extends Throwable> Predicate<T> handleThrowing(@Nonnull EPredicate<T, E> handled) throws E {
		return t -> {
			try {
				return handled.testChecked(t);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(e);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled predicate with a
	 * provided handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed predicate
	 */
	@Nonnull
	public static <E extends Throwable> BooleanPredicate handle(@Nonnull EBooleanPredicate<E> handled,
																@Nonnull ObjBooleanPredicate<Throwable> handler) {
		return p -> {
			try {
				return handled.testChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.test(e, p);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled predicate by
	 * throwing a different exception.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param <X>
	 *            The exception type to throw
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed predicate
	 *
	 * @throws X
	 *             The exception returned by the handler
	 */
	@Nonnull
	@SuppressWarnings({ "null", "unused" })
	public static <E extends Throwable, X extends Throwable> BooleanPredicate handleThrowing(@Nonnull EBooleanPredicate<E> handled,
																							 @Nonnull Function<Throwable, X> handler) throws X {
		return p -> {
			try {
				return handled.testChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(handler.apply(e));
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled predicate by
	 * throwing it explicitly.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 *
	 * @return An exception-proofed predicate
	 *
	 * @throws E
	 *             The checked exception
	 */
	@Nonnull
	@SuppressWarnings("unused")
	public static <E extends Throwable> BooleanPredicate handleThrowing(@Nonnull EBooleanPredicate<E> handled) throws E {
		return p -> {
			try {
				return handled.testChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(e);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled predicate with a
	 * provided handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed predicate
	 */
	@Nonnull
	public static <E extends Throwable> BytePredicate handle(@Nonnull EBytePredicate<E> handled,
															 @Nonnull ObjBytePredicate<Throwable> handler) {
		return p -> {
			try {
				return handled.testChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.test(e, p);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled predicate by
	 * throwing a different exception.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param <X>
	 *            The exception type to throw
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed predicate
	 *
	 * @throws X
	 *             The exception returned by the handler
	 */
	@Nonnull
	@SuppressWarnings({ "null", "unused" })
	public static <E extends Throwable, X extends Throwable> BytePredicate handleThrowing(@Nonnull EBytePredicate<E> handled,
																						  @Nonnull Function<Throwable, X> handler) throws X {
		return p -> {
			try {
				return handled.testChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(handler.apply(e));
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled predicate by
	 * throwing it explicitly.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 *
	 * @return An exception-proofed predicate
	 *
	 * @throws E
	 *             The checked exception
	 */
	@Nonnull
	@SuppressWarnings("unused")
	public static <E extends Throwable> BytePredicate handleThrowing(@Nonnull EBytePredicate<E> handled) throws E {
		return p -> {
			try {
				return handled.testChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(e);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled predicate with a
	 * provided handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed predicate
	 */
	@Nonnull
	public static <E extends Throwable> IntPredicate handle(@Nonnull EIntPredicate<E> handled,
															@Nonnull ObjIntPredicate<Throwable> handler) {
		return p -> {
			try {
				return handled.testChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.test(e, p);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled predicate by
	 * throwing a different exception.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param <X>
	 *            The exception type to throw
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed predicate
	 *
	 * @throws X
	 *             The exception returned by the handler
	 */
	@Nonnull
	@SuppressWarnings({ "null", "unused" })
	public static <E extends Throwable, X extends Throwable> IntPredicate handleThrowing(@Nonnull EIntPredicate<E> handled,
																						 @Nonnull Function<Throwable, X> handler) throws X {
		return p -> {
			try {
				return handled.testChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(handler.apply(e));
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled predicate by
	 * throwing it explicitly.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 *
	 * @return An exception-proofed predicate
	 *
	 * @throws E
	 *             The checked exception
	 */
	@Nonnull
	@SuppressWarnings("unused")
	public static <E extends Throwable> IntPredicate handleThrowing(@Nonnull EIntPredicate<E> handled) throws E {
		return p -> {
			try {
				return handled.testChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(e);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled predicate with a
	 * provided handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed predicate
	 */
	@Nonnull
	public static <E extends Throwable> LongPredicate handle(@Nonnull ELongPredicate<E> handled,
															 @Nonnull ObjLongPredicate<Throwable> handler) {
		return p -> {
			try {
				return handled.testChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.test(e, p);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled predicate by
	 * throwing a different exception.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param <X>
	 *            The exception type to throw
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed predicate
	 *
	 * @throws X
	 *             The exception returned by the handler
	 */
	@Nonnull
	@SuppressWarnings({ "null", "unused" })
	public static <E extends Throwable, X extends Throwable> LongPredicate handleThrowing(@Nonnull ELongPredicate<E> handled,
																						  @Nonnull Function<Throwable, X> handler) throws X {
		return p -> {
			try {
				return handled.testChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(handler.apply(e));
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled predicate by
	 * throwing it explicitly.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 *
	 * @return An exception-proofed predicate
	 *
	 * @throws E
	 *             The checked exception
	 */
	@Nonnull
	@SuppressWarnings("unused")
	public static <E extends Throwable> LongPredicate handleThrowing(@Nonnull ELongPredicate<E> handled) throws E {
		return p -> {
			try {
				return handled.testChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(e);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled predicate with a
	 * provided handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed predicate
	 */
	@Nonnull
	public static <E extends Throwable> ShortPredicate handle(@Nonnull EShortPredicate<E> handled,
															  @Nonnull ObjShortPredicate<Throwable> handler) {
		return p -> {
			try {
				return handled.testChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.test(e, p);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled predicate by
	 * throwing a different exception.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param <X>
	 *            The exception type to throw
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed predicate
	 *
	 * @throws X
	 *             The exception returned by the handler
	 */
	@Nonnull
	@SuppressWarnings({ "null", "unused" })
	public static <E extends Throwable, X extends Throwable> ShortPredicate handleThrowing(@Nonnull EShortPredicate<E> handled,
																						   @Nonnull Function<Throwable, X> handler) throws X {
		return p -> {
			try {
				return handled.testChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(handler.apply(e));
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled predicate by
	 * throwing it explicitly.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 *
	 * @return An exception-proofed predicate
	 *
	 * @throws E
	 *             The checked exception
	 */
	@Nonnull
	@SuppressWarnings("unused")
	public static <E extends Throwable> ShortPredicate handleThrowing(@Nonnull EShortPredicate<E> handled) throws E {
		return p -> {
			try {
				return handled.testChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(e);
			}
		};
	}

	/*
	 * ================== BiPredicates ==================
	 */

	/**
	 * Handles a generic exception type that may occur in the handled predicate with a
	 * provided handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed predicate
	 */
	@Nonnull
	public static <T, U, E extends Throwable> BiPredicate<T, U> handle(@Nonnull EBiPredicate<T, U, E> handled,
																	   @Nonnull TriPredicate<Throwable, T, U> handler) {
		return (t, u) -> {
			try {
				return handled.testChecked(t, u);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.test(e, t, u);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled predicate by
	 * throwing a different exception.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param <X>
	 *            The exception type to throw
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed predicate
	 *
	 * @throws X
	 *             The exception returned by the handler
	 */
	@Nonnull
	@SuppressWarnings({ "null", "unused" })
	public static <T, U, E extends Throwable, X extends Throwable> BiPredicate<T, U> handleThrowing(@Nonnull EBiPredicate<T, U, E> handled,
																									@Nonnull Function<Throwable, X> handler) throws X {
		return (t, u) -> {
			try {
				return handled.testChecked(t, u);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(handler.apply(e));
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled predicate by
	 * throwing it explicitly.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 *
	 * @return An exception-proofed predicate
	 *
	 * @throws E
	 *             The checked exception
	 */
	@Nonnull
	@SuppressWarnings("unused")
	public static <T, U, E extends Throwable> BiPredicate<T, U> handleThrowing(@Nonnull EBiPredicate<T, U, E> handled) throws E {
		return (t, u) -> {
			try {
				return handled.testChecked(t, u);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(e);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled predicate with a
	 * provided handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed predicate
	 */
	@Nonnull
	public static <T, E extends Throwable> ObjBooleanPredicate<T> handle(@Nonnull EObjBooleanPredicate<T, E> handled,
																		 @Nonnull ObjObjBooleanPredicate<Throwable, T> handler) {
		return (t, p) -> {
			try {
				return handled.testChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.test(e, t, p);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled predicate by
	 * throwing a different exception.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param <X>
	 *            The exception type to throw
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed predicate
	 *
	 * @throws X
	 *             The exception returned by the handler
	 */
	@Nonnull
	@SuppressWarnings({ "null", "unused" })
	public static <T, E extends Throwable, X extends Throwable> ObjBooleanPredicate<T> handleThrowing(@Nonnull EObjBooleanPredicate<T, E> handled,
																									  @Nonnull Function<Throwable, X> handler) throws X {
		return (t, p) -> {
			try {
				return handled.testChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(handler.apply(e));
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled predicate by
	 * throwing it explicitly.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 *
	 * @return An exception-proofed predicate
	 *
	 * @throws E
	 *             The checked exception
	 */
	@Nonnull
	@SuppressWarnings("unused")
	public static <T, E extends Throwable> ObjBooleanPredicate<T> handleThrowing(@Nonnull EObjBooleanPredicate<T, E> handled) throws E {
		return (t, p) -> {
			try {
				return handled.testChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(e);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled predicate with a
	 * provided handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed predicate
	 */
	@Nonnull
	public static <T, E extends Throwable> ObjBytePredicate<T> handle(@Nonnull EObjBytePredicate<T, E> handled,
																	  @Nonnull ObjObjBytePredicate<Throwable, T> handler) {
		return (t, p) -> {
			try {
				return handled.testChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.test(e, t, p);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled predicate by
	 * throwing a different exception.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param <X>
	 *            The exception type to throw
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed predicate
	 *
	 * @throws X
	 *             The exception returned by the handler
	 */
	@Nonnull
	@SuppressWarnings({ "null", "unused" })
	public static <T, E extends Throwable, X extends Throwable> ObjBytePredicate<T> handleThrowing(@Nonnull EObjBytePredicate<T, E> handled,
																								   @Nonnull Function<Throwable, X> handler) throws X {
		return (t, p) -> {
			try {
				return handled.testChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(handler.apply(e));
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled predicate by
	 * throwing it explicitly.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 *
	 * @return An exception-proofed predicate
	 *
	 * @throws E
	 *             The checked exception
	 */
	@Nonnull
	@SuppressWarnings("unused")
	public static <T, E extends Throwable> ObjBytePredicate<T> handleThrowing(@Nonnull EObjBytePredicate<T, E> handled) throws E {
		return (t, p) -> {
			try {
				return handled.testChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(e);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled predicate with a
	 * provided handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed predicate
	 */
	@Nonnull
	public static <T, E extends Throwable> ObjIntPredicate<T> handle(@Nonnull EObjIntPredicate<T, E> handled,
																	 @Nonnull ObjObjIntPredicate<Throwable, T> handler) {
		return (t, p) -> {
			try {
				return handled.testChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.test(e, t, p);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled predicate by
	 * throwing a different exception.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param <X>
	 *            The exception type to throw
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed predicate
	 *
	 * @throws X
	 *             The exception returned by the handler
	 */
	@Nonnull
	@SuppressWarnings({ "null", "unused" })
	public static <T, E extends Throwable, X extends Throwable> ObjIntPredicate<T> handleThrowing(@Nonnull EObjIntPredicate<T, E> handled,
																								  @Nonnull Function<Throwable, X> handler) throws X {
		return (t, p) -> {
			try {
				return handled.testChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(handler.apply(e));
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled predicate by
	 * throwing it explicitly.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 *
	 * @return An exception-proofed predicate
	 *
	 * @throws E
	 *             The checked exception
	 */
	@Nonnull
	@SuppressWarnings("unused")
	public static <T, E extends Throwable> ObjIntPredicate<T> handleThrowing(@Nonnull EObjIntPredicate<T, E> handled) throws E {
		return (t, p) -> {
			try {
				return handled.testChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(e);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled predicate with a
	 * provided handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed predicate
	 */
	@Nonnull
	public static <T, E extends Throwable> ObjLongPredicate<T> handle(@Nonnull EObjLongPredicate<T, E> handled,
																	  @Nonnull ObjObjLongPredicate<Throwable, T> handler) {
		return (t, p) -> {
			try {
				return handled.testChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.test(e, t, p);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled predicate by
	 * throwing a different exception.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param <X>
	 *            The exception type to throw
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed predicate
	 *
	 * @throws X
	 *             The exception returned by the handler
	 */
	@Nonnull
	@SuppressWarnings({ "null", "unused" })
	public static <T, E extends Throwable, X extends Throwable> ObjLongPredicate<T> handleThrowing(@Nonnull EObjLongPredicate<T, E> handled,
																								   @Nonnull Function<Throwable, X> handler) throws X {
		return (t, p) -> {
			try {
				return handled.testChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(handler.apply(e));
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled predicate by
	 * throwing it explicitly.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 *
	 * @return An exception-proofed predicate
	 *
	 * @throws E
	 *             The checked exception
	 */
	@Nonnull
	@SuppressWarnings("unused")
	public static <T, E extends Throwable> ObjLongPredicate<T> handleThrowing(@Nonnull EObjLongPredicate<T, E> handled) throws E {
		return (t, p) -> {
			try {
				return handled.testChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(e);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled predicate with a
	 * provided handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed predicate
	 */
	@Nonnull
	public static <T, E extends Throwable> ObjShortPredicate<T> handle(@Nonnull EObjShortPredicate<T, E> handled,
																	   @Nonnull ObjObjShortPredicate<Throwable, T> handler) {
		return (t, p) -> {
			try {
				return handled.testChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.test(e, t, p);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled predicate by
	 * throwing a different exception.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param <X>
	 *            The exception type to throw
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed predicate
	 *
	 * @throws X
	 *             The exception returned by the handler
	 */
	@Nonnull
	@SuppressWarnings({ "null", "unused" })
	public static <T, E extends Throwable, X extends Throwable> ObjShortPredicate<T> handleThrowing(@Nonnull EObjShortPredicate<T, E> handled,
																									@Nonnull Function<Throwable, X> handler) throws X {
		return (t, p) -> {
			try {
				return handled.testChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(handler.apply(e));
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled predicate by
	 * throwing it explicitly.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 *
	 * @return An exception-proofed predicate
	 *
	 * @throws E
	 *             The checked exception
	 */
	@Nonnull
	@SuppressWarnings("unused")
	public static <T, E extends Throwable> ObjShortPredicate<T> handleThrowing(@Nonnull EObjShortPredicate<T, E> handled) throws E {
		return (t, p) -> {
			try {
				return handled.testChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(e);
			}
		};
	}

	/*
	 * ================== Runnables ==================
	 */

	/**
	 * Handles a generic exception type that may occur in the handled runnable with a
	 * provided handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed runnable
	 */
	@Nonnull
	public static <E extends Throwable> Runnable handle(@Nonnull ERunnable<E> handled,
														@Nonnull Consumer<Throwable> handler) {
		return () -> {
			try {
				handled.runChecked();
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				handler.accept(e);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled runnable by
	 * throwing a different exception.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param <X>
	 *            The exception type to throw
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed runnable
	 *
	 * @throws X
	 *             The exception returned by the handler
	 */
	@Nonnull
	@SuppressWarnings({ "null", "unused" })
	public static <E extends Throwable, X extends Throwable> Runnable handleThrowing(@Nonnull ERunnable<E> handled,
																					 @Nonnull Function<Throwable, X> handler) throws X {
		return () -> {
			try {
				handled.runChecked();
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(handler.apply(e));
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled runnable by
	 * throwing it explicitly.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 *
	 * @return An exception-proofed runnable
	 *
	 * @throws E
	 *             The checked exception
	 */
	@Nonnull
	@SuppressWarnings("unused")
	public static <E extends Throwable> Runnable handleThrowing(@Nonnull ERunnable<E> handled) throws E {
		return () -> {
			try {
				handled.runChecked();
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(e);
			}
		};
	}

	/*
	 * ================== Suppliers & Callable ==================
	 */

	/**
	 * Handles any exception type that may occur in the handled callable with a provided
	 * handler.
	 *
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed callable
	 */
	@Nonnull
	public static <T> Supplier<T> handle(@Nonnull Callable<T> handled, @Nonnull Function<Exception, T> handler) {
		return () -> {
			try {
				return handled.call();
			} catch (Exception e) {
				return handler.apply(e);
			}
		};
	}

	/**
	 * Handles any exception type that may occur in the handled callable by throwing a
	 * different exception.
	 *
	 * @param <X>
	 *            The exception type to throw
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed callable
	 *
	 * @throws X
	 *             The exception returned by the handler
	 */
	@Nonnull
	@SuppressWarnings({ "null", "unused" })
	public static <T, X extends Throwable> Supplier<T> handleThrowing(@Nonnull Callable<T> handled,
																	  @Nonnull Function<Throwable, X> handler) throws X {
		return () -> {
			try {
				return handled.call();
			} catch (Exception e) {
				throw asUnchecked(handler.apply(e));
			}
		};
	}

	/**
	 * Handles any exception type that may occur in the handled callable by throwing it
	 * explicitly.
	 *
	 * @param handled
	 *            The function that may throw an exception
	 *
	 * @return An exception-proofed callable
	 *
	 * @throws Exception
	 *             The checked exception
	 */
	@Nonnull
	public static <T> Supplier<T> handleThrowing(@Nonnull Callable<T> handled) throws Exception { // NOSONAR
		return () -> {
			try {
				return handled.call();
			} catch (Exception e) {
				throw asUnchecked(e);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled function with a
	 * provided handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <E extends Throwable> BooleanSupplier handle(@Nonnull EBooleanSupplier<E> handled,
															   @Nonnull Predicate<Throwable> handler) {
		return () -> {
			try {
				return handled.getAsBoolean();
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.test(e);
			}
		};
	}

	/**
	 * Handles any exception types that may occur in the handled supplier by throwing a
	 * different exception.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param <X>
	 *            The exception type to throw
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed supplier
	 *
	 * @throws X
	 *             The exception returned by the handler
	 */
	@Nonnull
	@SuppressWarnings({ "null", "unused" })
	public static <T, E extends Throwable, X extends Throwable> BooleanSupplier handleThrowing(@Nonnull EBooleanSupplier<E> handled,
																							   @Nonnull Function<Throwable, X> handler) throws X {
		return () -> {
			try {
				return handled.getAsBoolean();
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(handler.apply(e));
			}
		};
	}

	/**
	 * Handles any exception types that may occur in the handled supplier by throwing it
	 * explicitly.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 *
	 * @return An exception-proofed supplier
	 *
	 * @throws E
	 *             The checked exception
	 */
	@Nonnull
	@SuppressWarnings("unused")
	public static <T, E extends Throwable> BooleanSupplier handleThrowing(@Nonnull EBooleanSupplier<E> handled) throws E {
		return () -> {
			try {
				return handled.getAsBoolean();
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(e);
			}
		};
	}

	// missing: handle EByteSupplier, blocked by: missing ToByteFunction

	/**
	 * Handles any exception types that may occur in the handled supplier by throwing a
	 * different exception.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param <X>
	 *            The exception type to throw
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed supplier
	 *
	 * @throws X
	 *             The exception returned by the handler
	 */
	@Nonnull
	@SuppressWarnings({ "null", "unused" })
	public static <T, E extends Throwable, X extends Throwable> ByteSupplier handleThrowing(@Nonnull EByteSupplier<E> handled,
																							@Nonnull Function<Throwable, X> handler) throws X {
		return () -> {
			try {
				return handled.getAsByte();
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(handler.apply(e));
			}
		};
	}

	/**
	 * Handles any exception types that may occur in the handled supplier by throwing it
	 * explicitly.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 *
	 * @return An exception-proofed supplier
	 *
	 * @throws E
	 *             The checked exception
	 */
	@Nonnull
	@SuppressWarnings("unused")
	public static <T, E extends Throwable> ByteSupplier handleThrowing(@Nonnull EByteSupplier<E> handled) throws E {
		return () -> {
			try {
				return handled.getAsByte();
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(e);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled function with a
	 * provided handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <E extends Throwable> IntSupplier handle(@Nonnull EIntSupplier<E> handled,
														   @Nonnull ToIntFunction<Throwable> handler) {
		return () -> {
			try {
				return handled.getAsInt();
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.applyAsInt(e);
			}
		};
	}

	/**
	 * Handles any exception types that may occur in the handled supplier by throwing a
	 * different exception.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param <X>
	 *            The exception type to throw
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed supplier
	 *
	 * @throws X
	 *             The exception returned by the handler
	 */
	@Nonnull
	@SuppressWarnings({ "null", "unused" })
	public static <T, E extends Throwable, X extends Throwable> IntSupplier handleThrowing(@Nonnull EIntSupplier<E> handled,
																						   @Nonnull Function<Throwable, X> handler) throws X {
		return () -> {
			try {
				return handled.getAsInt();
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(handler.apply(e));
			}
		};
	}

	/**
	 * Handles any exception types that may occur in the handled supplier by throwing it
	 * explicitly.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 *
	 * @return An exception-proofed supplier
	 *
	 * @throws E
	 *             The checked exception
	 */
	@Nonnull
	@SuppressWarnings("unused")
	public static <T, E extends Throwable> IntSupplier handleThrowing(@Nonnull EIntSupplier<E> handled) throws E {
		return () -> {
			try {
				return handled.getAsInt();
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(e);
			}
		};
	}

	// missing: handle EShortSupplier, blocked by: missing ToShortFunction

	/**
	 * Handles any exception types that may occur in the handled supplier by throwing a
	 * different exception.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param <X>
	 *            The exception type to throw
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed supplier
	 *
	 * @throws X
	 *             The exception returned by the handler
	 */
	@Nonnull
	@SuppressWarnings({ "null", "unused" })
	public static <T, E extends Throwable, X extends Throwable> ShortSupplier handleThrowing(@Nonnull EShortSupplier<E> handled,
																							 @Nonnull Function<Throwable, X> handler) throws X {
		return () -> {
			try {
				return handled.getAsShort();
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(handler.apply(e));
			}
		};
	}

	/**
	 * Handles any exception types that may occur in the handled supplier by throwing it
	 * explicitly.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 *
	 * @return An exception-proofed supplier
	 *
	 * @throws E
	 *             The checked exception
	 */
	@Nonnull
	@SuppressWarnings("unused")
	public static <T, E extends Throwable> ShortSupplier handleThrowing(@Nonnull EShortSupplier<E> handled) throws E {
		return () -> {
			try {
				return handled.getAsShort();
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(e);
			}
		};
	}

	/**
	 * Handles a generic exception type that may occur in the handled function with a
	 * provided handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <E extends Throwable> LongSupplier handle(@Nonnull ELongSupplier<E> handled,
															@Nonnull ToLongFunction<Throwable> handler) {
		return () -> {
			try {
				return handled.getAsLong();
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.applyAsLong(e);
			}
		};
	}

	/**
	 * Handles any exception types that may occur in the handled supplier by throwing a
	 * different exception.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param <X>
	 *            The exception type to throw
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed supplier
	 *
	 * @throws X
	 *             The exception returned by the handler
	 */
	@Nonnull
	@SuppressWarnings({ "null", "unused" })
	public static <T, E extends Throwable, X extends Throwable> LongSupplier handleThrowing(@Nonnull ELongSupplier<E> handled,
																							@Nonnull Function<Throwable, X> handler) throws X {
		return () -> {
			try {
				return handled.getAsLong();
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(handler.apply(e));
			}
		};
	}

	/**
	 * Handles any exception types that may occur in the handled supplier by throwing it
	 * explicitly.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 *
	 * @return An exception-proofed supplier
	 *
	 * @throws E
	 *             The checked exception
	 */
	@Nonnull
	@SuppressWarnings("unused")
	public static <T, E extends Throwable> LongSupplier handleThrowing(@Nonnull ELongSupplier<E> handled) throws E {
		return () -> {
			try {
				return handled.getAsLong();
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				throw asUnchecked(e);
			}
		};
	}

	private EHandle() {}

}
