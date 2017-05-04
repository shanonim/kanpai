package com.sake.kanpai

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.sake.kanpai.databinding.ItemListViewBinding
import com.sake.kanpai.model.MenuResponse

class MenuAdapter(private val context: Context) : BaseAdapter() {
    var menus: List<MenuResponse> = emptyList()

    override fun getCount(): Int = menus.size

    override fun getItem(position: Int): Any? = menus[position]

    override fun getItemId(position: Int): Long = 0

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding: ItemListViewBinding
        if (convertView == null) {
            binding = ItemListViewBinding.inflate(LayoutInflater.from(context), parent, false)
            binding.root.tag = binding
        } else {
            binding = convertView.tag as ItemListViewBinding
        }
        binding?.menu = getItem(position) as MenuResponse

        return binding.root
    }
}