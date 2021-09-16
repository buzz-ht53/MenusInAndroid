package com.buzz_ht.androidmenus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String s[]={"Option1","Option2","Option3","Option4"};
    ListView listView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listview);

        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,s);
        listView.setAdapter(arrayAdapter);
        registerForContextMenu(listView);

        button = findViewById(R.id.popupmenu);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this,button);
                popupMenu.inflate(R.menu.popupmenu);

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        switch(menuItem.getItemId()){

                            case R.id.quit:
                                Toast.makeText(getApplicationContext(), "Really?", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.activity:
                                Toast.makeText(getApplicationContext(), "Opening...", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater= getMenuInflater();
        menuInflater.inflate(R.menu.optionmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            
            case R.id.refer:
                Toast.makeText(getApplicationContext(),"Thank you for referring", Toast.LENGTH_LONG).show();
                break;
            case R.id.rate:
                Toast.makeText(getApplicationContext(),"Thank you for rating us", Toast.LENGTH_LONG).show();
                break;
            case R.id.about:
                Toast.makeText(getApplicationContext(),"About us!", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.contextmenu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){

            case R.id.contextoption1:
                Toast.makeText(getApplicationContext(), "Hey you", Toast.LENGTH_SHORT).show();
                break;

            case R.id.contextoption2:
                Toast.makeText(getApplicationContext(), "Arriving Somewhere", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }



}