package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.customviews;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class TriStateRecyclerView extends RecyclerView {

    private View emptyView;
    private View loadingView;
    private AdapterDataObserver dataObserver = new AdapterDataObserver() {
        @Override
        public void onChanged() {
            super.onChanged();
            Adapter adapter = getAdapter();
            Log.i("RecycleError", this + "getAdapter() + adapter state" + adapter);
            boolean hasData = adapter.getItemCount() > 0;
            setVisibility(hasData ? VISIBLE : GONE);
            emptyView.setVisibility(hasData ? GONE : VISIBLE);
        }
    };

    public TriStateRecyclerView(Context context) {
        super(context);
    }

    public TriStateRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TriStateRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void setAdapter(Adapter adapter) {
        Log.i("RecycleError", this + "setAdapterBeforeSuper + adapter state" + adapter);
        super.setAdapter(adapter);
        loadingView.setVisibility(adapter == null ? VISIBLE : GONE);
        Log.i("RecycleError", this + "setAdapterAfterSuper + adapter state" + adapter);
        if (adapter != null) {
            adapter.registerAdapterDataObserver(dataObserver);
            dataObserver.onChanged();
        }
    }

    public void setEmptyView(View emptyView) {
        this.emptyView = emptyView;
    }

    public void setLoadingView(View loadingView) {
        this.loadingView = loadingView;
    }
}
