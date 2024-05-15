package com.asepsupriyadi22552011203.asepexamapplication

import android.app.Application
import android.os.Bundle

object GlobalVariable: Application() {

    private var list = mutableListOf<Mahasiswa>()

    fun getAllData () : MutableList<Mahasiswa> {
        return this.list
    }

    fun addNewData (
        reqTxtNim : String,
        reqTxtName: String,
        reqGender : String,
        reqTxtPassword : String,
    ) {
        val photoGender = if(reqGender == "Pria") R.drawable.male else R.drawable.female
        this.list.add(Mahasiswa(
            reqTxtName,
            reqTxtNim,
            reqGender,
            reqTxtPassword,
            photoGender
        ))
    }

    fun authenticatedAccount (
        reqTxtNim : String,
        reqTxtPassword : String,
    ) : Boolean {
        val isAccountExist : Mahasiswa? = this.list.find {
                mahasiswa ->
            reqTxtNim == mahasiswa.nim && reqTxtPassword == mahasiswa.password
        }

        return isAccountExist == null;
    }

    fun isUserAlreadyExist (
        reqTxtNim : String,
    ) : Boolean {
        val isAccountExist : Mahasiswa? = this.list.find {
                mahasiswa -> reqTxtNim == mahasiswa.nim
        }

        return isAccountExist == null;
    }



    fun getTotalRows () : Int {
        return this.list.size
    }


}