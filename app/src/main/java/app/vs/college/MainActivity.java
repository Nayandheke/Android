package app.vs.college;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button login;
    private EditText editUsername, editPassword;

    private CheckBox checkBox;
    private RadioGroup radioGroup;

    private Spinner spinner;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main),(v,insets) -> {

            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        checkBox = findViewById(R.id.checkbox);
        radioGroup = findViewById(R.id.radioGroup);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(getApplicationContext(), "Checked delected", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Chechbox deselected", Toast.LENGTH_SHORT).show();
                }
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                String radioName = radioButton.getText().toString();
                Toast.makeText(MainActivity.this, radioName, Toast.LENGTH_SHORT).show();
            }
        });
        spinner = findViewById(R.id.spinner);

        /*ArrayAdapter<String> arrayAdapter =new ArrayAdapter<>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.countries));
        spinner.setAdapter(arrayAdapter);*/

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
               /* String selected = parent.getSelectedItem().toString();
                Toast.makeText(getApplicationContext(),
                        selected,Toast.LENGTH_SHORT).show();*/
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        List<UserData> userDataList = new ArrayList<>();
        for(int i=0;i<10;i++) {
            userDataList.add(new UserData("name"+i,"email"+i,i,i));
        }
/*        ArrayAdapter<UserData> userDataArrayAdapter = new ArrayAdapter<>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                userDataList);*/

        CustomArrayAdapter adapter = new CustomArrayAdapter(this,userDataList);
        spinner.setAdapter(adapter);



        login = findViewById(R.id.btnLogin);
        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);

        login.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        }));


    }

    public void loginUser() {
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

            Intent intent = new Intent(this, ListViewActivity.class);
            intent.putExtra("username", uName);
            intent.putExtra("password", pwd);
            intent.putExtra("phone", 982736);
            startActivity(intent);
        }
    }
}