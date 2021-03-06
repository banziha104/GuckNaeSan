package com.example.iyeongjun.gucknaesan.ui.fragments.reco


import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.example.iyeongjun.gucknaesan.R
import com.example.iyeongjun.gucknaesan.adapter.recycler.RecoAdapter
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_reco.*
import org.jetbrains.anko.AnkoLogger
import javax.inject.Inject


class RecoFragment : DaggerFragment() ,AnkoLogger {

    @Inject lateinit var recoViewModelFactory: RecoViewModelFactory
    lateinit var viewModel: RecoViewModel
    val temp = this
    var progressBar : ProgressBar? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_reco, container, false)
        progressBar = view.findViewById(R.id.recoProgressBar)
        return view
    }

    override fun onStart() {
        super.onStart()
        viewModel = ViewModelProviders.of(this,recoViewModelFactory)[RecoViewModel::class.java]
        bind()
    }
    override fun onResume() {
        super.onResume()

    }

    private fun bind(){
        viewModel.driver.subscribe {
            recoRecyclerView.apply {
                adapter = RecoAdapter(viewModel.mountModel,
                        viewModel.context,
                        this@RecoFragment,
                        viewModel.sendDriver,
                        viewModel.tourDriver,
                        viewModel.tourApi,
                        progressBar!!)
                layoutManager = GridLayoutManager(viewModel.context,2)
            }
        }
    }
}
