package com.practies.retrofitapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.practies.retrofitapplication.adapters.DownLoadAdapter
import com.practies.retrofitapplication.databinding.FragmentDownloadsBinding

class DownloadsFragment : Fragment() {
    private lateinit var binding: FragmentDownloadsBinding
   private lateinit var downLoadAdapter: DownLoadAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding= FragmentDownloadsBinding.inflate(inflater,container,false)
        downLoadAdapter= DownLoadAdapter(HomeFragment.testList)

        binding.downLoadsRv.hasFixedSize()
        binding.downLoadsRv.layoutManager=LinearLayoutManager(context)
        binding.downLoadsRv.setItemViewCacheSize(12)
        binding.downLoadsRv.adapter=downLoadAdapter






        return binding.root
    }


}