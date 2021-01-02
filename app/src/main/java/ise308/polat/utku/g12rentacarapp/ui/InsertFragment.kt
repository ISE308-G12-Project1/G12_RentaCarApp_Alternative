package ise308.polat.utku.g12rentacarapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ise308.polat.utku.g12rentacarapp.R

class InsertFragment : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?):
            View? {
                val view = inflater.inflate(R.layout.menu_add_new_car,container,false)
        return view
    }
}