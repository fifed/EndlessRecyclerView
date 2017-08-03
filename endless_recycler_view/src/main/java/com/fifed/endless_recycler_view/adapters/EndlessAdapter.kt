package com.fifed.endless_recycler_view.adapters

import android.support.v7.widget.RecyclerView

/**
 * Created by Fedir on 03.08.2017.
 */
 abstract class  EndlessAdapter<T : RecyclerView.ViewHolder?> : RecyclerView.Adapter<T>() {
    abstract fun getCollectionSize(): Int
    abstract fun onBindHolderViews(h: T, pos: Int)
    override fun getItemCount() = if (getCollectionSize() == 0) 0 else getCollectionSize() * (Integer.MAX_VALUE / getCollectionSize())
    override fun onBindViewHolder(h: T, pos: Int) {
        onBindHolderViews(h, pos % getCollectionSize())
    }
    fun getPosToEndlessScrolling() = if (getCollectionSize() == 0) 0 else getCollectionSize() * (Integer.MAX_VALUE / getCollectionSize() / 2)
}