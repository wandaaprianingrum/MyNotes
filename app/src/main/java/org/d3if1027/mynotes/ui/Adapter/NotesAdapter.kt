package org.d3if1027.mynotes.ui.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import org.d3if1027.mynotes.Model.Notes
import org.d3if1027.mynotes.R
import org.d3if1027.mynotes.databinding.ItemNoteBinding

class NotesAdapter(val requireContext: Context, val notesList: List<Notes>) :
    RecyclerView.Adapter<NotesAdapter.notesViewHolder>() {

    class notesViewHolder(val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): notesViewHolder {
        return notesViewHolder(ItemNoteBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: notesViewHolder, position: Int) {
        val data = notesList[position]
        holder.binding.notesTitle.text = data.title.toString()
        holder.binding.notesSubtile.text = data.title.toString()
        holder.binding.notesDate.text = data.title.toString()

        when(data.priority) {
            "1" -> {
                holder.binding.viewPriority.setBackgroundResource(R.drawable.purple_dot)
            }
            "2" -> {
                holder.binding.viewPriority.setBackgroundResource(R.drawable.green_dot)
            }
            "3" -> {
                holder.binding.viewPriority.setBackgroundResource(R.drawable.red_dot)
            }
        }
//
//        holder.binding.root.setOnClickListener{
//            val action = HomeFragmentDirections.actionHomeFragmentToEditNotesFragment(data)
//            Navigation.findNavController(it).navigate(action)
//        }
    }

    override fun getItemCount() = notesList.size
}