package app.vs.college;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PostAsyncTask extends AsyncTask<String, String, String> {
    private PostCallback callback;
    public PostAsyncTask(PostCallback callback) {
        this.callback = callback;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.e("on pre execute","on ui thread");
    }
    @Override
    protected String doInBackground(String... string) {
        String url = "https://jsonplaceholder.typicode.com/posts";
        String datas = "";
        try {
            URL url1 = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection)
                    url1.openConnection();
            Log.e("connection","url connection established");
            InputStream inputStream = httpURLConnection.getInputStream();
            InputStreamReader isw = new InputStreamReader(inputStream);
            int data = isw.read();
            while(data != -1){
                datas += (char) data;
                data = isw.read();
            }
        }catch(Exception e){
            callback.onFailure(e.toString());
        }
        return datas;
    }
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.e("post datas",s);
        try {
            JSONArray jsonArray = new JSONArray(s);
            List<Posts> postsList = new ArrayList<>();
            for(int i=0; i<jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                String title = object.getString("title");
                String body = object.getString("body");
                int userId = object.getInt("userId");
                int id = object.getInt("id");
                Posts posts = new Posts(id,userId,title,body);
//                Log.e("json parsed","title:" +title+" "+"body:" +body);
                postsList.add(posts);
            }
            callback.onSuccess(postsList);
        } catch (Exception e) {
            callback.onFailure(e.toString());
        }

    }
}
