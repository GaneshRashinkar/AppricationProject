package com.ganeshrashinkar.appricationproject.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ganeshrashinkar.appricationproject.R
import com.ganeshrashinkar.appricationproject.database.eitities.UserClass
import com.ganeshrashinkar.appricationproject.databinding.ItemUserBinding

class AdapterUsers(val context:Context,var list: MutableList<UserClass>): RecyclerView.Adapter<AdapterUsers.ViewHolder>() {

     class ViewHolder(val itemView: ItemUserBinding) : RecyclerView.ViewHolder(itemView.root){
    val textView=itemView.findViewById<TextView>(R.id.tv_user)
         val imageView=itemView.findViewById<ImageView>(R.id.imageView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemViewBinding=ItemUserBinding.inflate(LayoutInflater.from(context))
        return ViewHolder(itemViewBinding);
    }

    override fun getItemCount()=list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val user=list[position]
        holder.textView.setText(user.username)
        Glide.with(context)
            .load(user.image)
            .into(holder.imageView)
    }

}