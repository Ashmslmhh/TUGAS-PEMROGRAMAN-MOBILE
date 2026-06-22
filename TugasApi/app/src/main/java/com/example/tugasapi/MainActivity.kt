package com.example.tugasapi

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)

        lifecycleScope.launch {
            try {
                val response = RetrofitClient.instance.getUnggas()

                val hasil = StringBuilder()
                hasil.append("Pesan: ${response.message}\n")
                hasil.append("Kode: ${response.code}\n\n")
                hasil.append("Daftar Unggas:\n\n")
                response.data.forEach { unggas ->
                    hasil.append("${unggas.id}. ${unggas.nama}\n")
                    hasil.append("   Jenis: ${unggas.jenis}\n")
                    hasil.append("   Jumlah kaki: ${unggas.jumlahKaki}\n\n")
                }

                textView.text = hasil.toString()
            } catch (e: Exception) {
                textView.text = "Terjadi error: ${e.message}"
            }
        }
    }
}