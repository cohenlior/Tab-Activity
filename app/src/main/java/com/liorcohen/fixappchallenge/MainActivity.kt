  package com.liorcohen.fixappchallenge

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity
import android.graphics.PorterDuff
import android.support.v4.content.ContextCompat
import android.graphics.drawable.BitmapDrawable
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.PopupWindow


class MainActivity : AppCompatActivity() {
  private lateinit var tabLayout: TabLayout

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    tabLayout = findViewById(R.id.tabLayout)
    tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
      override fun onTabSelected(tab: TabLayout.Tab) {
        val color = ContextCompat.getColor(this@MainActivity, android.R.color.holo_red_dark)
        tab.icon!!.setColorFilter(color, PorterDuff.Mode.SRC_IN)

       when (tab.position){
        0,1 ->  displayPopupWindow((tabLayout.getChildAt(0) as ViewGroup).getChildAt(tab.position))
        else -> supportFragmentManager
                  .beginTransaction()
                  .replace(R.id.fragment, TabFragment(), "rageComicList")
                  .commit()
        }
      }
      override fun onTabUnselected(tab: TabLayout.Tab) {
        val color = ContextCompat.getColor(this@MainActivity, android.R.color.white)
        tab.icon!!.setColorFilter(color, PorterDuff.Mode.SRC_IN)
      }

      override fun onTabReselected(tab: TabLayout.Tab) {
      }
    })

  }

  override fun onResume() {
    super.onResume()
    tabLayout.getTabAt(3)!!.select()
  }

  private fun displayPopupWindow(anchorView: View) {
    val popup = PopupWindow(this)
    val layout = layoutInflater.inflate(R.layout.popup_content, null)
    popup.contentView = layout
    popup.height = WindowManager.LayoutParams.WRAP_CONTENT
    popup.width = WindowManager.LayoutParams.WRAP_CONTENT
    popup.isOutsideTouchable = true
    popup.setBackgroundDrawable(BitmapDrawable())
    popup.showAsDropDown(anchorView, 0, -anchorView.getHeight()*2)
  }
}
