package com.example.dynamicapplication;

import android.content.DialogInterface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText initial;
    ArrayList<EditText> mylists=new ArrayList<EditText>();
    LinearLayout mylayout;
    AppCompatActivity myact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    initial=findViewById(R.id.editView);
        mylayout=findViewById(R.id.linearLayout);
        myact=this;
        initial.setOnKeyListener(new View.OnKeyListener() {



            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                   // Toast.makeText(getApplicationContext(), edittext.getText(), Toast.LENGTH_SHORT).show();
                    mylayout.removeAllViews();
                    mylists.clear();
                    int numtocreate=Integer.parseInt((initial.getText()).toString());
                    for (int i=0;i<numtocreate;i++)

                    {
                        mylists.add(new EditText(getApplicationContext()));
                    }

                    for (EditText e :mylists)
                    {
                        mylayout.addView(e);
                    }
                    Button sum=new Button(getApplicationContext());
                    mylayout.addView(sum);
                    sum.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int sum=0;
                            for (EditText e:mylists)
                            {
                                sum+=Integer.parseInt((e.getText()).toString());
                            }
                            Log.d("result",sum+"");
                            TextView result=new TextView(getApplicationContext());

                            result.setText(" "+sum);
                            mylayout.addView(result);


                        }
                    });



                    return true;
                }
                return false;
            }
        });






    }//

}
