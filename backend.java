package com.example.smeet.mygame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    int [] gamestate={2,2,2,2,2,2,2,2,2};
    // 0 YELLOW ;;; 1 RED ;;; 2 blank
    int [][]winning={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int player=0;
    boolean won=true;
    int flag=0;
    public void fun(View view)
    {
        ImageView counter =(ImageView)view;
        int click=Integer.parseInt(counter.getTag().toString());
        if(gamestate[click]==2 && won){
            flag++;
            gamestate[click]=player;
            counter.setTranslationY(-1500);
        if (player == 0) {
            counter.setImageResource(R.drawable.yellow);
            player = 1;
        } else {
            counter.setImageResource(R.drawable.red);
            player = 0;
        }
        counter.animate().translationYBy(1500).setDuration(500);
        String winner = "";
        for (int[] winning : winning) {
            if (gamestate[winning[0]] == gamestate[winning[1]] && gamestate[winning[1]] == gamestate[winning[2]] && gamestate[winning[2]] != 2 && flag!=9) {
                //someone won!
                won=false;
                if (player == 1) {
                    winner = "Yellow";
                    //Toast.makeText(this, "Yellow has won", Toast.LENGTH_SHORT).show();
                } else {
                    winner = "Red";
                    //Toast.makeText(this, "Red has won", Toast.LENGTH_SHORT).show();
                }

                Button restart=(Button)findViewById(R.id.restart);
                TextView Winner=(TextView)findViewById(R.id.Winner);
                Winner.setText(winner+" has Won!");
                restart.setVisibility(View.VISIBLE);
                Winner.setVisibility(View.VISIBLE);
            }
             else if(flag==9)
            {
                Button restart=(Button)findViewById(R.id.restart);
                TextView Winner=(TextView)findViewById(R.id.Winner);
                Winner.setText("Its a DRAW!");
                flag=0;
                restart.setVisibility(View.VISIBLE);
                Winner.setVisibility(View.VISIBLE);

            }

        }
    }
    }
    public void function(View view)
    {
        Button restart=(Button)findViewById(R.id.restart);
        TextView Winner=(TextView)findViewById(R.id.Winner);
        restart.setVisibility(View.INVISIBLE);
        Winner.setVisibility(View.INVISIBLE);
        GridLayout gridLayout=(GridLayout) findViewById(R.id.gridLayout);
        for(int i=0;i<9;i++) {
            ImageView counter=(ImageView) gridLayout.getChildAt(i);
            counter.setImageDrawable(null);
        }
        for(int i=0;i<gamestate.length;i++)
        {
            gamestate[i] = 2;
        }
        player=0;
        won=true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
