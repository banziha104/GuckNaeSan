package com.example.iyeongjun.gucknaesan.ui.fragments.club


import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.iyeongjun.gucknaesan.R
import com.example.iyeongjun.gucknaesan.adapter.recycler.ClubAdapter
import com.example.iyeongjun.gucknaesan.adapter.recycler.ProvinceAdapter
import com.example.iyeongjun.gucknaesan.api.model.mount.MountModel
import com.example.iyeongjun.gucknaesan.ui.fragments.mount.MountViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_club.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import javax.inject.Inject

class ClubFragment : DaggerFragment(),AnkoLogger {
    @Inject lateinit var viewModelFactory: ClubViewModelFactory
    lateinit var viewModel : ClubViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_club, container, false)
    }

    override fun onResume() {
        super.onResume()
        viewModel = ViewModelProviders.of(this, viewModelFactory)[ClubViewModel::class.java]
        bind()
    }
    fun bind(){
        provinceRecyclerview.apply {
            adapter = ProvinceAdapter(viewModel.province)
            layoutManager = LinearLayoutManager(viewModel.context)
        }
        clubRecyclerview.apply{
            adapter = ClubAdapter(viewModel.model.items)
            layoutManager = LinearLayoutManager(viewModel.context)
        }
    }
}
