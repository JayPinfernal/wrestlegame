package scott.jp.wrestlekingdom;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

/**
 * Created by Jay on 23-03-2017.
 */

public class VideoActivity extends AppCompatActivity {
    VideoView vv; ContentResolver cr;
    int vidID;
    String Name;
    TextView textView; Wrestler ws;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_trial);
        Intent ret=getIntent();
        vv=(VideoView)findViewById(R.id.videoView);
        String wresname=ret.getStringExtra("Name");
            cr=getContentResolver();
        textView=(TextView)findViewById(R.id.textView2);
        ws=(Wrestler)ret.getSerializableExtra("Player");
        String[] columns={WrestlerProvider.Wres_FinishVid,WrestlerProvider.Wres_Finish};
        String where=WrestlerProvider.Wres_Name+"='"+wresname+"'";
        Cursor c=cr.query(WrestlerProvider.Content_URI,columns,where,null,null);
        if(c!= null){
            if(c.moveToFirst())
            {
                vidID=c.getInt(0);
                Name=c.getString(1);

            }
        }


        String ul="android.resource://scott.jp.wrestlekingdom/"+vidID;
        Uri ui= Uri.parse(ul);
        vv.setVideoURI(ui);
        vv.start();
        Toast.makeText(this,"You are Watching "+ul,Toast.LENGTH_LONG).show();
        textView.setText(ws.getFinisher());
    }
}
