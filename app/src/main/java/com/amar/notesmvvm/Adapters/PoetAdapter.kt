package com.amar.notesmvvm.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.amar.notesmvvm.R
import com.amar.notesmvvm.Models.DataEntity

class PoetAdapter (private var context: Context, var poetList: ArrayList<DataEntity>, val listener: NotesItemClickListener)
    : RecyclerView.Adapter<PoetAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PoetAdapter.ViewHolder {
        val rootView: View = LayoutInflater.from(context).inflate(R.layout.item_main_list, parent, false);
        return ViewHolder(rootView);
    }

    override fun onBindViewHolder(holder: PoetAdapter.ViewHolder, position: Int) {
        holder.title.text = poetList[position].title;
        holder.message.text = poetList[position].message;

        // define all the click listeners
        holder.btnEdit.setOnClickListener{
            listener.onEditButtonClicked(poetList[position], holder.btnEdit);
        }
        holder.btnDelete.setOnClickListener {
            listener.onDeleteButtonClicked(poetList[position], holder.btnDelete);
        }

    }

    override fun getItemCount(): Int {
        return poetList.size;
    }

    fun updateAdapterList(dataList: ArrayList<DataEntity>){
        poetList.clear();
        poetList.addAll(dataList);
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val title: TextView = itemView.findViewById(R.id.itemTitlePoet);
        val message: TextView = itemView.findViewById(R.id.itemMessagePoet);
        val btnEdit: AppCompatButton = itemView.findViewById(R.id.itemBtnEditPoet);
        val btnDelete: AppCompatButton = itemView.findViewById(R.id.itemBtnDeletePoet);
    }

    interface NotesItemClickListener {
        fun onEditButtonClicked(dataEntity: DataEntity, view: View);
        fun onDeleteButtonClicked(dataEntity: DataEntity, view: View);
    }

}