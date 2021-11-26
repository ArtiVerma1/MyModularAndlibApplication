package com.example.mymodularandlibapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.calccmodule.Calcc
import com.example.calccmodule.model.DataItem
import com.example.calccmodule.model.UserModel
import com.example.calccmodule.viewmodel.HomeViewModel
import com.example.mymodularandlibapplication.Adapter.UserAdapter
import com.example.mymodularandlibapplication.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Retrofit
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var calc: Calcc
    var sum:Int = 0
    private val mainViewModel : MainViewModel by viewModels()
    private lateinit var adapter: UserAdapter
    //    @Inject
//    lateinit var navigator: APIModule
    var usermodel: UserModel? = null
    lateinit var dataitem: List<DataItem>
    @Inject
    lateinit var retrofit: Retrofit
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list : RecyclerView =findViewById(R.id.list)
        calc=Calcc()
        sum=calc.Add(3,5)
        Toast.makeText(this,sum.toString(), Toast.LENGTH_LONG)

        mainViewModel.users.observe(this, Observer {

            val dataResponse=it
            Log.d("TAG", "onResponse: "+dataResponse)
            list.layoutManager = LinearLayoutManager(applicationContext)
//            list.adapter = applicationContext?.let {
//                UserAdapter(
//                    it, usermodel?.data as List<DataItem>
//                )
//            }
            adapter= UserAdapter(this, dataResponse.data as List<DataItem>)

        })
    }
}