package app.vs.college;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private Button login;
    private EditText editUsername, editPassword;

    private CheckBox checkBox;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        checkBox = findViewById(R.id.checkBox);
        radioGroup = findViewById(R.id.radioGroup);

        checkBox.setOnCheckedListner(new CompoundButton.OnCheckedChangeListner(){
            @Override
            public void onChecked(Com)
        })

        login = findViewById(R.id.btnLogin);
        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
    }

    public void loginUser(View v) {
        String uName = editUsername.getText().toString();
        String pwd = editPassword.getText().toString();
        if(uName.isEmpty()) {
            editUsername.setError(getString(R.string.errorText));
        }else if(pwd.isEmpty()) {
            editPassword.setError(getString(R.string.errorText));
        }else{
            Log.i("LoginInfo", uName +" "+ pwd);
            Toast.makeText(this,uName +" "+ pwd,Toast.LENGTH_SHORT).show();
            Snackbar.make(login,uName + " " + pwd,Snackbar.LENGTH_SHORT).show();
        }
    }
}