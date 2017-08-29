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
 * limitations under the License.
 */
package android.car.ui.provider;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Clone of {@link android.support.car.ui.PagedScrollBarView} to be used by CarUiProvider.
 * Workaround for b/25595320
 */
public class PagedScrollBarView extends android.support.car.ui.PagedScrollBarView {
    public PagedScrollBarView(
            Context context, AttributeSet attrs) {
        this(context, attrs, 0 /*defStyleAttrs*/, 0 /*defStyleRes*/);
    }

    public PagedScrollBarView(
            Context context, AttributeSet attrs, int defStyleAttrs) {
        this(context, attrs, defStyleAttrs, 0 /*defStyleRes*/);
    }

    public PagedScrollBarView(
            Context context, AttributeSet attrs, int defStyleAttrs, int defStyleRes) {
        super(context, attrs, defStyleAttrs, defStyleRes);
    }
}
