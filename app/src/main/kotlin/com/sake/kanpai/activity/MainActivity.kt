package com.sake.kanpai.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.sake.kanpai.R
import com.sake.kanpai.databinding.ActivityMainBinding
import com.sake.kanpai.fragment.ReservationDialogFragment

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding?.owner = this
    }

    fun onClickReservationButton() {
        val fragment = ReservationDialogFragment()
        fragment.show(supportFragmentManager, "ReservationDialogFragment")
    }
}
