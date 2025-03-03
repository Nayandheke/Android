package app.vs.college;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class UserDataForm extends AppCompatActivity {
//    private DBConnect dbConnect;
    private AppCompatEditText name,email,height;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_data_form);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
//        dbConnect = new DBConnect(this);
        name = findViewById(R.id.editName);
        email = findViewById(R.id.editEmail);
        height = findViewById(R.id.editHeight);

        PostAsyncTask postAsyncTask = new PostAsyncTask(new PostCallback(){

            @Override
            public void onSuccess(List<Posts> postsList) {
                //TODO make list or insert to database
                for (Posts post : postsList) {
                    Log.e("Post Data", "ID: " + post.getTitle() +
                            ", UserID: " + post.getId() +
                            ", Title: " + post.getTitle() +
                            ", Body: " + post.getBody());
                }
            }

            @Override
            public void onFailure(String error) {
                Toast.makeText(getApplicationContext(),error,Toast.LENGTH_SHORT).show();
            }
        });
        postAsyncTask.execute();
    }

    public void insertData(View view) {
        String s1 = name.getText().toString();
        String s2 = email.getText().toString();
        float h1 = Float.parseFloat(height.getText().toString());
        UserData userData = new UserData(s1,s2,h1);
//        dbConnect.insertData(userData);
    }
}