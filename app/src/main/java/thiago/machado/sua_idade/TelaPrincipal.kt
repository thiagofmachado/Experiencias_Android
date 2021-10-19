package thiago.machado.sua_idade

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.time.LocalDate

class TelaPrincipal : AppCompatActivity() {

    lateinit var resposta_nome: EditText
    lateinit var resposta_ano: EditText
    lateinit var resultado: EditText
    lateinit var btn_calcular_idade: Button
    lateinit var btn_limpar_dados: Button
    lateinit var btn_sair: Button

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_principal)

        initComponentes()
        initButtonClick()

    }


    private fun initComponentes() {

        resposta_nome = findViewById(R.id.resposta_nome)
        resposta_ano = findViewById(R.id.resposta_ano)
        resultado = findViewById(R.id.resultado)
        btn_calcular_idade = findViewById(R.id.btn_calcular_idade)
        btn_limpar_dados = findViewById(R.id.btn_limpar_dados)
        btn_sair = findViewById(R.id.btn_sair)

    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun initButtonClick() {

        btn_sair.setOnClickListener {

            Toast.makeText(this, "Clicado no botão sair.", Toast.LENGTH_LONG).show()

            finish()

        }

        btn_limpar_dados.setOnClickListener {

            resposta_nome.setText("")
            resposta_ano.setText("")
            resultado.setText("")

        }

        btn_calcular_idade.setOnClickListener {

            var validacao = true

            if (resposta_nome.text.isEmpty()) {

                validacao = false
                resposta_nome.setError("Campo Obrigatório!")
                resposta_nome.requestFocus()

                if (resposta_ano.text.isEmpty()) {

                    validacao = false
                    resposta_ano.setError("Campo Obrigatório")
                    resposta_ano.requestFocus()
                }
            }

            if(validacao){
                val anoNascimento = resposta_ano.text.toString().toInt()
                val anoAtual = LocalDate.now().year
                val idade = anoAtual - anoNascimento

                val nome = resposta_nome.text

                resultado.setText("Olá $nome! Você tem $idade anos de vida.")
            }




        }

    }

}
