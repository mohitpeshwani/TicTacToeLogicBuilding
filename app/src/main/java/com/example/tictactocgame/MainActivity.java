package com.example.tictactocgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9;
    String s1,s2,s3,s4,s5,s6,s7,s8,s9;
    int flag = 0;
    int moveCounter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();




    }
    private void init()
    {
        b1=findViewById(R.id.button1);
        b2=findViewById(R.id.button2);
        b3=findViewById(R.id.button3);
        b4=findViewById(R.id.button4);
        b5=findViewById(R.id.button5);
        b6=findViewById(R.id.button6);
        b7=findViewById(R.id.button7);
        b8=findViewById(R.id.button8);
        b9=findViewById(R.id.button9);
    }

    public void check(View view) throws InterruptedException {
        Button btnCurrent = (Button)view;
        if(btnCurrent.getText().equals("X")||btnCurrent.getText().equals("O") )
        {
            Toast.makeText(this, "Already used by another user please use other Blank Boxes", Toast.LENGTH_SHORT).show();
        }
       else if(flag==0)
       {
           btnCurrent.setText("X");
           flag=1;
           moveCounter++;
       }
       else {
           btnCurrent.setText("O");
           flag=0;
           moveCounter++;
       }
       if(moveCounter>4)
       {
          s1 = b1.getText().toString();
          s2 = b2.getText().toString();
          s3 = b3.getText().toString();
          s4 = b4.getText().toString();
          s5 = b5.getText().toString();
          s6 = b6.getText().toString();
          s7 = b7.getText().toString();
          s8 = b8.getText().toString();

          if((s1.equals(s2) && s2.equals(s3)) || (s1.equals(s4) && s1.equals(s7)) ||( s1.equals(s5) && s1.equals(s9)) || (s3.equals(s6) && s6.equals(s9)) || (s4.equals(s5) && s5.equals(s6)) || (s7.equals(s8) && s8.equals(s9)) || (s2.equals(s4) && s4.equals(s8) || (s3.equals(s5) && s5.equals(s7))))
          {
              if(moveCounter%2==1){
                  flag=0;
                  Toast.makeText(this, "Player 1 wins", Toast.LENGTH_SHORT).show();
                  reset();
              }
              else
              {
                  Toast.makeText(this, "Player 2 wins", Toast.LENGTH_SHORT).show();
                    reset();
              }

          }
          else if(moveCounter==9){
               Toast.makeText(this, "draw", Toast.LENGTH_SHORT).show();
               reset();

           }

       }
    }

    public void reset()
    {
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        b9.setText("");
        moveCounter=0;
    }




}