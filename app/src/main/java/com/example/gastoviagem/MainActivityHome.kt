package com.example.gastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivityHome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_home)

        val list = listOf<Abastacer>(
            Abastacer ("Posto do Beto",32),
            Abastacer("Posto Tiger",50),
            Abastacer("Posto Tilu",25)
        )

        val abastecerList: RecyclerView = findViewById(R.id.rv_gas)

        val adapter: AbastecerListAdapter = AbastecerListAdapter(list)
        abastecerList.adapter = adapter

        val fab = findViewById<FloatingActionButton>(R.id.fab_add)
        fab.setOnClickListener {
            Snackbar.make(it,"Abastecimento", Snackbar.LENGTH_LONG)
                .setAction("Action",null)
                .show()
        }
    }
}