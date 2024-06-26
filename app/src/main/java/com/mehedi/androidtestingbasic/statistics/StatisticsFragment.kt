package com.mehedi.androidtestingbasic.statistics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mehedi.androidtestingbasic.R
import com.mehedi.androidtestingbasic.databinding.StatisticsFragBinding
import com.mehedi.androidtestingbasic.util.setupRefreshLayout

/**
 * Main UI for the statistics screen.
 */
class StatisticsFragment : Fragment() {
    
    private lateinit var viewDataBinding: StatisticsFragBinding
    
    private val viewModel by viewModels<StatisticsViewModel>()
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewDataBinding = DataBindingUtil.inflate(
            inflater, R.layout.statistics_frag, container,
            false
        )
        return viewDataBinding.root
    }
    
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.viewmodel = viewModel
        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner
        this.setupRefreshLayout(viewDataBinding.refreshLayout)
    }

    
    
}
