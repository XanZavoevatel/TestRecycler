package ru.lncloud.testrecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.view.animation.OvershootInterpolator
import jp.wasabeef.recyclerview.animators.*
import ru.lncloud.testrecycler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    private val listContents: MutableList<DataContent> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        initListContents()

        val anim = AnimationUtils.loadLayoutAnimation(this, R.anim.layout_animation)
        val adapter = MyAdapter(this)
        adapter.setContents(listContents)

        val recycler = activityMainBinding.recyclerview
        recycler.adapter = adapter
        recycler.layoutAnimation = anim
        recycler.scheduleLayoutAnimation()

        val myItemAnimator = MyItemAnimator(this)
        recycler.itemAnimator = myItemAnimator
//
//            SlideInRightAnimator(OvershootInterpolator(0.5f))
//            .apply {
//            removeDuration = 500
//            addDuration = 500
//        }

        // здесь для анимации добавления элемента используется доб библиотека
        activityMainBinding.add.setOnClickListener {
            adapter.addContent(DataContent("РХПГ"))
            adapter.notifyItemInserted(adapter.itemCount-1)
        }

        // здесь для анимации удаления элемента используется доб библиотека
        activityMainBinding.remove.setOnClickListener {
            adapter.removeLast()
            adapter.notifyItemRemoved(adapter.itemCount)
        }
    }

    private fun initListContents() {
        listContents.add(DataContent("КТ"))
        listContents.add(DataContent("МРТ"))
        listContents.add(DataContent("РГ"))
        listContents.add(DataContent("МГ"))

    }
}