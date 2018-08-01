package com.example.iyeongjun.gucknaesan.ui.fragments.mount


import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.example.iyeongjun.gucknaesan.R
import com.example.iyeongjun.gucknaesan.adapter.recycler.MountAdapter
import com.example.iyeongjun.gucknaesan.adapter.recycler.MountProvinceAdapter
import com.example.iyeongjun.gucknaesan.ex.getProvince
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_mount.*
import org.jetbrains.anko.AnkoLogger
import javax.inject.Inject


class MountFragment : DaggerFragment(), AnkoLogger {

    companion object {
        private const val VERTICAL = 1
    }

    @Inject
    lateinit var mountViewModelFactory: MountViewModelFactory
    internal lateinit var viewModel: MountViewModel
    val temp = this
    var progressBar : ProgressBar? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_mount, container, false)
        progressBar = view.findViewById(R.id.mountProgressBar)
        return view
    }

    override fun onResume() {
        super.onResume()
        viewModel = ViewModelProviders.of(this, mountViewModelFactory)[MountViewModel::class.java]
        bind()
    }

    fun bind() {
        viewModel.clickDriver.subscribe({
            if (it === "전체" || it === null || it === "") {
                mountRecyclerView.apply {
                    adapter = MountAdapter(viewModel.mountModel,
                            viewModel.context,
                            temp, viewModel.sendDriver,
                            viewModel.tourApi,
                            viewModel.tourDriver,
                            progressBar!!)
                    layoutManager = LinearLayoutManager(viewModel.context)
                    adapter.notifyDataSetChanged()
                }
            } else {
                mountRecyclerView.apply {
                    adapter = MountAdapter(viewModel.mountModel.filter { item -> item.province == it.getProvince()  },
                            viewModel.context,
                            temp,
                            viewModel.sendDriver,
                            viewModel.tourApi,
                            viewModel.tourDriver,
                            progressBar!!)
                    layoutManager = LinearLayoutManager(viewModel.context)
                    adapter.notifyDataSetChanged()
                }
            }
        }, {
            it.printStackTrace()
        })
        mountProvinceRecyclerview.apply {
            adapter = MountProvinceAdapter(viewModel.province, viewModel.clickDriver)
            layoutManager = LinearLayoutManager(viewModel.context)
            addItemDecoration(DividerItemDecoration(activity, VERTICAL))
        }
    }
}
