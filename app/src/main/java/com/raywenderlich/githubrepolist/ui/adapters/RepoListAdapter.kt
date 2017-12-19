/*
 * Copyright (c) 2017 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.raywenderlich.githubrepolist.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.raywenderlich.githubrepolist.R
import com.raywenderlich.githubrepolist.data.Item
import com.raywenderlich.githubrepolist.data.RepoResult
import com.raywenderlich.githubrepolist.extensions.ctx
import kotlinx.android.synthetic.main.item_repo.view.*

/**
 * Created by abunur on 12/12/17.
 */
class RepoListAdapter(private val repoList: RepoResult) : RecyclerView.Adapter<RepoListAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_repo, parent, false)
    return ViewHolder(view)
  }


  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//    with(repoList.items[position]){
//      holder.textView.text = "replace with content"
//    }
    holder.bindRepo(repoList.items[position])
  }

  override fun getItemCount(): Int = repoList.items.size



  class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bindRepo(repo: Item) {
      with(repo) {
        //TODO: bind avatar image using Picasso
//        repo.owner.login.let { itemView.username.text = repo.owner.login }
        itemView.username.text = repo.owner.login.orEmpty()
        itemView.repoName.text = repo.full_name.orEmpty()
        itemView.repoDescription.text = repo.description.orEmpty()
      }
    }
  }
}