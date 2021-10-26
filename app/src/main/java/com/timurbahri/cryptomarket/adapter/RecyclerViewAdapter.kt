package com.timurbahri.cryptomarket.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.timurbahri.cryptomarket.R
import com.timurbahri.cryptomarket.adapter.RecyclerViewAdapter.RowHolder
import com.timurbahri.cryptomarket.model.CryptoModel
import kotlinx.android.synthetic.main.row_layout.view.*

class RecyclerViewAdapter(private val cryptoList: ArrayList<CryptoModel>,private val listener : Listener) : RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>() {

    interface  Listener {
        fun onItemClick (cryptoModel: CryptoModel)
    }

    private val colors : ArrayList<String> = arrayListOf("#a724cc","#8fce00","#0d0b0b","#ec1f10","#1395f7","#4c1130")


    class RowHolder(view:View) : RecyclerView.ViewHolder(view) {

        fun bind(cryptoModel : CryptoModel, colors : ArrayList<String>,position: Int, listener: Listener) {
            itemView.setOnClickListener {
                listener.onItemClick(cryptoModel)
            }
            itemView.setBackgroundColor(Color.parseColor(colors[position % 6]))
            itemView.text_name.text = cryptoModel.currency
            itemView.text_price.text = cryptoModel.price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout,parent,false)
        return RowHolder(view)
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.bind(cryptoList[position],colors,position,listener)

    }

    override fun getItemCount(): Int {
        return  cryptoList.size
    }

}