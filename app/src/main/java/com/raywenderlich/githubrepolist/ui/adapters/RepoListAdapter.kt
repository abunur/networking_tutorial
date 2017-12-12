package com.raywenderlich.githubrepolist.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by abunur on 12/12/17.
 */
class RepoListAdapter(private val items: List<String>)
  :RecyclerView.Adapter<RepoListAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
      ViewHolder(TextView(parent.context))

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.textView.text = items[position]
  }

  override fun getItemCount(): Int = items.size



  class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}