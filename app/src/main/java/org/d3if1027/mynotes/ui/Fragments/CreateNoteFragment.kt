package org.d3if1027.mynotes.ui.Fragments

import android.os.Bundle
import android.text.format.DateFormat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import org.d3if1027.mynotes.Model.Notes
import org.d3if1027.mynotes.R
import org.d3if1027.mynotes.ViewModel.NotesViewModel
import org.d3if1027.mynotes.databinding.FragmentCreateNoteBinding
import java.util.*


class CreateNoteFragment : Fragment() {

    lateinit var binding:FragmentCreateNoteBinding
    var priority: String = "1"
    val viewModel : NotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentCreateNoteBinding.inflate(layoutInflater, container, false)

        binding.pPurple.setImageResource(R.drawable.ic_baseline_add_24)

        binding.pPurple.setOnClickListener{
            priority="1"
            binding.pPurple.setImageResource(R.drawable.ic_baseline_add_24)
            binding.pRed.setImageResource(0)
            binding.pGreen.setImageResource(0)
        }

        binding.pGreen.setOnClickListener{
            priority="2"
            binding.pGreen.setImageResource(R.drawable.ic_baseline_add_24)
            binding.pRed.setImageResource(0)
            binding.pPurple.setImageResource(0)
        }

        binding.pRed.setOnClickListener{
            priority="3"
            binding.pRed.setImageResource(R.drawable.ic_baseline_add_24)
            binding.pPurple.setImageResource(0)
            binding.pGreen.setImageResource(0)
        }

        binding.btnSaveNotes.setOnClickListener {
            createNotes(it)
        }

        return binding.root
    }

    private fun createNotes(it: View?) {
        val title = binding.editTitle.text.toString()
        val subtitle = binding.editSubtitle.text.toString()
        val notes = binding.editNotes.text.toString()
        val d = Date()
        val notesDate: CharSequence = DateFormat.format("MMMM d, yyyy ", d.time)

        val data = Notes(null, title = title, subtitle = subtitle, notes = notes, date = notesDate.toString(), priority = priority)
        viewModel.addNotes(data)

        Toast.makeText(requireContext(), "Catatan Berhasil Ditambahkan!", Toast.LENGTH_SHORT).show()
        Navigation.findNavController(it!!).navigate(R.id.action_createNoteFragment_to_homeFragment)
    }
}