package com.example.finalproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalproject.databinding.FragmentQuestionBinding

class QuestionFragment : Fragment() {

    private val data = mutableListOf<DataModel>()
    private lateinit var binding: FragmentQuestionBinding
    private lateinit var adapter: QuestionsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuestionBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }
    private fun init(){
        setData()
        adapter = QuestionsAdapter(data)
        binding.RecyclerView.layoutManager = LinearLayoutManager(context)
        binding.RecyclerView.adapter = adapter
    }

    private fun setData(){
        data.add(DataModel("\"ადამიანი თავის თავს კითხვებშიც ისე წარმოაჩენს როგორც პასუხებში\" ვის ეკუთვნის ეს სიტყვები?", "სალომე ზურაბიშვილი", "მიხეილ სააკაშვილი", "ედუარდ შევარდნაძე", "ზვიად გამსახურდია"))
        data.add(DataModel("როდის შეიქმნა ანდროიდი?", "2021 ", "2000 ", "2003", "2008 "))
        data.add(DataModel("როდის შეიქმნა kotlin-ი?", "2020", "2013", "2005", "2010"))
        data.add(DataModel("როდის დაარსდა BTU?", "2015", "2010", "2004", "2016"))
        data.add(DataModel("ჩავაბარებთ თუ არა გამოცდას?", "დიახ", "კი ბატონო", "ორი აზრი არაა", "რა თქმა უნდა"))
    }
}