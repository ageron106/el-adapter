/**
 * Copyright (C) 2016 Dmitry Mozgin
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.m039.el_adapter;

import android.view.View;

import com.m039.el_adapter.BaseViewAdapter.ViewHolder;
import com.m039.el_adapter.BaseViewAdapter.ViewHolderBinder;

/**
 * Created by m039 on 6/1/16.
 */
public class ViewCreatorChainer {

    final protected BaseViewAdapter adapter;
    final protected int viewType;

    public ViewCreatorChainer(BaseViewAdapter adapter, int viewType) {
        this.adapter = adapter;
        this.viewType = viewType;
    }

    public <V extends View, VH extends ViewHolder<V>> ViewHolderBinderChainer<V> addViewHolderBinder(ViewHolderBinder<VH> binder) {
        adapter.addViewHolderBinder(viewType, binder); //todo unsafe
        return new ViewHolderBinderChainer<>(adapter, binder, viewType);
    }

}
