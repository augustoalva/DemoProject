package com.example.listoftasks.view;

import android.content.Context;

/**
 * Interface representing a View that will use to load data.
 */
public interface ViewLoadData {
    /**
     * @param poMessage A string representing an message loading
     *                  Show a view with a progress bar indicating a loading process.
     */
    void onLoading(String poMessage);

    /**
     * Show an error message
     *
     * @param poMessage A string representing an error.
     */
    void onError(String poMessage);

    /**
     * Get a {@link Context}.
     */
    Context getContext();
}
