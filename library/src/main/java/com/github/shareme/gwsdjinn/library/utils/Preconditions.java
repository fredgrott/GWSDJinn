package com.github.shareme.gwsdjinn.library.utils;

/**
 * Preconditions
 * Created by fgrott on 11/18/2015.
 */
@SuppressWarnings("unused")
public final class Preconditions {
    private Preconditions() {
        throw new AssertionError("No instances");
    }

    public static <T> T checkNotNull(T value, String message) {
        if (value == null) {
            throw new NullPointerException(message);
        }
        return value;
    }

    public static void checkArgument(boolean check, String message) {
        if (!check) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void checkState(boolean check, String message) {
        if (!check) {
            throw new IllegalStateException(message);
        }
    }
}
