package com.np.espressotestapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(val context: Context, var itemList: List<ListModel>) :
    RecyclerView.Adapter<ListAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val v = LayoutInflater.from(parent.context).
            inflate(R.layout.list_single_item_layout, parent, false)
        return ListViewHolder(v)
    }

    override fun getItemCount(): Int {
       return  itemList.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.listName?.text = itemList[position].userName
        holder.listDesc?.text = itemList[position].userDescription
    }

    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var listName : TextView? = itemView.findViewById(R.id.tv_list_name)
        var listDesc : TextView? = itemView.findViewById(R.id.tv_list_description)
    }
}