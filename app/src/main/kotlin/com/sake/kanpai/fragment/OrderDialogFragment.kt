package com.sake.kanpai.fragment

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.widget.Toast
import com.mlkcca.client.DataElementValue
import com.mlkcca.client.MilkCocoa
import com.sake.kanpai.R
import com.sake.kanpai.model.MenuResponse
import com.sake.kanpai.network.KanpaiApi

class OrderDialogFragment(menuResponse: MenuResponse) : DialogFragment() {

    private var kanpaiApi: KanpaiApi? = null
    private var menu = menuResponse

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        builder.setMessage(getString(R.string.message_order, menu.name))
                .setPositiveButton(getString(R.string.button_yes), DialogInterface.OnClickListener { dialog, which ->
                    onClickYes()
                    dismiss()
                })
                .setNegativeButton(getString(R.string.button_no), DialogInterface.OnClickListener { dialog, which ->
                    dismiss()
                })
        return builder.create()
    }

    fun onClickYes() {
        // TODO: API call {
    }
}
