package com.practies.retrofitapplication.Ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.practies.retrofitapplication.Ui.base.BaseFragment
import com.practies.retrofitapplication.Utill.handleApiError
import com.practies.retrofitapplication.Utill.snackBar
import com.practies.retrofitapplication.adapters.ComingSoonPageAdapter
import com.practies.retrofitapplication.api.ApiService
import com.practies.retrofitapplication.api.Resource
import com.practies.retrofitapplication.databinding.FragmentComingSoonBinding
import com.practies.retrofitapplication.repository.MainRepository
import com.practies.retrofitapplication.repository.MovieRepository
import com.practies.retrofitapplication.viewModel.MainViewModel
import com.practies.retrofitapplication.viewModel.MovieViewModelFactory
import com.practies.retrofitapplication.viewModel.MoviesViewModel


class ComingSoonFragment : BaseFragment<MainViewModel,FragmentComingSoonBinding,MainRepository>(){
  lateinit var comingSoonPageAdapter: ComingSoonPageAdapter
    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        comingSoonPageAdapter= ComingSoonPageAdapter()

          viewModel.getUpComingMovies()

        viewModel.upComingMovieResponse.observe(viewLifecycleOwner, Observer {

                when(it){
                    is Resource.Success->{
                        val data=it.value.body()!!.results
                        comingSoonPageAdapter.differ.submitList(data)
                        comingSoonPageAdapter.notifyDataSetChanged()
                         setRecyclerView()
                        view.snackBar(data.size.toString(),null)
                    }
                    is Resource.Failure->{
                        handleApiError(it)
                        binding.progressBar1.visibility=View.VISIBLE

                    }
                }

        })

    }



fun setRecyclerView(){

    binding.coningSoonRv.apply {
            adapter =comingSoonPageAdapter
            layoutManager = LinearLayoutManager(context )
            setItemViewCacheSize(12)
        }
}


    override fun getViewModel()=MainViewModel::class.java

    override fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?
    )= FragmentComingSoonBinding.inflate(inflater,container,false)

    override fun getFragmentRepository()= MainRepository(retrofitInstance.buildApi(ApiService::class.java))
}



    //https://play.google.com/store/apps/details?id=com.practies.musicapp
