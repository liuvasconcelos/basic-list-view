package com.example.basiclistview

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.row_main.view.*

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.main_list_view)

        listView.adapter = MyCustomAdapter()
    }

    private class MyCustomAdapter(): BaseAdapter() {

        private val names = arrayListOf<String>(
            "Donald Trump", "Steve Jobs", "Tim Cook"
        )

        override fun getCount(): Int {
            return names.size
        }

        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
            val row: View

            if (convertView == null) {
                val layoutInflater = LayoutInflater.from(viewGroup?.context)
                row = layoutInflater.inflate(R.layout.row_main, viewGroup, false)

                val viewHolder = ViewHolder(row.name_textview, row.position_textview)

                row.tag = viewHolder
            } else {
                row = convertView
            }

            val viewHolder = row.tag as ViewHolder
            viewHolder.positionTextView.text = "Row number: $position"
            viewHolder.nameTextView.text = names.get(position)

            return row
        }

        // Not used for now
        override fun getItemId(position: Int): Long {
            return  position.toLong()
        }

        // Not used for now
        override fun getItem(position: Int): Any {
            return "Any :)"
        }

        private class ViewHolder(val nameTextView: TextView, val positionTextView: TextView)

    }

}
