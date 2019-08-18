package com.liorcohen.fixappchallenge

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.widget.TextView
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView

private const val PAGE_COUNT = 4

class TabsPagerAdapter(fragmentManager: FragmentManager, private val context: Context) :
    FragmentStatePagerAdapter(fragmentManager) {

  private val tabTitles = arrayOf("Frag1", "Frag2", "Frag3", "Frag4")
  private val imageResId = intArrayOf(R.drawable.ic_help_24dp, R.drawable.ic_face_24dp,
          R.drawable.ic_attach_money_24dp, R.drawable.ic_assignment_24dp)

  fun getTabView(position: Int): View {
    val v = LayoutInflater.from(context).inflate(R.layout.custom_tab, null)
    val tv = v.findViewById(R.id.textView) as TextView
    tv.text = tabTitles[position]
    val img = v.findViewById(R.id.imgView) as ImageView
    img.setImageResource(imageResId[position])
    return v
  }

  // Return the Fragment associated with the object located at the specified position 
  override fun getItem(position: Int): Fragment {
    return TabFragment()
  }

  // Return the number of objects in the array.  
  override fun getCount(): Int {
    return PAGE_COUNT
  }
}
