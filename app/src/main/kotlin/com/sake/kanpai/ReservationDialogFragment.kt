package com.sake.kanpai

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

class ReservationDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        builder.setMessage(getString(R.string.message_request_reservation))
                .setPositiveButton(getString(R.string.button_yes), DialogInterface.OnClickListener { dialog, which ->
                    Toast.makeText(context, "tapped Yes", Toast.LENGTH_SHORT).show()
                    dismiss()
                })
                .setNegativeButton(getString(R.string.button_no), DialogInterface.OnClickListener { dialog, which ->
                    Toast.makeText(context, "tapped No", Toast.LENGTH_SHORT).show()
                    dismiss()
                })
        return builder.create()
    }
}