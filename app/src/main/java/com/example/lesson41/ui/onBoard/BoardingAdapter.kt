package com.example.lesson41.ui.onBoard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson41.R
import com.example.lesson41.databinding.ItemBoardingBinding
import com.example.lesson41.models.Board

class BoardingAdapter(private val onStartClick: () -> Unit) :
    RecyclerView.Adapter<BoardingAdapter.ViewHolder>() {

    val arrayList = arrayListOf(
        Board("Task Done", R.raw.task_done),
        Board("Completing Tasks", R.raw.completing_tasks),
        Board("Completed Task Files", R.raw.completed_task_files)
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemBoardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = arrayList.size

    inner class ViewHolder(private val binding: ItemBoardingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.txtTitle.text = arrayList[adapterPosition].title
            binding.lottieMain.setAnimation(arrayList[adapterPosition].lottie)
            /*Glide.with(binding.lottieMain).load(arrayListImages).circleCrop().into(binding.lottieMain)*/
            /* binding.lottieMain.setImageResource(arrayListImages.get(adapterPosition) as Int)*/
            binding.btnStart.isVisible = adapterPosition == arrayList.lastIndex
            binding.btnStart.setOnClickListener {
                onStartClick()
            }
        }
    }
}