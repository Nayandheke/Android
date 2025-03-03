package app.vs.college;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.GridView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {
    private ListView listView;
    private GridView gridView;
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
        gridView = findViewById(R.id.gridView);
        CustomListAdapter adapter = new CustomListAdapter(userDataList);
        listView.setAdapter(adapter);
        gridView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                UserData dataValue = userDataList.get(position);
                Toast.makeText(getApplicationContext(), "Item clicked" + dataValue.getEmail(),Toast.LENGTH_SHORT).show();

                startActivity(new Intent(getApplicationContext(),RecyclerViewActivity.class));
            }
        });

    }
}
