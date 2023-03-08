package com.roadmod.tasks

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.roadmod.tasks.databinding.TaskItemBinding
import com.roadmod.tasks.generated.callback.OnClickListener
import org.w3c.dom.Text


class TaskItemAdapter (private val clickListener: (taskId : Long) -> Unit)
    : ListAdapter<Task, TaskItemAdapter.TaskItemViewHolder>(TaskDiffItemCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
    : TaskItemViewHolder = TaskItemViewHolder.inflateFrom(parent)

    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }
    class TaskItemViewHolder (val binding: TaskItemBinding)
        :RecyclerView.ViewHolder(binding.root){
        companion object {
            fun inflateFrom(parent: ViewGroup) : TaskItemViewHolder {
                    val layoutInflater = LayoutInflater.from(parent.context)
    //                    val view = layoutInflater
    //                        .inflate(R.layout.task_item, parent, false) as CardView
                    val binding = TaskItemBinding.inflate(layoutInflater, parent, false)
                    return TaskItemViewHolder(binding)
            }
        }
        fun bind (item: Task, clickListener: (taskId: Long) -> Unit) {
            binding.task = item
            binding.root.setOnClickListener { clickListener(item.taskId) }
            }
        }
    }