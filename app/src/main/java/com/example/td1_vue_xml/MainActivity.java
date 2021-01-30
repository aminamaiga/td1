package com.example.td1_vue_xml;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    private CheckBox linux, macos, windows;
    private Button button2;
    TextView visibleTexxtView;

    //2) Ajoutez le code nécessaire pour la saisie d’un texte
    public void addTextView(){
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        TextView tv = new TextView(this);
        tv.setText("Hello, Android");

        EditText editText = new EditText(this);
        editText.setHeight(200);

        linearLayout.addView(tv);
        linearLayout.addView(editText);
        setContentView(linearLayout);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // addTextView();

        //Exercice 4 : Evènements utilisateurs
        button = (Button)findViewById(R.id.mainbutton2);
        visibleTexxtView = (TextView)findViewById(R.id.visibleTextView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Message Bouton 1", Toast.LENGTH_LONG).show();
                visibleTexxtView.setText(R.string.visibleText);
            }
        });

        //Exercice 5 Différentes vues et actions
        addListenerOnChkWindows();
        addListenerOnButton();

    }

    public void addListenerOnChkWindows() {
        windows = (CheckBox) findViewById(R.id.windows_option);
        windows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    Toast.makeText(MainActivity.this,"Bro, try Linux :)", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void addListenerOnButton() {
        linux = (CheckBox) findViewById(R.id.linux_option);
        macos = (CheckBox) findViewById(R.id.macos_option);
        windows = (CheckBox) findViewById(R.id.windows_option);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer result = new StringBuffer();
                result.append("Linux check : ").append(linux.isChecked());
                result.append("\nMac OS check : ").append(macos.isChecked());
                result.append("\nWindows check :").append(windows.isChecked());
                Toast.makeText(MainActivity.this, result.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}