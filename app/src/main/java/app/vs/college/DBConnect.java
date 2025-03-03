//package app.vs.college;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//import android.os.Build;
//import android.util.Log;
//import androidx.annotation.RequiresApi;
//import java.util.ArrayList;
//import java.util.List;
//
//public class DBConnect extends SQLiteOpenHelper {
////    private String DB_NAME = "db_student";
//    public DBConnect(Context context){
//        super(context,"db_student",null,1);
//    }
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        db = this.getWritableDatabase();
//        String query = "create table user(id int primary key AUTOINCREMENT,"+
//                "name varchar(38),email varchar(30), height decimal(4,3))";
//        db.execSQL(query);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//
//    }
//
////    public void insertData(UserData userData) {
////        SQLiteDatabase db = this.getWritableDatabase();
////        for(UserData userData:userDataList){
////            ContentValues contentValues = new ContentValues();
////            contentValues.put("name", userData.getName());
////            contentValues.put("email", userData.getEmail());
////            contentValues.put("height", userData.getHeight());
////            long value = db.insert("user", null,contentValues);
////            Log.e("data inserted", value + "");
////        }
////    }
//
//    public List<UserData> retrieveUserList() {
//        List<UserData> userDataList = new ArrayList<>();
//        String query = "select * from user";
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(query, null);
//        if(cursor.moveToFirst()) {
//            do {
//                String name = cursor.getColumnName(0);
//                String email = cursor.getColumnName(1);
//                float height = Float.parseFloat(cursor.getColumnName(2));
//                userDataList.add(new UserData(name,email,height));
//            } while (cursor.moveToNext());
//        }
//        cursor.close();
////        return UserDataList();
//    }
//}
