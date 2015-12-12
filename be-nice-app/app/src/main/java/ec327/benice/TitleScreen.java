package ec327.benice;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TitleScreen extends AppCompatActivity {

    //list the two buttons
    private static Button btnStart;
    private static Button btnInstructions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_screen);

        btnStart = (Button)findViewById(R.id.btnStart);                 //find btnStart from xml
        btnInstructions = (Button)findViewById(R.id.btnInstructions);   //find btnInstructions xml

        //set custom font for buttons
        Typeface MainPageFont = Typeface.createFromAsset(getAssets(),"fonts/Bangers.ttf");
        btnStart.setTypeface(MainPageFont);
        btnInstructions.setTypeface(MainPageFont);

        clickInstructions();
        clickStart();
    }

    //BUTTON FOR INSTRUCTIONS
    public void clickInstructions(){
        btnInstructions.setOnClickListener(                                 //use OnClickListener function in button class
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //perform action on click
                        Intent intentInstructions = new Intent("android.intent.action.ec327.benice.Instructions");
                        startActivity(intentInstructions);
                    }
                }
        );
    }

    //BUTTON FOR START
    public void clickStart(){
        btnStart.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Erase any saved clicked messages from previous games
                        Globals clicked_messages = Globals.getInstance();
                        clicked_messages.clear_contacts();
                        clicked_messages.clear_messages();

                        //perform action on click
                        Intent intentStart = new Intent("android.intent.action.ec327.benice.GamePage");
                        startActivity(intentStart);
                    }
                }
        );
    }
}
