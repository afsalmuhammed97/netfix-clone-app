package com.practies.retrofitapplication.Ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.practies.retrofitapplication.adapters.ComingSoonPageAdapter
import com.practies.retrofitapplication.databinding.FragmentComingSoonBinding
import com.practies.retrofitapplication.repository.MovieRepository
import com.practies.retrofitapplication.viewModel.MovieViewModelFactory
import com.practies.retrofitapplication.viewModel.MoviesViewModel


class ComingSoonFragment : Fragment() {}

  //  private val viewModel:MoviesViewModel  by viewModels()
//  lateinit var viewModel:MoviesViewModel
//lateinit var binding: FragmentComingSoonBinding
//lateinit var comingSoonPageAdapter: ComingSoonPageAdapter
//
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//         binding= FragmentComingSoonBinding.inflate(inflater,container,false)
//
////        val repository=MovieRepository()
////        val vieModelFactory=MovieViewModelFactory(repository)
////        viewModel=ViewModelProvider(this,vieModelFactory).get(MoviesViewModel::class.java)
////
//
//
//          setView()
//        return binding.root
//    }
//
//    @SuppressLint("NotifyDataSetChanged")
//    private fun setView() {
//        comingSoonPageAdapter= ComingSoonPageAdapter()
//
//             viewModel.upComingMovieLiveData.observe(viewLifecycleOwner,{ Response ->
//
//                 if (Response.isSuccessful  && Response.code()==200){
//                     Response.body().let { upComingMovie->
//                         if (upComingMovie !=null){
//                             comingSoonPageAdapter.differ.submitList(upComingMovie.results)
//                             comingSoonPageAdapter.notifyDataSetChanged()
//                         }
//
//                     }
//                 }
//
//             })
//        binding.coningSoonRv.apply {
//            adapter =comingSoonPageAdapter
//            layoutManager = LinearLayoutManager(context )
//            setItemViewCacheSize(12)
//        }
//
//
//    }

    //https://play.google.com/store/apps/details?id=com.practies.musicapp
