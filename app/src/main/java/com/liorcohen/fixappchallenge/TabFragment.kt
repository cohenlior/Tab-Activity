package com.liorcohen.fixappchallenge

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.util.*

class TabFragment : Fragment() {
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:
  Bundle?): View? {
    val v = inflater.inflate(R.layout.fragment_tab, container, false)
    val rnd = Random()
    val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    v.setBackgroundColor(color)
    return v
  }
}
