package com.sake.kanpai

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.sake.kanpai.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding?.owner = this
    }

    fun onClickReservationButton() {
//        Toast.makeText(this, "tapped", Toast.LENGTH_SHORT).show()
        val fragment = ReservationDialogFragment()
        fragment.show(supportFragmentManager, "ReservationDialogFragment")
    }
}
