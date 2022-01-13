package com.practies.retrofitapplication.Ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.practies.retrofitapplication.api.RetrofitInstance
import com.practies.retrofitapplication.repository.BaseRepository

abstract class BaseFragment<viewModel:ViewModel,viewBinding:ViewBinding,repositoryB:BaseRepository>:Fragment()
{
    protected  lateinit var binding: viewBinding

    protected val retrofitInstance= RetrofitInstance

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding=getFragmentBinding(inflater,container)

        return binding.root

    }

    abstract fun getViewModel():Class<viewModel>
    abstract fun getFragmentBinding(inflater: LayoutInflater,container: ViewGroup?):viewBinding
    abstract fun getFragmentRepository():Class<repositoryB>
}
