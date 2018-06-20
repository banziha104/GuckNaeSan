package com.example.iyeongjun.gucknaesan.ui.fragments.mount


import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.iyeongjun.gucknaesan.R
import com.example.iyeongjun.gucknaesan.adapter.recycler.MountAdapter
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_mount.*
import org.jetbrains.anko.AnkoLogger
import javax.inject.Inject


class MountFragment : DaggerFragment(), AnkoLogger {
    @Inject lateinit var mountViewModelFactory: MountViewModelFactory
    internal lateinit var viewModel: MountViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_mount, container, false)
    }

    override fun onResume() {
        super.onResume()
        viewModel = ViewModelProviders.of(this, mountViewModelFactory)[MountViewModel::class.java]
        bind()
    }

    fun bind() {
        viewModel.driver.subscribe {
            mountRecyclerView.apply {
                adapter = MountAdapter(viewModel.mountModel,viewModel.context,viewModel.sendDriver)
                layoutManager = LinearLayoutManager(viewModel.context)
            }
        }
    }
}
