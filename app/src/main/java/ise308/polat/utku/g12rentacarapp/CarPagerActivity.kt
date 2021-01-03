package ise308.polat.utku.g12rentacarapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager

private var carList : ArrayList<Cars>? = null
private var jsonSerializer : JSONSerializer? = null
private var carFragmentList = java.util.ArrayList<Fragment>()
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


        for (car in carList!!) {
            carFragmentList.add(ShowCarFragment.newInstance(car))
        }

        val pageAdapter = CarPagerAdapter(supportFragmentManager, carFragmentList)
        findViewById<ViewPager>(R.id.pager_cars).adapter = pageAdapter


    }
    fun deleteCars(carModel : String) {


        var i = 0
        var flag = 0
        while (i < carList!!.size) {
            if (carList!![i].carModel == carModel) {
                Toast.makeText(applicationContext, "We found ${carModel}, and delete it", Toast.LENGTH_LONG).show()
                carList!!.remove(carList!![i])
                Toast.makeText(applicationContext, "We found ${carList!![i].carModel}, and delete it", Toast.LENGTH_LONG).show()
                flag++
            }
            i++
        }
        if(flag == 0) {
            Toast.makeText(applicationContext, "We could not found" , Toast.LENGTH_LONG).show()
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


