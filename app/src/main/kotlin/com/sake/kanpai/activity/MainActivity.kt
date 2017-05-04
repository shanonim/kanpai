package com.sake.kanpai.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.mlkcca.client.DataElementValue
import com.mlkcca.client.MilkCocoa
import com.sake.kanpai.R
import com.sake.kanpai.databinding.ActivityMainBinding
import com.sake.kanpai.fragment.ReservationDialogFragment
import com.sake.kanpai.model.MenuListResponse
import com.sake.kanpai.model.SeatListResponse
import com.sake.kanpai.network.BLEManager
import com.sake.kanpai.network.KanpaiApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {

    private var kanpaiApi: KanpaiApi? = null

    private var binding: ActivityMainBinding? = null
    private val bluetoothManager: BLEManager = BLEManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding?.owner = this

        bluetoothManager.init()

//        timer(period = 1000) {
//            checkReservationStatus()
//        }
    }

    fun onClickReservationButton() {
        val fragment = ReservationDialogFragment()
        fragment.show(supportFragmentManager, "ReservationDialogFragment")
    }

    fun onClickBLE() {
        Toast.makeText(this, "BLE Searching...", Toast.LENGTH_LONG).show()
        bluetoothManager.search()
    }

    fun checkReservationStatus() {
//        val retrofit = Retrofit.Builder()
//                .baseUrl(KanpaiApi.END_POINT)
//                .addConverterFactory(MoshiConverterFactory.create())
//                .build()
//
//        kanpaiApi = retrofit.create<KanpaiApi>(KanpaiApi::class.java)
//        val call = kanpaiApi!!.getSeatStatus()
//        call.enqueue(object : Callback<SeatListResponse> {
//            override fun onResponse(call: Call<SeatListResponse>?, response: Response<SeatListResponse>?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onFailure(call: Call<SeatListResponse>?, t: Throwable?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//        })
    }


}
