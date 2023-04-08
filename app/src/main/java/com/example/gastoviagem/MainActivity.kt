package com.example.gastoviagem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar!!.setDisplayShowTitleEnabled(false) // tira um título que aparece a mais na toolbar


        val edtDistance =findViewById<EditText>(R.id.edt_distancia)
        val edtPrice =findViewById<EditText>(R.id.edt_preco)
        val edtAutonomy =findViewById<EditText>(R.id.edt_autonimia)
        val valueTotal = findViewById<TextView>(R.id.valor_total)
        val btnCalculate = findViewById<Button>(R.id.btn_calcular)


        btnCalculate.setOnClickListener {
            val distanceStr = edtDistance.text.toString()
            val priceStr = edtPrice.text.toString()
            val autonomyStr = edtAutonomy.text.toString()

            if(distanceStr.isNotEmpty() && priceStr.isNotEmpty() && autonomyStr.isNotEmpty()){
                val distance: Float = distanceStr.toFloat()
                val price: Float = priceStr.toFloat()
                val tvValueTotal: Float
                val autonomy: Float = autonomyStr.toFloat()

                tvValueTotal = (price * distance) / autonomy

                valueTotal.text = "R$ ${"%.2f".format(tvValueTotal)}"

            } else {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.shared_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.shared_menu ->{
                sharedApp()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun sharedApp() {
        val appMsg: String = "HEY !, check out this app for Share Button :- " +
                "https://play.google.com/store/apps/details?id=com.example.gastoviagem"

        val intent = Intent()
        intent.action = Intent.ACTION_SEND
        intent.putExtra(Intent.EXTRA_TEXT, appMsg)
        intent.type = "text/plain"
        startActivity(intent)
    }
}