package com.practies.retrofitapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.practies.retrofitapplication.adapters.ComingSoonPageAdapter
import com.practies.retrofitapplication.adapters.UpcomingMovePageAdapter
import com.practies.retrofitapplication.databinding.FragmentComingSoonBinding
import com.practies.retrofitapplication.viewModel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ComingSoonFragment : Fragment() {

    lateinit var binding: FragmentComingSoonBinding
  //  lateinit var upcomingMovePageAdapter: UpcomingMovePageAdapter
    lateinit var comingSoonPageAdapter: ComingSoonPageAdapter
    private val viewModel:MoviesViewModel by activityViewModels()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         binding= FragmentComingSoonBinding.inflate(inflater,container,false)




          setView()
        return binding.root
    }


    @SuppressLint("NotifyDataSetChanged")
    private fun setView() {
      //  upcomingMovePageAdapter= UpcomingMovePageAdapter()
          comingSoonPageAdapter=ComingSoonPageAdapter()
             viewModel.upComingMovieLiveData.observe(viewLifecycleOwner) { Response ->
                 if (Response.isSuccessful && Response.code() == 200) {
                     Response.body().let { upComingMovie ->
                         if (upComingMovie != null) {
                             comingSoonPageAdapter.differ.submitList(upComingMovie.movie)
                             comingSoonPageAdapter.notifyDataSetChanged()
                         }

                     }
                 } }

//
//        lifecycleScope.launch {
//            viewModel.upComingMovieData.collect{
//                upcomingMovePageAdapter.submitData(it)
//
//            }
//        }

        binding.coningSoonRv.apply {
            adapter = comingSoonPageAdapter             //upcomingMovePageAdapter
            layoutManager = LinearLayoutManager(context )
            setItemViewCacheSize(12)
        }




    }

    //https://play.google.com/store/apps/details?id=com.practies.musicapp
}