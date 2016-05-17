package snru.meesathit.sooksathit.snrurun;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private MyManage myManage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myManage = new MyManage(MainActivity.this);

        
    } // End onCreate method

    public void clickSignUpMain(View view){
        startActivity(new Intent(MainActivity.this, SignUp.class));
    } // End clickSignUpMain method
} // End main class
