package com.example.notes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesRVAdapter(private val context: Context, private val listener: INotesAdapter) : RecyclerView.Adapter<NotesRVAdapter.NotesViewHolder>() {
    private val allNotes=ArrayList<Note>()
    inner class NotesViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        val textView:TextView=itemView.findViewById<TextView>(R.id.notetext)
        val buttonAdd:ImageView=itemView.findViewById<ImageView>(R.id.delete)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val viewHolder=NotesViewHolder(LayoutInflater.from(context).inflate(R.layout.items,parent,false))
        viewHolder.buttonAdd.setOnClickListener(){
            listener.onItemClicked(allNotes[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val currentNote=allNotes[position]
        holder.textView.text=currentNote.text
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }
    fun updateList(newList : List<Note>){
        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()
    }
}
interface INotesAdapter{
    fun onItemClicked(note:Note)

}