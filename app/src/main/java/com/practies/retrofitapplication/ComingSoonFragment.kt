package com.practies.retrofitapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.practies.retrofitapplication.adapters.ComingSoonPageAdapter
import com.practies.retrofitapplication.databinding.FragmentComingSoonBinding
import com.practies.retrofitapplication.viewModel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.combine

@AndroidEntryPoint
class ComingSoonFragment : Fragment() {

    private val viewModel:MoviesViewModel  by viewModels()
lateinit var binding: FragmentComingSoonBinding
lateinit var comingSoonPageAdapter: ComingSoonPageAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         binding= FragmentComingSoonBinding.inflate(inflater,container,false)




          setView()
        return binding.root
    }

    private fun setView() {
        comingSoonPageAdapter= ComingSoonPageAdapter()

        binding.coningSoonRv.apply {
            adapter =comingSoonPageAdapter
            layoutManager = LinearLayoutManager(context )
            setItemViewCacheSize(12)
        }


    }

    //https://play.google.com/store/apps/details?id=com.practies.musicapp
}