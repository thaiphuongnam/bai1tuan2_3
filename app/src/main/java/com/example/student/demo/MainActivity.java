package com.example.student.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editTextMa, editTextHoTen;
    RadioButton radioButtonNam, radioButtonNu;
    Button buttonAdd;
    ImageButton imageButtonDelete;
    ListView listViewNhanVien;
    ArrayList<NhanVien> nhanVienArrayList;
    ArrayAdapter<NhanVien> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextHoTen = findViewById(R.id.editTextHoTen);
        editTextMa = findViewById(R.id.editTextMa);
        radioButtonNam = findViewById(R.id.radioButtonNam);
        radioButtonNu = findViewById(R.id.radioButtonNu);
        buttonAdd = findViewById(R.id.buttonAdd);
        imageButtonDelete = findViewById(R.id.imageButtonDelete);
        listViewNhanVien = findViewById(R.id.listViewNhanVien);

        nhanVienArrayList = new ArrayList<>();
        arrayAdapter = new NhanVienArrayAdapter(MainActivity.this, R.layout.listview_item, nhanVienArrayList);
        listViewNhanVien.setAdapter(arrayAdapter);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(editTextMa.getText().toString());
                String name = editTextHoTen.getText().toString();
                boolean isMale = false;
                if (radioButtonNam.isChecked())
                    isMale = true;
                nhanVienArrayList.add(new NhanVien(id, name, isMale));
                arrayAdapter.notifyDataSetChanged();
                editTextHoTen.setText("");
                editTextMa.setText("");
                editTextMa.requestFocus();
            }
        });

        imageButtonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = nhanVienArrayList.size() - 1; i >= 0; i--) {
                    View viewItem = listViewNhanVien.getChildAt(i);
                    CheckBox checkBox = viewItem.findViewById(R.id.checkBox);
                    if (checkBox.isChecked()) {
                        nhanVienArrayList.remove(i);
                    }
                }
                arrayAdapter.notifyDataSetChanged();
            }
        });

    }


    }
