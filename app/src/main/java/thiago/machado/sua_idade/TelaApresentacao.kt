package thiago.machado.sua_idade

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class TelaApresentacao : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_apresentacao)

        Handler(Looper.myLooper()!!).postDelayed({
         val intent = Intent(this,TelaPrincipal::class.java)

            startActivity(intent)

            finish()

         },3000)

    }
}