package ise308.polat.utku.g12rentacarapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ShowCarFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.note_frame, container, false)

        val  tvCarModel = view.findViewById<TextView>(R.id.textView_car_model)
        val  tvCarType = view.findViewById<TextView>(R.id.textView_car_type)
        val  tvCarProductionYear = view.findViewById<TextView>(R.id.textView_production_year)
        val  tvCarRentPrice = view.findViewById<TextView>(R.id.textView_rent_price)
        val  tvCarFlag = view.findViewById<TextView>(R.id.textView_rent_flag)
        val  tvCarPlate = view.findViewById<TextView>(R.id.textView_plate)

        tvCarModel.text = arguments!!.getString("car model")
        tvCarType.text = arguments!!.getString("car type")
        tvCarProductionYear.text = arguments!!.getString("production year")
        tvCarRentPrice.text = arguments!!.getString("rent price")
        tvCarFlag.text = arguments!!.getString("car flag")
        tvCarPlate.text = arguments!!.getString("car plate")


        return view
    }

    companion object {
        fun newInstance(car : Cars) : ShowCarFragment{

            val fragment = ShowCarFragment()
            val bundle = Bundle(1)

            bundle.putString("car model", "Car Model=> ${car.carModel}")
            bundle.putString("car type", "Car Type=> ${car.carType}")
            bundle.putString("production year", "Car Production=> ${car.productionYear}")
            bundle.putString("rent price", "Car Renting Price=> ${car.rentPrice}")
            if (car.rentFlag.toString() == "true") {
                bundle.putString("car flag", "Available")
            }
            if (car.rentFlag.toString() == "false") {
                bundle.putString("car flag", "Not Available")
            }
            bundle.putString("car plate", "Car Plate=> ${car.carPlate}")

            fragment.arguments = bundle

            return fragment
        }
    }

}