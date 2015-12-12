package ec327.benice;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;


public class NiceGameOver extends AppCompatActivity {

    private static TextView txt_winner;
    private static Button btn_playagain;
    private static TextView txt_historytitle;
    private static TextView txt_history1;
    private static TextView txt_history2;
    private static TextView txt_history3;
    // For testing only!
//    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nice_game_over);

        // Retrieve the clicked messages
        Globals clicked_messages = Globals.getInstance();
        ArrayList<Contact> final_contacts = clicked_messages.get_contacts_sent();
        ArrayList<Compliment> final_compliments = clicked_messages.get_messages_sent();

//        // For testing purposes, show them
//        for (int i = 0; i < final_contacts.size(); i++) {
//            tv.append("You sent a text message to " + final_contacts.get(i).get_name() + ": '" + final_compliments.get(i).get_message() + "' " + "\n");
//        }


        txt_winner = (TextView)findViewById(R.id.txt_winner);
        btn_playagain = (Button) findViewById(R.id.btn_playagain);
        txt_history1 = (TextView)findViewById(R.id.txt_history1);
        txt_history2 = (TextView)findViewById(R.id.txt_history2);
        txt_history3 =  (TextView)findViewById(R.id.txt_history3);
        txt_historytitle = (TextView)findViewById(R.id.txt_historytitle);

        //set the everything to new font
        Typeface Bangersfont = Typeface.createFromAsset(getAssets(),"fonts/Bangers.ttf");
        txt_winner.setTypeface(Bangersfont);
        btn_playagain.setTypeface(Bangersfont);
        txt_historytitle.setTypeface(Bangersfont);
        txt_history1.setTypeface(Bangersfont);
        txt_history2.setTypeface(Bangersfont);
        txt_history3.setTypeface(Bangersfont);

        //set history text
        txt_history1.setText("1. " + final_contacts.get(0).get_name() + ": '" + final_compliments.get(0).get_message() + "'");
        txt_history2.setText("2. " + final_contacts.get(1).get_name() + ": '" + final_compliments.get(1).get_message() + "'");
        txt_history3.setText("3. " + final_contacts.get(2).get_name() + ": '" + final_compliments.get(2).get_message() + "'");

        clickPlayAgain();
    }

    public void clickPlayAgain()
    {
        btn_playagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Erase any saved clicked messages from previous games
                Globals clicked_messages = Globals.getInstance();
                clicked_messages.clear_contacts();
                clicked_messages.clear_messages();

                Intent mainpage = new Intent(getApplicationContext(), TitleScreen.class);
                mainpage.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(mainpage);
            }
        });
    }

    //disable back button
    @Override
    public void onBackPressed() {
    }

}//end class

