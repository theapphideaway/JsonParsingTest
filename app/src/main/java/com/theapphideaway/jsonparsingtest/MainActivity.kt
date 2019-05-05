package com.theapphideaway.jsonparsingtest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.theapphideaway.jsonparsingtest.networking.WebService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private var webService = WebService()
    private lateinit var baseAdapter: ToDoAdapter
    private lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch(Dispatchers.Main) {
            var items = webService.getToDoApi().getToDoItems( ).await()

            layoutManager = LinearLayoutManager(this@MainActivity)
            baseAdapter = ToDoAdapter(items, this@MainActivity)

            todo_recycler_view.adapter = baseAdapter
            todo_recycler_view.layoutManager = layoutManager
        }
    }
}
