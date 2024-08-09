package fcode.demo.accessibilityissues.ui.notifications

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import fcode.demo.accessibilityissues.R
import fcode.demo.accessibilityissues.databinding.ListItemBinding

class Adapter(
    private val items: List<NotificationItem>,
    private val onClickListener: () -> Unit
) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: NotificationItem) {
            binding.title.text = item.title
            binding.date.text = item.date
            binding.content.text = item.content
            binding.actionButton.isVisible = item.action
            binding.actionButton.text = binding.root.context.getString(R.string.go)
            binding.actionButton.setOnClickListener { onClickListener.invoke() }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}

data class NotificationItem(
    val title: String,
    val date: String,
    val content: String,
    val action: Boolean
)