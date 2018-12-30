package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.customviews

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.View

class TriStateRecyclerView : RecyclerView {

    private lateinit var emptyView: View
    private lateinit var loadingView: View
    private val dataObserver = object : RecyclerView.AdapterDataObserver() {
        override fun onChanged() {
            super.onChanged()
            val adapter = adapter
            val hasData = adapter!!.itemCount > 0
            visibility = if (hasData) View.VISIBLE else View.GONE
            emptyView.visibility = if (hasData) View.GONE else View.VISIBLE
        }
    }

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    )

    override fun setAdapter(adapter: RecyclerView.Adapter<*>?) {
        super.setAdapter(adapter)
        loadingView.visibility = if (adapter == null) View.VISIBLE else View.GONE
        if (adapter != null) {
            adapter.registerAdapterDataObserver(dataObserver)
            dataObserver.onChanged()
        }
    }

    fun setEmptyView(emptyView: View) {
        this.emptyView = emptyView
    }

    fun setLoadingView(loadingView: View) {
        this.loadingView = loadingView
    }
}
