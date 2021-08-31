package com.mddstudio.test69.Fm_Recy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.mddstudio.test69.R
import com.mddstudio.test69.databinding.FragmentSecondBinding


class secondd : Fragment() {


    private lateinit var binding:FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false)
        val  input=requireArguments().getString("input")
        binding.editText.text=input.toString()
        return binding.root
    }


}