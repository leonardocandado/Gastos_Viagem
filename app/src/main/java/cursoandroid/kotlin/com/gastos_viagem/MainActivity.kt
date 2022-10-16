package cursoandroid.kotlin.com.gastos_viagem

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cursoandroid.kotlin.com.gastos_viagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalcular.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_calcular) {
            calculator()
        }
    }

    private fun validarDados(): Boolean {
        return (binding.editTextDistancia.text.toString() != "" &&
                binding.editTextPreco.text.toString() != "" &&
                binding.editTextAutonomia.text.toString() != "" &&
                binding.editTextAutonomia.text.toString().toFloat() != 0f
                )
    }

    private fun calculator() {
        if (validarDados()) {
            val distancia = binding.editTextDistancia.text.toString().toFloat()
            val preco = binding.editTextPreco.text.toString().toFloat()
            val autonomia = binding.editTextAutonomia.text.toString().toFloat()

            val valorTotal = (distancia * preco) / autonomia
            binding.textViewValorTotal.text = "R$ ${"%.2f".format(valorTotal)}"
        } else {
            Toast.makeText(this, R.string.campos_invalidos, Toast.LENGTH_LONG).show()
        }


    }
}