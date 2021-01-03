package ise308.polat.utku.g12rentacarapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import ise308.polat.utku.g12rentacarapp.Cars
import ise308.polat.utku.g12rentacarapp.JSONSerializer
import ise308.polat.utku.g12rentacarapp.MainActivity
import ise308.polat.utku.g12rentacarapp.R
import java.lang.Exception

class SearchFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.menu_search_car, container, false)
        val btn: Button = view.findViewById(R.id.btn_search)


        btn.setOnClickListener(this)
        return view
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_search -> {
                val callingActivity = activity as MainActivity
                val et_CarModel = view?.findViewById<EditText>(R.id.et_car_model)
                val searchedKey= et_CarModel?.text.toString()
                callingActivity.searchCar(searchedKey)
            }

        }
    }

}