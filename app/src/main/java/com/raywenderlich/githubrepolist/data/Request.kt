package com.raywenderlich.githubrepolist.data

import android.util.Log
import java.net.URL

/**
 * Created by abunur on 12/12/17.
 */
class Request(private val url: String) {
  
  fun run() {
    val repoListJsonStr = URL(url).readText()
    val d = Log.d(javaClass.simpleName, repoListJsonStr)
  }
}