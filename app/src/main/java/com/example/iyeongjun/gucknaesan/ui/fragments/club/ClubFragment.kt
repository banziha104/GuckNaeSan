package com.example.iyeongjun.gucknaesan.ui.fragments.club


import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.system.Os.bind
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.iyeongjun.gucknaesan.R
import com.example.iyeongjun.gucknaesan.adapter.recycler.ClubAdapter
import com.example.iyeongjun.gucknaesan.adapter.recycler.MountAdapter
import com.example.iyeongjun.gucknaesan.adapter.recycler.ProvinceAdapter
import com.example.iyeongjun.gucknaesan.api.model.club.ClubModel
import com.example.iyeongjun.gucknaesan.const.DataDriver.clubProDriver
import com.example.iyeongjun.gucknaesan.ex.getProvince
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_club.*
import kotlinx.android.synthetic.main.fragment_mount.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import javax.inject.Inject

class ClubFragment : DaggerFragment(),AnkoLogger {

    @Inject lateinit var viewModelFactory: ClubViewModelFactory
    lateinit var viewModel : ClubViewModel
    val tempContext = this
    companion object {
        private const val VERTICAL = 1
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_club, container, false)
    }

    override fun onResume() {
        super.onResume()
        viewModel = ViewModelProviders.of(this, viewModelFactory)[ClubViewModel::class.java]
        viewModel.clickDriver
        .subscribe({
            if(it === "전체" || it === null || it === ""){
                clubRecyclerview.apply{
                    info {"이리 빠지기는 하냐"}
                    adapter = ClubAdapter(viewModel.model.items,
                            viewModel.context,
                            tempContext,viewModel.driver)
                    layoutManager = LinearLayoutManager(viewModel.context)
                    adapter.notifyDataSetChanged()
                }
            }else{
                clubRecyclerview.apply{
                    adapter = ClubAdapter(viewModel.model.items.filter { item ->
                        info { "${it.getProvince()} / ${item.province}" }
                         item.province == it
                    },
                            viewModel.context,
                            tempContext,viewModel.driver)
                    layoutManager = LinearLayoutManager(viewModel.context)
                    adapter.notifyDataSetChanged()
                }
            }
        },{
            it.printStackTrace()
        })
        bind()
    }

    fun bind() {
        provinceRecyclerview.apply {
            adapter = ProvinceAdapter(viewModel.province, viewModel.clickDriver, clubProDriver)
            layoutManager = LinearLayoutManager(viewModel.context)
            addItemDecoration(DividerItemDecoration(activity, VERTICAL))
        }
    }
}
