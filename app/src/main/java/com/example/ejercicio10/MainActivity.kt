package com.example.ejercicio10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    val lugares = arrayOf(
        "Sonora", "Tequila", "Paris",
        "Guadalajara", "La Paz", "Monterrey", "Saltillo", "CDMX",
        "Italia", "Roma"
    )

    lateinit var txtTexto: TextView
    lateinit var listView: ListView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtTexto = findViewById(R.id.txtTexto)
        listView = findViewById(R.id.listaLugares)
        val adaptador = ArrayAdapter(this, R.layout.list_item, lugares)
        listView.adapter = adaptador
        listView.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val valor = listView.getItemAtPosition(position)
                        as String
                Log.e("List app", "Valor es $valor")
                Toast.makeText(applicationContext, "Valor $valor", Toast.LENGTH_LONG).show()
                txtTexto.text = valor
            }

        }
    }



}