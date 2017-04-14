package scott.jp.wrestlekingdom;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Type;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
ContentResolver cr;
    TextView tv;
    Typeface tf;
    SharedPreferences sp;
    SharedPreferences.Editor se;
    Button stt;
    Wrestler w1= new Wrestler("Zack Ryder","Long Island Iced Z","Long Island, NY","Neckbreaker","450 Splash","Dropkick Splash","WhipperSnapper","Rough Ryder","ElBro Drop",R.mipmap.broken,R.raw.roughryder,R.raw.elbrodrop);
    //here are the lists of the wrestleres attributes
    String names[] = {" Kenny Omega", "Zack Ryder", "John Cena", "Shane McMahon", "Roman Reigns", "Hiroshi Tanahashi", "Kazuchika Okada", "Matt Hardy", "AJ Styles",
            "The Undertaker","Diamond Dallas Page", "Brock Lesnar", "Shawn Michaels","Scott Steiner"};


    String nickname[] = {"The Cleaner", "Long Island Iced Z", "Cenation", "Shane O Mac",
            "THE BIG DOG", "The Ace", "The Rainmaker", "Mr. Broken Brilliance",
            "The Phenomenal One", "The Phenom", "DDP", "The Beast Incarnate",
            "The ShowStopper", "THE BIG POPPA PUMP"};


    String hometown[] = {"Winnipeg Can", "Long Island NY" ,"Newbury MA", "Greenwich CA","Florida", "Gifu", "Tokyo", "North Carolina", "Georgia"," Death Valley",
            "Atlanta", "Saskatchewan", "Texas", "Achworth"};
    //spinout powerbomb
    //dropkick splash
    //tombstone piledriver
    String move1[]={"Hadouken","Neckbreaker","Spinout Powerbomb"};
    //end the list
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setBackgroundDrawableResource(R.mipmap.wk2);
        sp=getSharedPreferences("button",MODE_PRIVATE);
        int vis=sp.getInt("visb",View.VISIBLE);
        stt=(Button)findViewById(R.id.button4);
        //noinspection WrongConstant
        stt.setVisibility(vis);

        cr=getContentResolver();
        tv=(TextView)findViewById(R.id.textView);
         tf= Typeface.createFromAsset(getAssets(),"jim.ttf");
         tv.setTypeface(tf);

   }
    public void onLoad(View v){
        sp=getSharedPreferences("button",MODE_PRIVATE);
        se=sp.edit();
        loadData(w1);
        se.putInt("visb",View.INVISIBLE);
        stt.setVisibility(View.INVISIBLE);
        se.commit();




    }
    public void onStart(View v1){
       Intent vid=new Intent(this,BattleActivity.class);
           // vid.putExtra("Name",w1.getName());
        //vid.putExtra("Player",w1);
        startActivity(vid);

    }
    public void onTermine(View v){
        finish();
    }
    public void loadData( Wrestler wres){

        ContentValues cv=new ContentValues();
        cv.put(WrestlerProvider.Wres_Name,wres.getName());
        cv.put(WrestlerProvider.Wres_Nick,wres.getNickName());
        cv.put(WrestlerProvider.Wres_Home,wres.getHomeState());
        cv.put(WrestlerProvider.Wres_Move1,wres.getMov1());
        cv.put(WrestlerProvider.Wres_Move2,wres.getMov2());
        cv.put(WrestlerProvider.Wres_Move3,wres.getMov3());
        cv.put(WrestlerProvider.Wres_Move4,wres.getMov4());
        cv.put(WrestlerProvider.Wres_Sig,wres.getSignature());
        cv.put(WrestlerProvider.Wres_Finish,wres.getFinisher());
        cv.put(WrestlerProvider.Wres_SigVid,wres.getSignatureVidID());
        cv.put(WrestlerProvider.Wres_FinishVid,wres.getFinisherVidID());
        cv.put(WrestlerProvider.Wres_PicID,wres.getPicID());
        cr.insert(WrestlerProvider.Content_URI,cv);
        Toast.makeText(this,wres.getName()+" Has Been Loaded",Toast.LENGTH_LONG).show();
    }


}
