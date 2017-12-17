package com.raywenderlich.githubrepolist.ui.activities

import android.app.Activity
import android.app.AlertDialog

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.raywenderlich.githubrepolist.R
import com.raywenderlich.githubrepolist.data.Request
import com.raywenderlich.githubrepolist.ui.adapters.RepoListAdapter
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread

class MainActivity: Activity() {

  private val items = listOf(
      "JetBrains/kotlin - The Kotlin Programming Language",
      "exercism/kotlin - Exercism exercises in Kotlin",
      "cbeust/kobalt - A Kotlin-based build system for the JVM",
      "JetBrains/kotlin - The Kotlin Programming Language",
      "exercism/kotlin - Exercism exercises in Kotlin",
      "cbeust/kobalt - A Kotlin-based build system for the JVM",
      "JetBrains/kotlin - The Kotlin Programming Language"
  )

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val repoList = find<RecyclerView>(R.id.repo_list)
    repoList.layoutManager = LinearLayoutManager(this)
    repoList.adapter = RepoListAdapter(items)
    //search for popular tetris repositories written in Kotlin
//    val url = "https://api.github.com/search/repositories?q=tetris+language:kotlin&sort=stars&order=desc"
    val url = "https://api.github.com/search/repositories?q=mario+language:kotlin&sort=stars&order=desc"

    if (isNetworkConnected()) {
      doAsync {
        Request(url).run()
        uiThread { longToast("Request performed") }
      }
    } else {
      AlertDialog.Builder(this).setTitle("No Internet Connection")
          .setMessage("Please check your internet connection and try again")
          .setPositiveButton(android.R.string.ok) { dialog, which -> }
          .setIcon(android.R.drawable.ic_dialog_alert).show()
    }


  }

  private fun isNetworkConnected(): Boolean {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkInfo = connectivityManager.activeNetworkInfo
    return networkInfo != null && networkInfo.isConnected
  }

}
