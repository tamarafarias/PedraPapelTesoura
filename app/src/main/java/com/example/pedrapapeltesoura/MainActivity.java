package com.example.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view){
        this.opcaoSelecionada("Pedra");

    }

    public void selecionadoPapel(View view){
        this.opcaoSelecionada("Papel");

    }

    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("Tesoura");

    }

    @SuppressLint("SetTextI18n")
    public void opcaoSelecionada(String escolhausuario) {

        ImageView imagemResultado = findViewById(R.id.imageResultado);
        TextView textoResultado = findViewById(R.id.textResultado);

        System.out.println( "Item selecionado: " + escolhausuario);
        int numero = new Random().nextInt(3); //0, 1 e 2
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        String opcaoApp = opcoes [numero];

        switch (opcaoApp){
            case "Pedra":
                imagemResultado.setImageResource(R.drawable.pedra);
                break;

            case "Papel":
                imagemResultado.setImageResource(R.drawable.papel);
                break;

            case "Tesoura":
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;

                // Configuração de imagens que irão aprecer quando houver o evento click
        }

        if (
                (opcaoApp == "Tesoura" && escolhausuario == "Papel") ||
                (opcaoApp == "Papel" && escolhausuario == "Pedra") ||
                (opcaoApp == "Pedra" && escolhausuario == "Tesoura")

        ) {
            textoResultado.setText("Você perdeu :( ");

        } else if (

                (escolhausuario == "Tesoura" && opcaoApp == "Papel") ||
                (escolhausuario == "Papel" && opcaoApp == "Pedra") ||
                (escolhausuario == "Pedra" && opcaoApp == "Tesoura")
        ){
            textoResultado.setText("Você ganhou :D");

        }else {
            textoResultado.setText("Empatamos ;)");

        }


    }

}
