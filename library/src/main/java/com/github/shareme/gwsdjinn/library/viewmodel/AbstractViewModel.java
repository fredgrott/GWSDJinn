package com.github.shareme.gwsdjinn.library.viewmodel;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import rx.subscriptions.CompositeSubscription;
import timber.log.Timber;

/**
 * AbstractViewModel
 * Created by fgrott on 11/18/2015.
 */
@SuppressWarnings("unused")
public abstract class AbstractViewModel<T extends IView> {

    private CompositeSubscription compositeSubscription;


    @Nullable
    private T mView;

    final public void subscribeToDataStore() {
        Timber.v("AbstractViewModel", "subscribeToDataStore");
        unsubscribeFromDataStore();
        compositeSubscription = new CompositeSubscription();
        subscribeToDataStoreInternal(compositeSubscription);
    }
    public void dispose() {
        Timber.v("AbstractViewModel", "dispose");

        if (compositeSubscription != null) {
            Timber.e("AbstractViewModel", "Disposing without calling unsubscribeFromDataStore first");

            // Unsubscribe in case we are still for some reason subscribed
            unsubscribeFromDataStore();
        }
    }

    public abstract void subscribeToDataStoreInternal(@NonNull CompositeSubscription compositeSubscription);

    public void unsubscribeFromDataStore() {
        Timber.v("AbstractViewModel", "unsubscribeToDataStore");
        if (compositeSubscription != null) {
            compositeSubscription.clear();
            compositeSubscription = null;
        }
    }




    public void initWithView(@NonNull T view) {
        mView = view;
    }

    public T getView() {
        return mView;
    }

    public void clearView() {
        mView = null;
    }

    public void saveState(Bundle bundle) {

    }

    /**
     * Will be called only in case the system is killed due to low memory and restored
     * @param bundle the bundle
     */
    public void restoreState(Bundle bundle) {

    }

    public void onStop() {

    }

    public void onStart() {

    }

    /**
     * Called when there parent fragment or view is already gone and destroyed.
     * This is a good place to empty any planned tasks that are useless without a UI.
     */
    public void onModelRemoved() {

    }
}
