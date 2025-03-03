package app.vs.college;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.UserDataHolder> {

    private final List<UserData> UserDataList;

    public RecyclerViewAdapter(List<UserData> userDataList) {
        this.UserDataList = userDataList;
    }
    @NonNull
    @Override
    public UserDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.list_item,parent,false
        );
        return (new UserDataHolder(view));
    }

    @Override
    public void onBindViewHolder(@NonNull UserDataHolder holder, int position) {
        UserData userData = UserDataList.get(position);
        holder.name.setText(userData.getName());
        holder.email.setText(userData.getEmail());
        holder.height.setText(String.valueOf(userData.getHeight()));
    }

    @Override
    public int getItemCount() {
        return UserDataList.size();
    }

    public class UserDataHolder extends RecyclerView.ViewHolder {
        public TextView name,email,height;
        public UserDataHolder(View convertView) {
            super(convertView);
            name = convertView.findViewById(R.id.name);
            email = convertView.findViewById(R.id.email);
            height = convertView.findViewById(R.id.height);
        }
    }
}
