package ru.lncloud.testrecycler

import android.content.Context
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView

class MyItemAnimator(private  val context: Context) : DefaultItemAnimator() {
    val animAdd = AnimationUtils.loadAnimation(context, R.anim.add_anim)
    val animRemove = AnimationUtils.loadAnimation(context, R.anim.remove_anim)


    override fun onAddStarting(item: RecyclerView.ViewHolder?) {
        item?.itemView?.startAnimation(animAdd)
    }

    override fun getAddDuration(): Long = animAdd.duration

    override fun onRemoveStarting(item: RecyclerView.ViewHolder?) {
        item?.itemView?.startAnimation(animRemove)
    }

    override fun getRemoveDuration(): Long = animRemove.duration
}