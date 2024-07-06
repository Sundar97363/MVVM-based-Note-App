package com.sundar.mvvmbasednoteapp.ui.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvvmbasednoteapp.R
import com.example.mvvmbasednoteapp.databinding.FragmentHomeNoteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeNoteFragment : Fragment() {

    private var _binding: FragmentHomeNoteBinding? = null
    private val binding: FragmentHomeNoteBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeNoteBinding.inflate(
            layoutInflater,
            container, false
        )

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}