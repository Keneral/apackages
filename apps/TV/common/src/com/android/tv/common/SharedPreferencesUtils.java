/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.android.tv.common;

import android.content.Context;
import android.os.AsyncTask;
import android.preference.PreferenceManager;

/**
 * Static utilities for {@link android.content.SharedPreferences}
 */
public final class SharedPreferencesUtils {
    // Note that changing the preference name will reset the preference values.
    public static final String SHARED_PREF_FEATURES = "sharePreferencesFeatures";
    public static final String SHARED_PREF_BROWSABLE = "browsable_shared_preference";
    public static final String SHARED_PREF_WATCHED_HISTORY = "watched_history_shared_preference";
    public static final String SHARED_PREF_AUDIO_CAPABILITIES =
            "com.android.tv.audio_capabilities";
    public static final String SHARED_PREF_RECURRING_RUNNER = "sharedPreferencesRecurringRunner";

    private static boolean sInitializeCalled;

    /**
     * {@link android.content.SharedPreferences} loads the preference file when
     * {@link Context#getSharedPreferences(String, int)} is called for the first time.
     * Call {@link Context#getSharedPreferences(String, int)} as early as possible to avoid the ANR
     * due to the file loading.
     */
    public static synchronized void initialize(final Context context) {
        if (!sInitializeCalled) {
            sInitializeCalled = true;
            new AsyncTask<Void, Void, Void>() {
                @Override
                protected Void doInBackground(Void... params) {
                    PreferenceManager.getDefaultSharedPreferences(context);
                    context.getSharedPreferences(SHARED_PREF_FEATURES, Context.MODE_PRIVATE);
                    context.getSharedPreferences(SHARED_PREF_BROWSABLE, Context.MODE_PRIVATE);
                    context.getSharedPreferences(SHARED_PREF_WATCHED_HISTORY, Context.MODE_PRIVATE);
                    context.getSharedPreferences(SHARED_PREF_AUDIO_CAPABILITIES,
                            Context.MODE_PRIVATE);
                    context.getSharedPreferences(SHARED_PREF_RECURRING_RUNNER,
                            Context.MODE_PRIVATE);
                    return null;
                }
            }.execute();
        }
    }

    private SharedPreferencesUtils() { }
}
