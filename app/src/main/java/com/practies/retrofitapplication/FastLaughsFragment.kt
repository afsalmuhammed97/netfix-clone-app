package com.practies.retrofitapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.practies.retrofitapplication.HomeFragment.Companion.testList
import com.practies.retrofitapplication.adapters.FastLaughAdapter
import com.practies.retrofitapplication.databinding.FragmentFastLaughsBinding

class FastLaughsFragment : Fragment() {
   lateinit var binding: FragmentFastLaughsBinding
    lateinit var fastLaughAdapter: FastLaughAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding= FragmentFastLaughsBinding.inflate(inflater,container,false)

        fastLaughAdapter= FastLaughAdapter(testList)
        binding.fastLaughRv .hasFixedSize()
        binding.fastLaughRv.layoutManager =
            LinearLayoutManager(context )
        binding.fastLaughRv.setItemViewCacheSize(12)
        binding.fastLaughRv.adapter = fastLaughAdapter







        return binding.root
    }


}