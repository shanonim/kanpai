package com.sake.kanpai.fragment

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.widget.Toast
import com.mlkcca.client.DataElementValue
import com.mlkcca.client.MilkCocoa
import com.sake.kanpai.R
import com.sake.kanpai.activity.OrderActivity
import com.sake.kanpai.network.KanpaiApi

class ReservationDialogFragment : DialogFragment() {

    private var kanpaiApi: KanpaiApi? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        builder.setMessage(getString(R.string.message_request_reservation))
                .setPositiveButton(getString(R.string.button_yes), DialogInterface.OnClickListener { dialog, which ->
                    //                    Toast.makeText(context, "tapped Yes", Toast.LENGTH_SHORT).show()
                    onClickYes()
                    dismiss()
                })
                .setNegativeButton(getString(R.string.button_no), DialogInterface.OnClickListener { dialog, which ->
                    Toast.makeText(context, "tapped No", Toast.LENGTH_SHORT).show()
                    dismiss()
                })
        return builder.create()
    }

    fun onClickYes() {
        // TODO: API call
        pushMilkcocoa()

        val intent = Intent(context, OrderActivity::class.java)
        startActivity(intent)
    }

    private fun pushMilkcocoa() {
        val milkCocoa = MilkCocoa("leadii5pbr0b.mlkcca.com")
        val params = DataElementValue()
        params.put("state", 0)
        milkCocoa.dataStore("yoro").push(params)
        Toast.makeText(context, "予約しました。", Toast.LENGTH_SHORT).show()
    }
}
