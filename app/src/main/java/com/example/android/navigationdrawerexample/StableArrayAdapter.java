/*
 * Copyright (C) 2013 The Android Open Source Project
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

package com.example.android.navigationdrawerexample;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.HashMap;
import java.util.List;

public class StableArrayAdapter extends ArrayAdapter<String> {

    final int INVALID_ID = -1;

    int mRowLayout;
    List<String[]> mStrings;
    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

    // constructor
    public StableArrayAdapter(Context context, int rowLayout, List<String> objects) {
        super(context, rowLayout, objects);
        for (int i = 0; i < objects.size(); ++i) {
            mIdMap.put(objects.get(i), i);
        }
    }

    @Override
    public long getItemId(int position) {
        if (position < 0 || position >= mIdMap.size()) {
            return INVALID_ID;
        }
        String item = getItem(position);
        return mIdMap.get(item);
    }

    @Override
    public boolean hasStableIds() {
//        return true;
        return android.os.Build.VERSION.SDK_INT < 20;
    }
}
