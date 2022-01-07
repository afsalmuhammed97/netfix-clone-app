package com.practies.retrofitapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.practies.retrofitapplication.adapters.ComingSoonPageAdapter
import com.practies.retrofitapplication.databinding.FragmentComingSoonBinding


class ComingSoonFragment : Fragment() {

lateinit var binding: FragmentComingSoonBinding
lateinit var comingSoonPageAdapter: ComingSoonPageAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         binding= FragmentComingSoonBinding.inflate(inflater,container,false)


           comingSoonPageAdapter= ComingSoonPageAdapter(HomeFragment.testList)
        binding.coningSoonRv.hasFixedSize()
        binding.coningSoonRv.layoutManager =
            LinearLayoutManager(context )
        binding.coningSoonRv.setItemViewCacheSize(12)
        binding.coningSoonRv.adapter =comingSoonPageAdapter


        return binding.root
    }

      //https://play.google.com/store/apps/details?id=com.practies.musicapp
}