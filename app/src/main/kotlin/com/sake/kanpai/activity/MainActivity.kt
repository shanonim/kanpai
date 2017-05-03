package com.sake.kanpai.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.sake.kanpai.R
import com.sake.kanpai.databinding.ActivityMainBinding
import com.sake.kanpai.fragment.ReservationDialogFragment
import com.sake.kanpai.network.BLEManager

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private val bluetoothManager: BLEManager = BLEManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding?.owner = this

        bluetoothManager.init()
    }

    fun onClickReservationButton() {
        val fragment = ReservationDialogFragment()
        fragment.show(supportFragmentManager, "ReservationDialogFragment")
    }

    fun onClickBLE() {
        Toast.makeText(this, "BLE Searching...", Toast.LENGTH_LONG).show()
        bluetoothManager.search()
    }
}
