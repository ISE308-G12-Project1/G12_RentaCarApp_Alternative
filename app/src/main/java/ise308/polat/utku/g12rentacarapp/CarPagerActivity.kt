package ise308.polat.utku.g12rentacarapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager

private var carList : ArrayList<Cars>? = null
private var jsonSerializer : JSONSerializer? = null

class CarPagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_pager)

        jsonSerializer = JSONSerializer("RentACar", applicationContext)

        try {
            carList = jsonSerializer!!.load()
        } catch (e: Exception) {
            carList = ArrayList()
        }

        var carFragmentList = java.util.ArrayList<Fragment>()
        for (car in carList!!) {
            carFragmentList.add(ShowCarFragment.newInstance(car))
        }

        val pageAdapter = CarPagerAdapter(supportFragmentManager, carFragmentList)
        findViewById<ViewPager>(R.id.pager_cars).adapter = pageAdapter


        val index = pageAdapter.getItemPosition(carFragmentList)

        val buttonRemove = findViewById<Button>(R.id.button_remove)
        buttonRemove?.setOnClickListener {
            carList!!.removeAt(index)
        }

    }


    class CarPagerAdapter(
        supportFragmentManager: FragmentManager,
        private val carFragmentList: ArrayList<Fragment>
    ) : FragmentPagerAdapter(
        supportFragmentManager,
        FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    ) {

        override fun getCount() = carFragmentList.size

        override fun getItem(position: Int) = carFragmentList[position]

    }
}


