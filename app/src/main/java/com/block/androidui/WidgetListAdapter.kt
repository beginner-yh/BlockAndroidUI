package com.block.androidui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WidgetListAdapter(private val data: List<ViewIntro>) : RecyclerView.Adapter<WidgetListViewHolder>() {

    private var onItemClick: OnItemClick? = null

    fun setOnItemClick(onItemClick: OnItemClick) {
        this.onItemClick = onItemClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WidgetListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_widget, parent, false)
        return WidgetListViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: WidgetListViewHolder, position: Int) {
        val itemData = data[position]
        holder.tvTitle.text = itemData.title
        holder.tvIntro.text = itemData.intro
        holder.ivIcon.setImageResource(itemData.icon)
        holder.itemView.setOnClickListener {
            onItemClick?.onItemClick(position)
        }
    }
}

interface OnItemClick {
    fun onItemClick(position: Int)
}


class WidgetListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
    val tvIntro: TextView = itemView.findViewById(R.id.tv_intro)
    val ivIcon: ImageView = itemView.findViewById(R.id.iv_icon)
}