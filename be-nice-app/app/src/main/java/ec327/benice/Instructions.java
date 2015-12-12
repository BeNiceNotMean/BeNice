package ec327.benice;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Instructions extends AppCompatActivity {

    private static TextView instructions;
    private static TextView havefun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        instructions = (TextView)findViewById(R.id.txt_instructions);
        havefun = (TextView)findViewById(R.id.txt_havefun);

        //set the everything to new font
        Typeface Bangersfont = Typeface.createFromAsset(getAssets(),"fonts/Bangers.ttf");
        instructions.setTypeface(Bangersfont);
        havefun.setTypeface(Bangersfont);

        //BELOW IS THE TOOLBAR/EMAIL ICON DEFAULTS ACTIVATIONS
       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */
    }

}
