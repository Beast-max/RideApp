package com.example.edvoraassignment.adapter


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.edvoraassignment.Fragment.FirstFragment
import com.example.edvoraassignment.Fragment.SecondFragment
import com.example.edvoraassignment.Fragment.ThiredFragment

class ViewpagerAdapter(fragmentAdapter: FragmentManager, lifecycle: Lifecycle):FragmentStateAdapter(fragmentAdapter,lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
      return when(position){
          0->FirstFragment()
          1->SecondFragment()
          2->ThiredFragment()
          else ->{
              Fragment()
          }
      }
    }
}