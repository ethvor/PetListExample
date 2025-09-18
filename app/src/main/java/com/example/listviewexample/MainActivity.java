package com.example.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import model.Pet;

public class MainActivity extends AppCompatActivity {

    ListView petListWidget;
    ArrayList<Pet> pets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random rand = new Random();
        pets = new ArrayList<>();

        pets.add(new Pet("Kenny", "Husky", 15));
        pets.add(new Pet("John", "Bullgod", 900));
        pets.add(new Pet("Lola", "Yorkie", 10));
        pets.add(new Pet("Macy", "Golden Retriever", 5));
        pets.add(new Pet("Charles", "Schnauzer", 11));


        petListWidget = findViewById(R.id.petListWidget);

        int selection = 3;
        populateListView(selection);
    }

    private void populateListView(int selection) {
        switch (selection) {
            case 1:
                useStringResource();
                break;
            case 2:
                usingDataArray();
                break;
            case 3:
                System.out.println("Using 2 lines start");
                usingTwoLines();
                System.out.println("Using 2 lines done");
                break;

        }
    }

    private void usingTwoLines(){

        List<HashMap<String, String>> data = new ArrayList<>();

        for (Pet p: pets) {
            HashMap<String, String> current = new HashMap<>();
            current.put("name", p.getName());
            current.put("breed", p.getBreed());
            data.add(current);
        }

        SimpleAdapter adapter = new SimpleAdapter(
                this,
                data,
                android.R.layout.simple_list_item_2,
                new String[]{"name", "breed"},
                new int[]{android.R.id.text1,
                        android.R.id.text2});

        petListWidget.setAdapter(adapter);
    }

    /**
     * This method populates the list view using a string resource containing
     * the content of a strings array resource
     */
    private void useStringResource() {
        String [] contents = getResources().getStringArray(R.array.breeds);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, contents);
        petListWidget.setAdapter(adapter);

    }

    /**
     * This method populates the list view using a string resource containing the list of a data array
     */
    private void usingDataArray() {
        ArrayAdapter<Pet> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pets);
        petListWidget.setAdapter(adapter);


    }
}