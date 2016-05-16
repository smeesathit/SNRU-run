package snru.meesathit.sooksathit.snrurun;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SignUp extends AppCompatActivity {
    // Variable declaration
    private EditText nameEditText;
    private EditText userEditText;
    private EditText passwordEditText;

    private RadioGroup radioGroup;

    private RadioButton choice1RadioButton, choice2RadioButton, choice3RadioButton, choice4RadioButton, choice5RadioButton;

    private String nameString, userString, passwordString, avatarString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        bindWidget();


    } // End method onCreate

    private void bindWidget() {
        nameEditText = (EditText) findViewById(R.id.nameEditText);
        userEditText = (EditText) findViewById(R.id.userEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);

        radioGroup = (RadioGroup) findViewById(R.id.ragAvatar);

        choice1RadioButton = (RadioButton) findViewById(R.id.radioButton);
        choice2RadioButton = (RadioButton) findViewById(R.id.radioButton2);
        choice3RadioButton = (RadioButton) findViewById(R.id.radioButton3);
        choice4RadioButton = (RadioButton) findViewById(R.id.radioButton4);
        choice5RadioButton = (RadioButton) findViewById(R.id.radioButton5);
    }

    public void clickSignUpSign(View view) {
        nameString = nameEditText.getText().toString().trim();
        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();

        // Check empty input
        if (nameString.equals("") || userEditText.equals("") || passwordEditText.equals("")) {
            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this, "Empty Box!", "Fill all boxes!");
        } else {
        }



    } // End method clickSignUpSign
} // End class SignUp
