package scott.jp.wrestlekingdom;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


/**
 * Created by Jay on 06-04-2017.
 */

public class BattleActivity extends Activity {
    Wrestler w1,w2;
    static int hp1=100,hp2=100;
    static int ppm1=10,ppm2=10,ppm3=10,ppm4=10;
    static int gauge=0;
    Button m1,m2,m3,m4,con,fin,sig;
    TextView hv1,hv2,gv1,c1;
    ImageView iv1,iv2;
    VideoView vv;
    int comval;
    MediaPlayer mp;
    Random r1,r2; int lc=0,uc;
    Typeface tf;

    ArrayList<String> commen=new ArrayList(Arrays.asList("Mauro","Maggle","Corey","JBL","JR","Tom","King"));
    ArrayList<String> enemymoves;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.battle_ui);
        Intent ret=getIntent();
        w1= new Wrestler("Zack Ryder","Long Island Iced Z","Long Island, NY","Neckbreaker","450 Splash","Dropkick Splash","Whipper" +
                "Snapper","Rough Ryder","Tombstone" +
                " Piledriver",R.mipmap.www,R.raw.roughryder,R.raw.elbrodrop);
        w2= new Wrestler("Kenny Omega","The Cleaner","Winnipeg, Canada","Hadouken","Tiger Suplex","Moonsault","Croyt's " +
                "Wrath","One Winged Angel","V-Trigger",R.mipmap.omega,R.raw.owa,R.raw.vtrig);
        enemymoves=new ArrayList<>(Arrays.asList(w2.getMov1(),w2.getMov2(),w2.getMov3(),w2.getMov4()));

        //Button Identification and setting visibility
        m1=(Button)findViewById(R.id.move1);
        m2=(Button)findViewById(R.id.move2);
        m3=(Button)findViewById(R.id.m3);
        m4=(Button)findViewById(R.id.m4);
        con=(Button)findViewById(R.id.con);
        fin=(Button)findViewById(R.id.finisher);
        fin.setText(w1.getFinisher());
        sig=(Button)findViewById(R.id.signature);
        sig.setText(w1.getSignature());
        m1.setText(w1.getMov1());
        m2.setText(w1.getMov2());
        m3.setText(w1.getMov3());
        m4.setText(w1.getMov4());
        con.setVisibility(View.INVISIBLE);
        fin.setVisibility(View.INVISIBLE);
        sig.setVisibility(View.INVISIBLE);


        //TextView (Label) Identification and Declaration
        hv1=(TextView)findViewById(R.id.hplabel1);
        hv2=(TextView)findViewById(R.id.hplabel2);
        c1=(TextView)findViewById(R.id.commentary1);
        gv1=(TextView)findViewById(R.id.gaugebar);
        //typeface (Setting font)
        tf=Typeface.createFromAsset(getAssets(),"jim.ttf");
        hv1.setTypeface(tf);
        hv2.setTypeface(tf);
        uc=commen.size();
        c1.setTypeface(tf);
        //setting initial values
        r1=new Random();
        comval=r1.nextInt(uc-lc)+lc;

        c1.setText(commen.get(comval)+":- Welcome !!! To Wrestlekingdom.");

        hv1.setText(w1.getName()+":- "+hp1);
        hv2.setText(w2.getName()+":- "+hp2);
        gv1.setText("Gauge is Now :-"+gauge);

        //setting the profile images
        iv1=(ImageView)findViewById(R.id.imageView);
        iv2=(ImageView)findViewById(R.id.imageView2);
        iv1.setImageResource(w1.getPicID());
        iv2.setImageResource(w2.getPicID());
        //set the videoview
        vv=(VideoView)findViewById(R.id.battlevid);


    }
    int returnDamage(){

        Random ran1,ran2;
        ran1=new Random();
        ran2=new Random();
        uc=commen.size();
        comval=r1.nextInt(uc-lc)+lc;
         int totdam = 0;
        int basedam=ran1.nextInt(3)+5;
        int multiplier=ran2.nextInt(3);
        if(multiplier==0)
        {

            toasty(commen.get(comval)+":- They Boo Who They cheer and cheer who they boo");
            toasty(commen.get(3)+":- HA HA I LOVE IT MAGGLE");

            totdam=0;
        }
        if(multiplier==1){
            toasty(commen.get(comval)+":- Move Was Connected and hit hard");
            totdam=basedam*multiplier;
        }
        if(multiplier==2){
            toasty(commen.get(comval)+":- This Is Awesome. He has hit hard.");

               toasty(commen.get(comval)+":- That must have hurt the opponent hard.");
            totdam=basedam*multiplier;
        }
        return totdam;
    }


    public void doMoveA(View v1){
        if(gauge>=100)
            fin.setVisibility(View.VISIBLE);
            doDam(w1.getMov1());
        ppm1--;
        Toast.makeText(this,"No Of Tries to use "+w1.getMov1()+"is "+ppm1,Toast.LENGTH_LONG).show();
       // Toast.makeText(this,commen.get(comval)+":- "+w2.getName()+"Has Used "+enemymoves.get(enval),Toast.LENGTH_LONG).show();
        //Toast.makeText(this,commen.get(comval)+":- "+w1.getName()+"Has Used "+w1.getMov1(),Toast.LENGTH_LONG).show();

    }
     public void doDam(String m){
         Handler hand=new Handler();
         comval=r1.nextInt(commen.size()-lc)+lc;
         r2=new Random();
         int enval=r2.nextInt(enemymoves.size()-lc)+lc;
         toasty(commen.get(comval)+":- "+w1.getName()+"Has Used "+m);
         final int dam=returnDamage();
         hp2=hp2-dam;
         toasty(commen.get(2)+":- "+w2.getName()+" Has Lost "+dam+" Health");

         gauge+=10;

         toasty(commen.get(comval)+":- "+w2.getName()+"Has Used "+enemymoves.get(enval));
         final int dam2=returnDamage();
         hp1=hp1-dam2;
         toasty(commen.get(2)+":- "+w1.getName()+" Has Lost "+dam2+" Health");
         hand.postDelayed(new Runnable() {
             @Override
             public void run() {
                 hv2.setText(w2.getName()+":- "+hp2);
                 gv1.setText("Gauge is Now :-"+gauge);
                 hv1.setText(w1.getName()+":- "+hp1);

                 if(dam==0||dam2==0){
                     mp=MediaPlayer.create(getApplicationContext(),R.raw.botcha);
                     mp.start();
                 }
             }
         },14010l);

     }

    public void gaugeHack(View V){
        gauge=gauge+200;
        Toast.makeText(this,"Cheat Activated you hack",Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"I know who you are Roman",Toast.LENGTH_SHORT).show();

        gv1.postDelayed(new Runnable() {
            @Override
            public void run() {
                gv1.setText("Gauge is Now :-"+gauge);
            }
        },3500l);

    }
    public void toasty(String tst){
        Toast.makeText(this,tst,Toast.LENGTH_SHORT).show();
    }
    public void checkSF(){

    }
    public void doFinish(View v){
        Handler hand=new Handler();

        String ul="android.resource://scott.jp.wrestlekingdom/"+w1.getFinisherVidID();
        Uri ui= Uri.parse(ul);
        vv.setVideoURI(ui);
        vv.start();

        hp2=hp2-(hp2/2);
        gauge=gauge-100;
        if(gauge<100)
        fin.setVisibility(View.INVISIBLE);
        hand.postDelayed(new Runnable() {
            @Override
            public void run() {
                toasty("JR:- Good god almighty good god almighty");
                toasty("Mauro :- Mamma Mia");
                toasty("Tom :- "+w1.getName()+" Has Used His Finisher");
                toasty(w1.getFinisher());
                hv2.setText(w2.getName()+":- "+hp2);
                gv1.setText("Gauge is Now :-"+gauge);


            }
        },2300l);

    }
}
