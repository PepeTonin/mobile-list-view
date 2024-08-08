package com.example.list_view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listLocais;

    private String[] materias = {
            "Algoritmo e Estruturas de Dados",
            "Banco de Dados 1",
            "Banco de Dados 2",
            "Desenvolvimento Web 1",
            "Desenvolvimento Web 2",
            "Interação Humano-Computador",
            "Desenvolvimento Mobile",
            "Gestão de Projetos",
            "Sistemas Embarcados",
            "Segurança e Auditoria de Sistemas",
            "Engenharia de Software",
            "Ciência de Dados",
            "Programação Orientada a Objetos",
            "Redes de Computadores",
            "Arquitetura de Computadores",
            "Inteligência Artificial",
            "Computação em Nuvem",
            "Programação Funcional",
            "Desenvolvimento de Software para Internet das Coisas (IoT)",
            "Matemática Discreta",
            "Estatística e Probabilidade"
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listLocais = findViewById(R.id.listLocais);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                materias
        );

        listLocais.setAdapter(adaptador);

        listLocais.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String itemSelecionado = listLocais.getItemAtPosition(position).toString();

                        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                        alertDialog.setTitle("Fazer matrícula");
                        alertDialog.setMessage("Deseja mesmo fazer matrícula na matéria " + itemSelecionado + "?");
                        alertDialog.setCancelable(true);
                        alertDialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String mensagem = "Sua matrícula em " + itemSelecionado + " foi efetivada!";
                                Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_LONG).show();
                            }
                        });
                        alertDialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        alertDialog.create();
                        alertDialog.show();
                    }
                }
        );
    }
}