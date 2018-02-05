package com.raywenderlich.githubrepolist.ui.activities

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.raywenderlich.githubrepolist.R
import com.raywenderlich.githubrepolist.data.Request
import com.raywenderlich.githubrepolist.ui.adapters.RepoListAdapter
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread
import kotlinx.android.synthetic.main.activity_main.*

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

    repoList.layoutManager = LinearLayoutManager(this)
    repoList.adapter = RepoListAdapter(items)
    //search for popular tetris repositories written in Kotlin
//    val url = "https://api.github.com/search/repositories?q=tetris+language:kotlin&sort=stars&order=desc"
    val url = "https://api.github.com/search/repositories?q=mario+language:kotlin&sort=stars&order=desc"
    doAsync {
      Request(url).run()
      uiThread { longToast("Request performed") }
    }
  }
}
