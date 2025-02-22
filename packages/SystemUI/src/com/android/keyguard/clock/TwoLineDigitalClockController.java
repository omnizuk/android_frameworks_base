/*
 * Copyright (C) 2019 The Android Open Source Project
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
package com.android.keyguard.clock;

import android.app.WallpaperManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextClock;

import com.android.internal.colorextraction.ColorExtractor;
import com.android.systemui.R;
import com.android.systemui.colorextraction.SysuiColorExtractor;
import com.android.systemui.plugins.ClockPlugin;

public class TwoLineDigitalClockController extends DigitalClockController {
    public TwoLineDigitalClockController(Resources res, LayoutInflater inflater,
            SysuiColorExtractor colorExtractor) {
        super(res, inflater, colorExtractor, true, true);
    }

    @Override
    public String getName() {
        return "vertical";
    }

    @Override
    public String getTitle() {
        return mResources.getString(R.string.clock_title_two_line_digital);
    }

    @Override
    public Bitmap getThumbnail() {
        return BitmapFactory.decodeResource(mResources, R.drawable.two_line_digital_thumbnail);
    }

    @Override
    public Bitmap getPreview(int width, int height) {
        // TODO FAKE!!!!
        ViewPreviewer renderer = new ViewPreviewer();
        View previewClock = mLayoutInflater.inflate(R.layout.two_line_digital_preview, null);
        TextClock textDate = previewClock.findViewById(R.id.date);
        textDate.setTextColor(Color.WHITE);
        return renderer.createPreview(previewClock, width, height);
    }
}
