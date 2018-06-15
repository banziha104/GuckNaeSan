package com.example.iyeongjun.gucknaesan.ui.activities.detail

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.iyeongjun.gucknaesan.R
import com.example.iyeongjun.gucknaesan.ui.GlideApp
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*
import okhttp3.ResponseBody
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class DetailActivity : DaggerAppCompatActivity(), AnkoLogger {
    @Inject lateinit var viewModelFactory: DetailViewModelFactory
    lateinit var viewModel: DetailViewModel
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        viewModel = ViewModelProviders.of(this,viewModelFactory)[DetailViewModel::class.java]
        bind()
    }
    fun bind(){
        viewModel.driver.subscribe{ item ->
            txtDetailDes.text = item.description
            txtDetailTitle.text = item.mtName
            val activity = DetailActivity@this
            if(!activity.isFinishing){
                GlideApp.with(this)
                        .load(item.imgUrl)
                        .into(imgDetail)
            }
        }
    }
}
