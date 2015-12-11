package ec327.benice;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MeanGameOver extends AppCompatActivity {

    private static TextView txt_loser;
    private static Button btn_playagain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mean_game_over);

        // Retrieve the clicked messages
        Globals clicked_messages = Globals.getInstance();
        ArrayList<Contact> final_contacts = clicked_messages.get_contacts_sent();
        ArrayList<Compliment> final_compliments = clicked_messages.get_messages_sent();

        txt_loser = (TextView)findViewById(R.id.txt_loser);
        btn_playagain = (Button) findViewById(R.id.btn_playagain);



        //set the everything to new font
        Typeface Bangersfont = Typeface.createFromAsset(getAssets(),"fonts/Bangers.ttf");
        txt_loser.setTypeface(Bangersfont);
        btn_playagain.setTypeface(Bangersfont);


        clickRedeem();
    }

    public void clickRedeem()
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