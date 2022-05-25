package br.ufjf.dcc196.delberss.exercicio4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextName;
        TextView mensagem;
        Button buttonAdicionar;
        Button buttonLimpar;
        Button buttonSortear;


        List<String> usuarios = new ArrayList<String>();


        editTextName = findViewById(R.id.editTextName);
        mensagem = findViewById(R.id.textViewMensagem);

        buttonAdicionar = findViewById(R.id.buttonAdicionar);
        buttonLimpar = findViewById(R.id.buttonLimpar);
        buttonSortear = findViewById(R.id.buttonSortear);



        buttonAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextName.getText().toString();
                if(nome.length() < 1){
                    mensagem.setText(
                            String.format(
                                    "Digite um nome"
                            )
                    );
                }
                else{
                    usuarios.add(nome);
                    editTextName.setText("");
                }

            }
        });

        buttonLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuarios.clear();
            }
        });

        buttonSortear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(usuarios.size() < 1){
                    mensagem.setText(
                            String.format(
                                    "Lista vazia"
                            )
                    );
                }
                else{
                    Random random = new Random();
                    int valor = random.nextInt(usuarios.size());

                    mensagem.setText(
                            String.format(
                                    "O sorteado foi %s", usuarios.get(valor)
                            )
                    );
                }


            }
        });
    }

}