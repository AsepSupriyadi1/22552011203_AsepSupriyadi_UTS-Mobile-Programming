package com.asepsupriyadi22552011203.asepexamapplication

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MahasiswaAdapter(
    private var mContext : Context,
    private var resources : Int,
    private var items : List<Mahasiswa>
) : ArrayAdapter<Mahasiswa>(mContext, resources, items) {

    @SuppressLint("ViewHolder", "UseCompatLoadingForDrawables")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater : LayoutInflater = LayoutInflater.from(mContext)
        val view : View = layoutInflater.inflate(resources, null)

        val imageView : ImageView = view.findViewById(R.id.photo)
        val namaMahasiswa : TextView = view.findViewById(R.id.nama)
        val nomorNim : TextView = view.findViewById(R.id.nim)

        val mItem : Mahasiswa = items[position]
        imageView.setImageDrawable(mContext.resources.getDrawable(mItem.photo))
        namaMahasiswa.text = mItem.namaMhs
        nomorNim.text = mItem.nim

        return view
    }

}