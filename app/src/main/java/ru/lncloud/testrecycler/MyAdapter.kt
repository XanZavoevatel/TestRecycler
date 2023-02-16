package ru.lncloud.testrecycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MyAdapter(context: Context): RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private val listContents: MutableList<DataContent> = mutableListOf()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(content: DataContent) {
            val textContent: TextView = itemView.findViewById(R.id.textView)
            textContent.text = content.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.content, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(listContents[position])
    }

    override fun getItemCount(): Int = listContents.size

    fun setContents(listContents: MutableList<DataContent>) {
        this.listContents.clear()
        this.listContents.addAll(listContents)
    }

    fun addContent(content: DataContent) {
        listContents.add(content)
    }

    fun removeLast() {
        if (listContents.size > 0) {
            listContents.removeLast()
        }
    }
}