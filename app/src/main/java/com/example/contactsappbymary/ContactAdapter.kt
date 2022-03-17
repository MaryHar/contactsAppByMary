package com.example.contactsappbymary

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(var context: Context, var dataArray:
ArrayList<ContactDesign>) : RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val imgContact = itemView.findViewById<ImageView>(R.id.imageContact)
        val contactName = itemView.findViewById<TextView>(R.id.contactFirstName)
        val contactNumber = itemView.findViewById<TextView>(R.id.contactNumber)
        val deleteContact = itemView.findViewById<TextView>(R.id.imageDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.contact_row_design, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imgContact.setImageResource(dataArray[position].imageContact)
        holder.contactName.text = dataArray[position].nameContact
        holder.contactNumber.text = dataArray[position].phoneNumber

        holder.deleteContact.setOnClickListener {
            AlertDialog.Builder(context).apply {
                setTitle("Delete")
                setIcon(R.drawable.delete)
                setMessage("Are you sure you want to delete this number?")


                setPositiveButton("YES") { _, _ ->
                    dataArray.removeAt(position)
                    notifyItemRemoved(position)
                }
                setNegativeButton("NO") { _, _ ->
                }
                show()
            }
            true
        }

        holder.contactName.setOnClickListener{
            val intent = Intent().apply {
                action = Intent.ACTION_DIAL
                data = Uri.parse("tel: ${dataArray[position].phoneNumber   }")
            }

            context.startActivity(intent)
            Toast.makeText(context, "You call to ${dataArray[position].nameContact}", Toast.LENGTH_SHORT).show()
        }
        holder.imgContact.setOnClickListener{
            val intent = Intent().apply {
                action = Intent.ACTION_DIAL
                data = Uri.parse("tel: ${dataArray[position].phoneNumber   }")
            }

            context.startActivity(intent)
            Toast.makeText(context, "You call to ${dataArray[position].nameContact}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return dataArray.size
    }
}