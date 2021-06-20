package com.example.finalproject

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.databinding.DisplayQuestionsBinding

class QuestionsAdapter(private val data: MutableList<DataModel>): RecyclerView.Adapter<QuestionsAdapter.DataViewHolder> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val dataHolder = DisplayQuestionsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(dataHolder)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.nasaNewsBind()
    }

    override fun getItemCount() = data.size

    inner class DataViewHolder(private val binding: DisplayQuestionsBinding): RecyclerView.ViewHolder(binding.root) {
        private lateinit var questionsData:DataModel
        fun nasaNewsBind(){
            questionsData = data[adapterPosition]
            binding.checkBox.text = questionsData.question.toString()
            binding.checkBox2.text = questionsData.answer1.toString()
            binding.checkBox3.text = questionsData.answer2.toString()
            binding.checkBox4.text = questionsData.answer3.toString()
            binding.checkBox5.text = questionsData.correctAnswer.toString()

            binding.submitQuestion.setOnClickListener{

                if(binding.checkBox5.isChecked && !binding.checkBox2.isChecked && !binding.checkBox3.isChecked &&
                    !binding.checkBox4.isChecked && !binding.checkBox4.isChecked){
                    Toast.makeText(itemView.context, "correct answer", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(itemView.context, "wrong answer", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}