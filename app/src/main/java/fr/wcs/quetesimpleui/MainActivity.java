package fr.wcs.quetesimpleui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView header;
    CheckBox checkBox;
    EditText firstName;
    EditText familyName;
    Button button;
    String texteString = ("Félicitations Mr/Mme" + " " + firstName + " " + familyName);
    String texteString2 = ("Veuillez indiquer votre nom et/ou prénom");
    String firstNameContent;
    String familyNameContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox.setOnClickListener(this);
        button = (Button) findViewById(R.id.button);
        firstName = (EditText) findViewById(R.id.firstName);
        familyName = (EditText) findViewById(R.id.familyName);
        firstNameContent = firstName.getText().toString();
        familyNameContent = familyName.getText().toString();

        firstName.setEnabled(false);
        familyName.setEnabled(false);
        button.setEnabled(false);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstNameContent = firstName.getText().toString();
                familyNameContent = familyName.getText().toString();
                texteString = ("Félicitations Mr/Mme" + " " + firstNameContent + " " + familyNameContent + " !");
                texteString2 = ("Veuillez indiquer votre nom et/ou prénom");
                if ((firstNameContent.equals("")) || (familyNameContent.equals(""))) {
                    Toast.makeText(getApplicationContext(), texteString2, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), texteString, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.checkBox:
                if (checkBox.isChecked()) {
                    firstName.setEnabled(true);
                    familyName.setEnabled(true);
                    button.setEnabled(true);
                } else {
                    firstName.setEnabled(false);
                    familyName.setEnabled(false);
                    button.setEnabled(false);
                }
                break;
        }
    }
}