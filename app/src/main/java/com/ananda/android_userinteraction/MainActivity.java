package com.ananda.android_userinteraction;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /**menambah komponen**/
    Spinner spinner;
    EditText editText;
    TextView textView;
    String label="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner_label);
        editText = findViewById(R.id.edit_input);
        textView = findViewById(R.id.textPhone);

        /**membuat dropdown lewat java**/
        ArrayAdapter<CharSequence> adapter=ArrayAdapter
                .createFromResource(this, R.array.labels, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        /**pengecekan**/
        if(spinner != null){
            spinner.setAdapter(adapter); /**diintegrasikan antara spinner dan adapternya**/

            /**untuk membuat user dapat memilih spinner: **/
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    label = adapterView.getItemAtPosition(i).toString();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }

    }

    /**untuk yang ditampilkan apa saja**/
    public void showText(View view) {
        String showString="Phone Number: "+label+" - "+editText.getText().toString();
        textView.setText(showString);

    }

    public void onRadioButtonClicked(View view) {
        /**mengecek radio button**/
        boolean checked = ((RadioButton)view).isChecked();
        /**cara mengecek radio button mana yg mau dicek menggunakan switch**/
        switch (view.getId()){
            case R.id.radio_p1:
                if(checked)
                    Toast.makeText(this, "Anda memilih Sate", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_p2:
                if(checked)
                    Toast.makeText(this, "Anda memilih Gudeg", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_p3:
                if(checked)
                    Toast.makeText(this, "Anda memilih Soto", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    public void showAlert(View view) {
        AlertDialog.Builder myAlertBuilder=new AlertDialog.Builder(this);
        myAlertBuilder.setTitle("Peringatan!!");
        myAlertBuilder.setMessage("Click Ok to continue or cancel to stop.");
        myAlertBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Anda memilih OK!", Toast.LENGTH_SHORT).show();
            }
        });
        myAlertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Anda memilih Cancel", Toast.LENGTH_SHORT).show();
            }
        });
        myAlertBuilder.show();
    }



    /**untuk deklarasi menu**/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    /**menerima pilihan saat menu tsb di klik**/
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_menu1:
                Toast.makeText(MainActivity.this, "Anda memilih Add Cart", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_menu2:
                Toast.makeText(MainActivity.this, "Anda memilih Update Cart", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_menu3:
                Toast.makeText(MainActivity.this, "Anda memilih Delete Cart", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}