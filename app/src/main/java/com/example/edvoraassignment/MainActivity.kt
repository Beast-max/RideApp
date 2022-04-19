package com.example.edvoraassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.edvoraassignment.Extensions.load
import com.example.edvoraassignment.adapter.ViewpagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var viewmodel: MainViewModel

    var i = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val City: Array<String> = resources.getStringArray(R.array.City)
        val State: Array<String> = resources.getStringArray(R.array.State)
        val tablayout = findViewById<TabLayout>(R.id.tab_layout)
        val viewpager = findViewById<ViewPager2>(R.id.view_pager_2)
        val adapter = ViewpagerAdapter(supportFragmentManager, lifecycle)
        viewmodel = ViewModelProvider(this)[MainViewModel::class.java]
        viewmodel.getUser()
        viewmodel.UserLiveData.observe(this, Observer {
            findViewById<ImageView>(R.id.circleImageView).load(it.url)
            findViewById<TextView>(R.id.name).text = it.name
        })
        viewpager.adapter = adapter
        TabLayoutMediator(tablayout, viewpager)
        { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Nearest"
                }

                1 -> {
                    tab.text = "Upcomin"
                }

                2 -> {
                    tab.text = "Past"
                }
            }
        }.attach()

        val spinner1 = findViewById<Spinner>(R.id.spinner)
        if (spinner1 != null) {
            val adapter1 = ArrayAdapter(this,
                android.R.layout.simple_spinner_item,City)
            spinner1.adapter = adapter1

            spinner1.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                    Toast.makeText(this@MainActivity,
                        getString(R.string.selected_city) + " " +
                                "" + City[position], Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
        val spinner2 = findViewById<Spinner>(R.id.spinner2)
        if (spinner2 != null) {
            val adapter2 = ArrayAdapter(this,
                android.R.layout.simple_spinner_item,State)
            spinner2.adapter = adapter2

            spinner2.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                    Toast.makeText(this@MainActivity,
                        getString(R.string.selected_state) + " " +
                                "" + State[position], Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {

                }
            }
        }
        findViewById<TextView>(R.id.filter).setOnClickListener {
            if(i==0) {
                findViewById<ConstraintLayout>(R.id.spinnerlayout).visibility = View.VISIBLE
                i = 1
            }
            else
            {
                findViewById<ConstraintLayout>(R.id.spinnerlayout).visibility = View.GONE
                i = 0
            }

        }
        findViewById<ConstraintLayout>(R.id.root).setOnClickListener {
            findViewById<ConstraintLayout>(R.id.spinnerlayout).visibility = View.GONE
        }
    }
}
