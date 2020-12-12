package jesuitas.dam.listapeliculas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private final LinkedList<String> TituloPeliculas = new LinkedList<>();
    private final LinkedList<String> genero = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerview);

        TituloPeliculas.addLast("Matrix Reloaded");
        TituloPeliculas.addLast("Cosmos");
        TituloPeliculas.addLast("El Golpe");
        TituloPeliculas.addLast("Abre los Ojos");
        TituloPeliculas.addLast("Blade Runner");
        TituloPeliculas.addLast("Cierra el alma");
        TituloPeliculas.addLast("El primer beso");
        TituloPeliculas.addLast("Buscando a Nemo");
        TituloPeliculas.addLast("Hable con ella");

        genero.addLast("Comedia");
        genero.addLast("Drama");
        genero.addLast("Accion");
        genero.addLast("Accion");
        genero.addLast("Drama");
        genero.addLast("Infantil");
        genero.addLast("Romance");
        genero.addLast("Romance");
        genero.addLast("Romance");

        mAdapter = new WordListAdapter(this, TituloPeliculas, genero);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}