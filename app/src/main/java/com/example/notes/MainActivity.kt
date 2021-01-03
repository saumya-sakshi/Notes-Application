package com.example.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), INotesAdapter {


    lateinit var viewModel: NoteViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var editText: EditText
    lateinit var buttonAdd:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView=findViewById(R.id.recycleViewNotes)
        editText=findViewById(R.id.notes)
        buttonAdd=findViewById(R.id.addNote)
        recyclerView.layoutManager=LinearLayoutManager(this)
        val madapter=NotesRVAdapter(this,this)
        recyclerView.adapter=madapter
        viewModel=ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModel::class.java)
        viewModel.allnotes.observe(this, Observer {list->
            list?.let {
                madapter.updateList(it)
            }

        })

    }



    override fun onItemClicked(note: Note) {
        viewModel.deleteNote(note)
        Toast.makeText(this,"${note.text} Deleted",Toast.LENGTH_LONG).show()
    }

    fun addNote(view: View) {
        val noteText =editText.text.toString()
        if(noteText.isNotEmpty()){
        viewModel.insertNode(Note(noteText))
            Toast.makeText(this,"${noteText} Added",Toast.LENGTH_LONG).show()
        }
        if(noteText.isEmpty()){
            Toast.makeText(this, "Enter the note to add",Toast.LENGTH_LONG).show()
        }
    }
}