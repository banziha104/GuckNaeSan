package com.example.iyeongjun.gucknaesan.ui.fragments.reco


import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.iyeongjun.gucknaesan.R
import com.example.iyeongjun.gucknaesan.adapter.recycler.RecoAdapter
import com.example.iyeongjun.gucknaesan.ex.random
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_reco.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import javax.inject.Inject


class RecoFragment : DaggerFragment() ,AnkoLogger {

    @Inject lateinit var recoViewModelFactory: RecoViewModelFactory
    lateinit var viewModel: RecoViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_reco, container, false)
    }

    override fun onResume() {
        super.onResume()
        viewModel = ViewModelProviders.of(this,recoViewModelFactory)[RecoViewModel::class.java]
        bind()
    }
    private fun bind(){
        viewModel.driver.subscribe {
            recoRecyclerView.apply {
                adapter = RecoAdapter(it.random())
                layoutManager = GridLayoutManager(viewModel.context,2)
            }
        }
    }
}
