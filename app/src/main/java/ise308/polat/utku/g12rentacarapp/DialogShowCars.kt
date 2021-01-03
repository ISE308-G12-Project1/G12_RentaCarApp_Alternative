package ise308.polat.utku.g12rentacarapp

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class DialogShowCars : DialogFragment() {
    private lateinit var car: Cars

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog{
        val builder = AlertDialog.Builder(activity)

        val inflater = activity?.layoutInflater
        val dialogLayout = inflater?.inflate(R.layout.dialog_show_cars, null)

        val textViewCarModel = dialogLayout?.findViewById<TextView>(R.id.edit_text_car_model)
        val textViewProductionYear = dialogLayout?.findViewById<TextView>(R.id.edit_text_car_production)

        val buttonDone = dialogLayout?.findViewById<Button>(R.id.button_done)

        //buttonDone?.setOnClickListener(this)
        buttonDone?.setOnClickListener {
           //val callingActivity = activity as MainActivity
            var carModel = textViewCarModel?.text.toString()
            //var carProductionYear = textViewProductionYear.toString().toInt()
            val callingActivity = activity as CarPagerActivity
            callingActivity.deleteCars(carModel)
            dismiss()
        }

        builder.setView(dialogLayout)

        return builder.create()
    }
    /*override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button_done -> {
                val callingActivity = activity as MainActivity
                val carModel = view?.findViewById<EditText>(R.id.edit_text_car_model)
                val deletedKey= carModel?.text.toString()
                callingActivity.deleteCars(deletedKey)
            }
        }
    }*/

    fun setCars(car : Cars){
        this.car = car
    }
}
