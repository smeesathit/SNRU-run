package snru.meesathit.sooksathit.snrurun;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private MyManage myManage;
    private ImageView imageView;
    private EditText userEditText, passwordEditText;
    private String userString, passwordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView6);
        userEditText = (EditText) findViewById(R.id.editText);
        passwordEditText = (EditText) findViewById(R.id.editText2);



        myManage = new MyManage(MainActivity.this);

        // Test add user
        //myManage.addUser("Meen", "Disney", "12345", "1");

        // Delete all from table
        deleteAllSQLite();

        // Synchronize
        MySynchronize mySynchronize = new MySynchronize();
        mySynchronize.execute();

        // show logo
        Picasso.with(MainActivity.this)
                .load("http://swiftcodingthai.com/snru/image/logo_snru.png")
                .resize(200,250)
                .into(imageView);

    } // End onCreate method

    public void clickSignInView(View view){
        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();

        // Check empty input
        if (userString.equals("") || passwordString.equals("") ) {

            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this, "มีช่องว่าง", "กรุณากรอกทุกช่องคะ");

        } else {



        }

    }

    // Create Inner Class
    public class MySynchronize extends AsyncTask<Void, Void, String> {


        @Override
        protected String doInBackground(Void... voids) {

            try {
                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url("http://swiftcodingthai.com/snru/get_user.php").build();
                Response response = okHttpClient.newCall(request).execute();

                return response.body().string();
            } catch (Exception e) {
                return null;
            }
            //return null;
        } //End method doInBackground

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Log.d("Snru", "JSON == " + s);

            try {
                JSONArray jsonArray = new JSONArray(s);

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String  strName = jsonObject.getString(MyManage.column_name);
                    String  strUser = jsonObject.getString(MyManage.column_user);
                    String  strPassword = jsonObject.getString(MyManage.column_password);
                    String  strAvata = jsonObject.getString(MyManage.column_avata);

                    myManage.addUser(strName, strUser, strPassword, strAvata);

                } // end for
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    } // End Inner Class MySynchronize


    private void deleteAllSQLite() {
        // MODE_PRIVATE = delete only
        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name, MODE_PRIVATE, null);

        sqLiteDatabase.delete(MyManage.user_table, null, null);

    }


    public void clickSignUpMain(View view){
        startActivity(new Intent(MainActivity.this, SignUp.class));
    } // End clickSignUpMain method
} // End main class
