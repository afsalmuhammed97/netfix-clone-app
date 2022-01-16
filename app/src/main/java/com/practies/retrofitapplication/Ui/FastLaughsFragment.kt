package com.practies.retrofitapplication.Ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.practies.retrofitapplication.adapters.FastLaughAdapter
import com.practies.retrofitapplication.databinding.FragmentFastLaughsBinding
import com.practies.retrofitapplication.repository.MovieRepository
import com.practies.retrofitapplication.viewModel.MovieViewModelFactory
import com.practies.retrofitapplication.viewModel.MoviesViewModel

class FastLaughsFragment : Fragment() {}
//   lateinit var binding: FragmentFastLaughsBinding
//    lateinit var fastLaughAdapter: FastLaughAdapter
//    lateinit var viewModel: MoviesViewModel
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        // Inflate the layout for this fragment
//        binding= FragmentFastLaughsBinding.inflate(inflater,container,false)
//        val repository=MovieRepository()
//        val viewModelFactory=MovieViewModelFactory(repository)
//        viewModel=ViewModelProvider(this,viewModelFactory).get(MoviesViewModel::class.java)
//
//
//              setView()
//
//
//
//            return binding.root
//    }
//
//    @SuppressLint("NotifyDataSetChanged")
//    private fun setView() {
//    fastLaughAdapter= FastLaughAdapter()
//
//        viewModel.nowPLayingMovieLiveData.observe(viewLifecycleOwner,{Response->
//            if (Response.isSuccessful && Response.code()==200){
//                Response.body().let { nowPlayingMovie->
//                    if (nowPlayingMovie != null) {
//                        fastLaughAdapter.differ.submitList(nowPlayingMovie.results)
//                        fastLaughAdapter.notifyDataSetChanged()
//                        //trendingMovieAdapter.movies=topRatedMovie.results
//                    }
//                }
//            }
//
//        })
//
//
//        binding.fastLaughRv.apply {
//     adapter=fastLaughAdapter
//         hasFixedSize()
//         layoutManager=LinearLayoutManager(context)
//         setItemViewCacheSize(20)
//
//     }
//
//    }
//
//
//}
//
//
