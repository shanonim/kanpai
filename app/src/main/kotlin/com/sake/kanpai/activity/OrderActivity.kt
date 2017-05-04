package com.sake.kanpai.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.sake.kanpai.MenuAdapter
import com.sake.kanpai.R
import com.sake.kanpai.databinding.ActivityOrderBinding
import com.sake.kanpai.fragment.OrderDialogFragment
import com.sake.kanpai.model.MenuListResponse
import com.sake.kanpai.network.KanpaiApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class OrderActivity : AppCompatActivity() {

    private var kanpaiApi: KanpaiApi? = null
    private var binding: ActivityOrderBinding? = null
    private var list: MenuListResponse? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_order)


        val listAdapter = MenuAdapter(applicationContext)

        // API
        val retrofit = Retrofit.Builder()
                .baseUrl(KanpaiApi.END_POINT)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

        kanpaiApi = retrofit.create<KanpaiApi>(KanpaiApi::class.java)
        val call = kanpaiApi!!.getMenuList()
        call.enqueue(object : Callback<MenuListResponse> {
            override fun onResponse(call: Call<MenuListResponse>?, response: Response<MenuListResponse>?) {
                list = response?.body()
                listAdapter.menus = list!!.data!!.menu
                binding?.listview?.adapter = listAdapter

                binding?.setOnItemClick { adapterView, view, position, l ->
//                    Toast.makeText(applicationContext, listAdapter.menus[position].name, Toast.LENGTH_SHORT).show()
                    val fragment = OrderDialogFragment(listAdapter.menus[position])
                    fragment.show(supportFragmentManager, "OrderDialogFragment")
                }
            }

            override fun onFailure(call: Call<MenuListResponse>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })
    }

    fun onClickOrder() {
    }
}
