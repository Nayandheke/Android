package app.vs.college;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private final List<UserData> userDataList;

    public CustomListAdapter(List<UserData> userDataList) {
        this.userDataList = userDataList;
    }

    @Override
    public int getCount() {
        return userDataList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.list_item,parent,false);
            TextView name = convertView.findViewById(R.id.name);
            TextView email = convertView.findViewById(R.id.email);
            TextView height = convertView.findViewById(R.id.height);

            UserData userData = userDataList.get(position);
            name.setText(userData.getName());
            email.setText(userData.getEmail());
            height.setText(String.valueOf(userData.getHeight()));
            return convertView;
        } else {
            return convertView;
        }
    }
}
