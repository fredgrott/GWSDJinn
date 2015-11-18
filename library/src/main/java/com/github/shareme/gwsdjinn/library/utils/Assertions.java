package com.github.shareme.gwsdjinn.library.utils;

import android.os.Looper;

/**
 * Assertions
 * Created by fgrott on 11/18/2015.
 */
@SuppressWarnings("unused")
public final class Assertions {
    private Assertions() {
        throw new AssertionError("No instances");
    }

    public static void assertUiThread() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("Observers must subscribe from the main UI thread, but was " + Thread.currentThread());
        }
    }
}
