package com.pepinho.ad.appcodigopostal

import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.pepinho.ad.appcodigopostal.databinding.ActivityMainBinding
import com.pepinho.ad.codigopostal.model.CodigoPostal
import com.pepinho.ad.codigopostal.model.CodigoPostalDAO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private val codigoPostalDAO: CodigoPostalDAO by lazy { CodigoPostalDAO() }
    private lateinit var binding: ActivityMainBinding
    private val mainScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.viewRoot)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.svCodigo.queryHint = getString(R.string.default_query_hint)
        binding.svCodigo.setOnQueryTextListener(this)



//        codigoPostalDAO = CodigoPostalDAO()
    }

    suspend fun getCodigoPostal(codigo: String): CodigoPostal? {
        return withContext(Dispatchers.IO) {
            codigoPostalDAO.getCodigoPostal(codigo)
        }
    }

    override fun onQueryTextSubmit(codigo: String?): Boolean {
        Log.d("envio", codigo ?: "")
        mainScope.launch {
            val codigoPostal = getCodigoPostal(codigo ?: "15705")
            binding.wbCodigos.loadData(codigoPostal?.lugaresAsHTML ?: "non hay datos", "text/html", "utf-8")
            hideKeyboard()
//            Toast.makeText(this@MainActivity,
//                "Código Postal: ${codigoPostal?.codigoPostal}", Toast.LENGTH_SHORT).show()
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        Log.d("envio", newText ?: "")
        return true
    }

    private fun hideKeyboard(){
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.viewRoot.windowToken, 0)
    }
}