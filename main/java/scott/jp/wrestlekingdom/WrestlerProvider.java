package scott.jp.wrestlekingdom;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Jay on 19-03-2017.
 */

public class WrestlerProvider extends ContentProvider {
    public final static String DB_Name="wrassle.db";
    public final static int DB_Version= 3;
    public final static Uri Content_URI= Uri.parse("content://scott.jp.wrestlekingdom/wrestler");
    public final static String Wres_Table="wrestler";

    public final static String Wres_Id="wrestler_id";
    public final static String Wres_Name="name";
    public final static String Wres_Nick="nickname";
    public final static String Wres_Home="home";
    public final static String Wres_Move1="moveA";
    public final static String Wres_Move2="moveB";
    public final static String Wres_Move3="moveC";
    public final static String Wres_Move4="moveD";
    public final static String Wres_Sig="signature";
    public final static String Wres_SigVid="signature_vid";
    public final static String Wres_Finish="finisher";
    public final static String Wres_FinishVid="finisher_vid";
    public final static String Wres_PicID="picture_id";

    private SQLiteDatabase wrasDB;
    class WrestlerHelper extends SQLiteOpenHelper{

        public WrestlerHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String creation="create table if not exists wrestler( wrestler_id integer primary key" +
                    " autoincrement,name text,nickname text,home text,moveA text,moveB text,moveC text,moveD text,signature text," +
                    "signature_vid integer,finisher text,finisher_vid integer,picture_id integer)";
            db.execSQL(creation);
            Log.i("WrestlerHelper","The Table Has Been Created");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

    @Override
    public boolean onCreate() {
        WrestlerHelper wh=new WrestlerHelper(getContext(),DB_Name,null,DB_Version);
        wrasDB=wh.getWritableDatabase();
        if(wrasDB!=null)
            return true;
            else
            return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
       Cursor crsr=wrasDB.query(Wres_Table,projection,selection,selectionArgs,null,null,sortOrder);

        return crsr;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {


        long rid=wrasDB.insert(Wres_Table,null,values);
        Log.i("WrestlerHelper","Record Inserted");
      return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;

    }





}
