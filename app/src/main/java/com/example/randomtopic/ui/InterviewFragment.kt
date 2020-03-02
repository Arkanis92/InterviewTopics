package com.example.randomtopic.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.example.randomtopic.R
import com.example.randomtopic.room.entity.InterviewTopics
import com.example.randomtopic.viewmodel.InterviewViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_interview.*

/**
 * A simple [Fragment] subclass.
 */
class InterviewFragment : Fragment() {

    private lateinit var interviewViewModel: InterviewViewModel
    private var oldRand : Int = -1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_interview, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        interviewViewModel = ViewModelProvider(this).get(InterviewViewModel::class.java)
        val fab : FloatingActionButton = view.findViewById(R.id.fabAdd)

        fab.setOnClickListener {
            interviewViewModel.allTopics.observe(viewLifecycleOwner, Observer {

                var rand = (it.indices).random()

                while (rand == oldRand) {
                    rand = (it.indices).random()
                }

                if (rand != oldRand) {
                    tvTopicText.text = it[rand].topic

                    oldRand = rand
                }
            })
        }
    }
}
