package ise308.polat.utku.g12rentacarapp

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class CarsAdapter(private val carList: ArrayList<Cars>,private val mainActivity: MainActivity) : RecyclerView.Adapter<CarsAdapter.CarsViewHolder>() {


    inner class CarsViewHolder(carsItemView: View) : RecyclerView.ViewHolder(carsItemView), View.OnClickListener {
        internal var textViewCarModel = carsItemView.findViewById<TextView>(R.id.tv_car_model)
        internal var textViewProductionYear = carsItemView.findViewById<TextView>(R.id.tv_production_year)
        internal var textViewRentPrice = carsItemView.findViewById<TextView>(R.id.tv_rent_price)

        init {
            carsItemView.isClickable
            carsItemView.setOnClickListener(this)
        }

        override fun onClick(view : View?) {
            val intentToCarsPager = Intent(view!!.context, CarPagerActivity::class.java)
            view.context.startActivity(intentToCarsPager)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsViewHolder {

        val carsItemInflater = LayoutInflater.from(parent.context)
        val carsItemView = carsItemInflater.inflate(R.layout.cars_item, parent, false)
        return CarsViewHolder(carsItemView)

    }

    override fun onBindViewHolder(holder: CarsViewHolder, position: Int) {

        val carsForDisplay = carList.get(position)
        holder.textViewCarModel.text = "Car Model=> ${carsForDisplay.carModel}"
        holder.textViewProductionYear.text = "Car Production=> ${carsForDisplay.productionYear.toString()}"
        holder.textViewRentPrice.text = "Car Renting Price=> ${carsForDisplay.rentPrice.toString()}"

    }

    override fun getItemCount() = carList.size


}
