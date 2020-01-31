package com.example.listedeplanetes;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Planete> planeteList = new ArrayList<>();
        initList(planeteList);
        AndroidAdapter adapter = new AndroidAdapter(this,R.layout.planete_item_list,planeteList);
        final ListView list = findViewById(R.id.maListeView);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                Planete selectedItem = (Planete) adapter.getItemAtPosition(position);
                Log.v("ListPersonnalisée", "Element selectionné : " + selectedItem.getName());
                Toast toaster = Toast.makeText(getApplicationContext(),"Element selectionné : " + selectedItem.getName(),Toast.LENGTH_SHORT);
                toaster.show();
            }
        });

    }

    private void initList(ArrayList<Planete> planeteList){
        Planete planete= new Planete("Mercure","0,4 UA",R.drawable.mercure);
        planeteList.add(planete);

        planete= new Planete("Vénus","0,7 UA",R.drawable.venus);
        planeteList.add(planete);

        planete= new Planete("Terre","1 UA",R.drawable.terre);
        planeteList.add(planete);

        planete= new Planete("Mars","1,5 UA",R.drawable.mars);
        planeteList.add(planete);

        planete= new Planete("Jupiter","5,2 UA",R.drawable.jupiter);
        planeteList.add(planete);

        planete= new Planete("Saturne","9,5 UA",R.drawable.saturne);
        planeteList.add(planete);

        planete= new Planete("Uranus","19,6 UA",R.drawable.uranus);
        planeteList.add(planete);

        planete= new Planete("Neptune","30 UA",R.drawable.neptune);
        planeteList.add(planete);



    }
}
