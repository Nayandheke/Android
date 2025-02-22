package app.vs.college;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

//        dateValues = findViewById(R.id.dataValues);
        String name = getIntent().getStringExtra("username");
        String password = getIntent().getStringExtra("password");
        int phone = getIntent().getIntExtra("phone",0);

//        dataValues.setText(name + "" + password + "" + phone);
        List<UserData> userDataList = new ArrayList<>();
        for(int i=0;i<10;i++) {
            userDataList.add(new UserData("name"+i,"email"+i,i,i));
        }

        listView = findViewById(R.id.listView);
        CustomListAdapter adapter = new CustomListAdapter(userDataList);
        listView.setAdapter(adapter);

    }
}
