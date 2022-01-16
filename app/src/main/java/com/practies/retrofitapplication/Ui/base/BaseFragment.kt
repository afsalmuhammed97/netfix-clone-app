package com.practies.retrofitapplication.Ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.practies.retrofitapplication.api.RetrofitInstance
import com.practies.retrofitapplication.repository.BaseRepository
import com.practies.retrofitapplication.viewModel.MovieViewModelFactory

abstract class BaseFragment<viewModel:ViewModel,viewBinding:ViewBinding,repositoryB:BaseRepository>:Fragment()
{
    protected  lateinit var binding: viewBinding
     lateinit var viewModel: viewModel
    protected val retrofitInstance=RetrofitInstance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding=getFragmentBinding(inflater,container)
     // val factory=MovieViewModelFactory(getFragmentRepository())
        val factory=MovieViewModelFactory(getFragmentRepository())

        viewModel=ViewModelProvider(this,factory).get(getViewModel())

        return binding.root

    }

    abstract fun getViewModel():Class<viewModel>
    abstract fun getFragmentBinding(inflater: LayoutInflater,container: ViewGroup?):viewBinding
    abstract fun getFragmentRepository():repositoryB
}
