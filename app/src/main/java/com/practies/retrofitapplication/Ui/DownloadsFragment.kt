package com.practies.retrofitapplication.Ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.practies.retrofitapplication.adapters.DownLoadAdapter
import com.practies.retrofitapplication.databinding.FragmentDownloadsBinding
import com.practies.retrofitapplication.repository.MovieRepository
import com.practies.retrofitapplication.viewModel.MovieViewModelFactory
import com.practies.retrofitapplication.viewModel.MoviesViewModel

class DownloadsFragment : Fragment() {
    private lateinit var binding: FragmentDownloadsBinding
   private lateinit var downLoadAdapter: DownLoadAdapter
   lateinit var viewModel: MoviesViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding= FragmentDownloadsBinding.inflate(inflater,container,false)

        val repository= MovieRepository()
        val viewModelFactory= MovieViewModelFactory(repository)
        viewModel= ViewModelProvider(this,viewModelFactory).get(MoviesViewModel::class.java)


          setDownLoadView()


        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setDownLoadView() {
        downLoadAdapter= DownLoadAdapter()
        viewModel.nowPLayingMovieLiveData.observe(viewLifecycleOwner,{Response->
            if (Response.isSuccessful && Response.code()==200){
                Response.body().let { nowPlayingMovie->
                    if (nowPlayingMovie != null) {
                        downLoadAdapter.differ.submitList(nowPlayingMovie.results)
                        downLoadAdapter.notifyDataSetChanged()

                    }
                }
            }

        })



        binding.downLoadsRv.apply {
            adapter=downLoadAdapter
            hasFixedSize()
            layoutManager=LinearLayoutManager(context)
            setItemViewCacheSize(20)
        }

    }


}