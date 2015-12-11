package ec327.benice;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;
//Added for contacts
import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.net.Uri;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GamePage extends AppCompatActivity {

    // To reduce clutter and make structure clearer when handling contacts, define some shorthand constants.
    private static final Uri URI = ContactsContract.Contacts.CONTENT_URI;
    private static final Uri PURI = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
    private static final String ID = ContactsContract.Contacts._ID;
    private static final String DNAME = ContactsContract.Contacts.DISPLAY_NAME;
    private static final String HPN = ContactsContract.Contacts.HAS_PHONE_NUMBER;
    private static final String CID = ContactsContract.CommonDataKinds.Phone.CONTACT_ID;
    private static final String PNUM = ContactsContract.CommonDataKinds.Phone.NUMBER;
    private static final String PHONETYPE = ContactsContract.CommonDataKinds.Phone.TYPE;
    private static final int MAX_NUMBER_ENTRIES = 1;
    private String id;
    private String name;
    private String ph[];
    private String phType[];
    private int phcounter;

    int counter_nice;
    int counter_mean;

    // Twilio
    private Sms phone;

    // Get the global array of the actually clicked messages
    Globals clicked_messages = Globals.getInstance();

    //Compliments Variables
    ArrayList<Compliment> compliments_list = new ArrayList<Compliment>();
    ArrayList<Compliment> compliments_for_view = new ArrayList<Compliment>();
    int compliment_Index;

    //Contacts Variables
    ArrayList<Contact> contacts_all = new ArrayList<Contact>();
    ArrayList<Contact> contacts_1 = new ArrayList<Contact>();
    ArrayList<Contact> contacts_2 = new ArrayList<Contact>();
    ArrayList<Contact> contacts_3 = new ArrayList<Contact>();
    int contacts_1_Index;
    int contacts_2_Index;
    int contacts_3_Index;


    //*************************************
    //*************UI STUFF****************
    //*************************************
    //Compliments Widgets
    private static Button btnNext;
    private static Button btnPrevious;
    private static TextSwitcher textswitcher;
    //P1 Widgets
    private static ImageButton btnP1Nice;
    private static ImageButton btnP1Mean;
    private static TextSwitcher txtswitchP1;
    //P2 Widgets
    private static ImageButton btnP2Nice;
    private static ImageButton btnP2Mean;
    private static TextSwitcher txtswitchP2;
    //P3 Widgets
    private static ImageButton btnP3Nice;
    private static ImageButton btnP3Mean;
    private static TextSwitcher txtswitchP3;
    //*******TextView Widgets, counters for each TextSwitcher********
    //private static TextView txtview1;
    //private static TextView txtview2;
    //private static TextView txtview3;

    //Counter Widget
    private static ImageView counterpicture;

    //GameOver Intent
    Intent NiceGameOver;
    Intent MeanGameOver;

    //Font Typefaces
    Typeface BangersFont;

    //

    //END VARIABLES
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //START METHODS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);

        //************************************
        //*************INITIALIZE VARIABLES**************
        //************************************
        //initialize variables as necessary
        ph = new String[MAX_NUMBER_ENTRIES];
        phType = new String[MAX_NUMBER_ENTRIES];
        phone = new Sms(getApplicationContext());
        // Get all the phone contacts
        processContacts();

        // Load the compliments list
        compliments_list = Compliment.loadCompliments(compliments_list);

        // Randomize the contacts
        long seed = System.nanoTime();
        Collections.shuffle(contacts_all, new Random(seed));
        Collections.shuffle(compliments_list, new Random(seed));

        // Reduce the compliments to a list of 15 compliments
        for (int i = 0; i < 15; i++)
        {
            Compliment compliment = compliments_list.get(i);
            compliments_for_view.add(compliment);
        }

        // For Emulators that don't have any contacts in them, preload a few
        if(contacts_all.size() == 0)
        {
            Contact person1 = new Contact("1", "Barack Obama", "15554443333");
            contacts_all.add(person1);
            Contact person2 = new Contact("2", "Professor Densmore", "15554443333");
            contacts_all.add(person2);
            Contact person3 = new Contact("3", "Lebron James", "15554443333");
            contacts_all.add(person3);
            Contact person4 = new Contact("4", "Elon Musk", "15554443333");
            contacts_all.add(person4);
            Contact person5 = new Contact("5", "Granny", "15554443333");
            contacts_all.add(person5);
            Contact person6 = new Contact("6", "Homer Simpson", "15554443333");
            contacts_all.add(person6);
            Contact person7 = new Contact("7", "Mr. Rogers", "15554443333");
            contacts_all.add(person7);
            Contact person8 = new Contact("8", "Mom", "15554443333");
            contacts_all.add(person8);
            Contact person9 = new Contact("9", "John Travolta", "15554443333");
            contacts_all.add(person9);
            Contact person10 = new Contact("10", "Bob", "15554443333");
            contacts_all.add(person10);
            Contact person11 = new Contact("11", "Thai Restaurant", "15554443333");
            contacts_all.add(person11);
            Contact person12 = new Contact("12", "Lindsey Tinder", "15554443333");
            contacts_all.add(person12);
        }

        // Get 3 lists of 4 unique contacts each so that we can play the game
        Integer total_contacts_counter = 0;

        // Need while loop in case we have < 12 contacts on the phone, just use the same contacts again til full
        while (total_contacts_counter < 12) {
            for (int i = 0; i < contacts_all.size(); i++) {
                Contact person = contacts_all.get(i);
                if (total_contacts_counter < 4) {
                    contacts_1.add(person);
                } else if (total_contacts_counter >= 4 && total_contacts_counter < 8) {
                    contacts_2.add(person);
                } else if (total_contacts_counter >= 8 && total_contacts_counter < 12) {
                    contacts_3.add(person);
                }
                // i >= 12 means we have enough contacts
                total_contacts_counter++;
            }
        }

        //initialize counters and indices
        counter_mean = 0;
        counter_nice = 0;
        compliment_Index = 0;

        // Needed to update this to handle separate contacts_arrays
        contacts_1_Index = 0;
        contacts_2_Index = 0;
        contacts_3_Index = 0;

        //************************************
        //*************FONTS******************
        //************************************
        BangersFont = Typeface.createFromAsset(getAssets(),"fonts/Bangers.ttf");

        //************************************
        //*********GAMEOVER INTENTS***********
        //************************************
        NiceGameOver = new Intent("android.intent.action.ec327.benice.NiceGameOver");
        MeanGameOver = new Intent("android.intent.action.ec327.benice.MeanGameOver");

        //************************************
        //*************UI METHODS*************
        //************************************
        //Compliments Method Calls
        compliment_init();
        compliment_Click();             //animations loaded in here
        compliment_setFactory();

        //Contacts Method Call
        contacts_init();             //initializes all buttons/textswitchers for contacts and fonts
        contacts_Animation();        //sets up all animations for all textswitchers

        //Contacts Separate Method Calls
        p1_Click();
        p1_setFactory();
        p2_Click();
        p2_setFactory();
        p3_Click();
        p3_setFactory();
        //Initialize the TextViews connected to each TextSwitcher: MUST GO AFTER px_setFactory() functions!!
        //txtview1 = (TextView) txtswitchP1.getChildAt(contacts_Index);
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//************************************
//*******START CONTACTS METHODS*******
//************************************
    void contacts_init() {
        btnP1Nice = (ImageButton) findViewById(R.id.btnP1Nice);
        btnP1Mean = (ImageButton) findViewById(R.id.btnP1Mean);
        txtswitchP1 = (TextSwitcher) findViewById(R.id.textswitchP1);

        btnP2Nice = (ImageButton) findViewById(R.id.btnP2Nice);
        btnP2Mean = (ImageButton) findViewById(R.id.btnP2Mean);
        txtswitchP2 = (TextSwitcher) findViewById(R.id.textswitchP2);

        btnP3Nice = (ImageButton) findViewById(R.id.btnP3Nice);
        btnP3Mean = (ImageButton) findViewById(R.id.btnP3Mean);
        txtswitchP3 = (TextSwitcher) findViewById(R.id.textswitchP3);

        counterpicture = (ImageView) findViewById(R.id.img_meancounter);

        btnNext.setTypeface(BangersFont);
        btnPrevious.setTypeface(BangersFont);
    }

    void contacts_Animation()
    {
        Animation in = AnimationUtils.loadAnimation(this, R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this,R.anim.slide_out_right);
        txtswitchP1.setInAnimation(in);
        txtswitchP1.setOutAnimation(out);
        txtswitchP2.setInAnimation(in);
        txtswitchP2.setOutAnimation(out);
        txtswitchP3.setInAnimation(in);
        txtswitchP3.setOutAnimation(out);
    }

    //P1 Click Listener
    void p1_Click() {

        //MEAN BUTTON CLICKED
        btnP1Mean.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                counter_mean++;
                contacts_1_Index++;


                if (contacts_1_Index == contacts_1.size())
                    contacts_1_Index = 0;

                txtswitchP1.setText(contacts_1.get(contacts_1_Index).get_name());

                //change counter picture
                if (counter_mean == 1)
                    counterpicture.setImageResource(R.drawable.count1);
                if (counter_mean == 2)
                    counterpicture.setImageResource(R.drawable.count2);

                //counter of 3 goes to lose page
                if (counter_mean == 3)
                    startActivity(MeanGameOver);

            }
        });

        //NICE BUTTON CLICKED
        btnP1Nice.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                counter_nice++;

                // Update the global arraylist
                Contact clicked_contact = new Contact(contacts_1.get(contacts_1_Index).get_id(), contacts_1.get(contacts_1_Index).get_name(), contacts_1.get(contacts_1_Index).get_phone());
                Compliment clicked_message = new Compliment(compliments_for_view.get(compliment_Index).get_id(), compliments_for_view.get(compliment_Index).get_message());
                // Initiate SMS
                // String c1number = contacts_1.get(contacts_1_Index).get_phone();
                // String c1name = contacts_1.get(contacts_1_Index).get_name();
                // String c1compliment = compliments_for_view.get(compliment_Index).get_message();
                //phone.message(c1number, c2name, c2compliment);
                clicked_messages.add_contacts_sent(clicked_contact);
                clicked_messages.add_messages_sent(clicked_message);

                //if sent 3 compliments, start NiceGameOver Activity
                if (counter_nice == 3) {
                    startActivity(NiceGameOver);
                }

                //disable buttons. change background color. change button icons
                btnP1Nice.setEnabled(false);
                btnP1Mean.setEnabled(false);
                txtswitchP1.setBackgroundColor(Color.parseColor("#33ffffe5"));
                btnP1Nice.setImageResource(R.drawable.icon_nicebw_60_65);
                btnP1Mean.setImageResource(R.drawable.icon_meanbw_60_65);

                //make a quick message
                Toast.makeText(getApplicationContext(), "Compliment '" + compliments_for_view.get(compliment_Index).get_message() + "' sent to " + contacts_1.get(contacts_1_Index).get_name(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    //P1 TxtView Factory
    void p1_setFactory() {
        txtswitchP1.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {

                //Create TextView for p1
                TextView p1 = new TextView(GamePage.this);
                //layout parameters. centers vertically and horizontally. and give parameters to TextView
                FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT, Gravity.CENTER);
                p1.setLayoutParams(params);
                //compliment.setGravity(Gravity.CENTER);         //UNNEEDED?

                p1.setEllipsize(TextUtils.TruncateAt.END);      //ellipses
                p1.setMaxLines(2);

                p1.setText(contacts_1.get(0).get_name());
                p1.setGravity(Gravity.CENTER);
                p1.setTextSize(20);
                p1.setTextColor(Color.WHITE);
                p1.setTypeface(BangersFont);
                return p1;
            }
        });

    }

    //P2 Click Listener
    void p2_Click() {

        //MEAN BUTTON CLICKED
        btnP2Mean.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                counter_mean++;
                contacts_2_Index++;

                if (contacts_2_Index == contacts_2.size())
                    contacts_2_Index = 0;

                txtswitchP2.setText(contacts_2.get(contacts_2_Index).get_name());

                //Add a new "Mean" counter picture
                if(counter_mean == 1)
                    counterpicture.setImageResource(R.drawable.count1);
                if(counter_mean == 2)
                    counterpicture.setImageResource(R.drawable.count2);

                //counter of 3 goes to lose page
                if(counter_mean == 3)
                    startActivity(MeanGameOver);
            }
        });

        //NICE BUTTON CLICKED
        btnP2Nice.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                counter_nice++;

                // Update the global arraylist
                Contact clicked_contact = new Contact(contacts_2.get(contacts_2_Index).get_id(), contacts_2.get(contacts_2_Index).get_name(), contacts_2.get(contacts_2_Index).get_phone());
                Compliment clicked_message = new Compliment(compliments_for_view.get(compliment_Index).get_id(), compliments_for_view.get(compliment_Index).get_message());
                // Initiate SMS
                // String c2phone = contacts_2.get(contacts_2_Index).get_phone(); //commented out to allow for grader testing
                String c2name = contacts_2.get(contacts_2_Index).get_name();
                String c2compliment = compliments_for_view.get(compliment_Index).get_message();
                // phone.message("15614144449", c2name, c2compliment); //this line will send texts to the hardcoded number
                clicked_messages.add_contacts_sent(clicked_contact);
                clicked_messages.add_messages_sent(clicked_message);

                //if sent 3 compliments, start NiceGameOver Activity
                if (counter_nice == 3) {
                    startActivity(NiceGameOver);
                }

                //disable buttons. change color. change icons
                btnP2Nice.setEnabled(false);
                btnP2Mean.setEnabled(false);
                txtswitchP2.setBackgroundColor(Color.parseColor("#33ffffe5"));
                btnP2Nice.setImageResource(R.drawable.icon_nicebw_60_65);
                btnP2Mean.setImageResource(R.drawable.icon_meanbw_60_65);

                //make a quick message
                Toast.makeText(getApplicationContext(), "Compliment '" + compliments_for_view.get(compliment_Index).get_message() + "' sent to " + contacts_2.get(contacts_2_Index).get_name(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    //P2 TxtView Factory
    void p2_setFactory() {
        txtswitchP2.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {

                //Create TextView for p2
                TextView p2 = new TextView(GamePage.this);

                //layout parameters. centers vertically and horizontally. and give parameters to TextView
                FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT, Gravity.CENTER);
                p2.setLayoutParams(params);
                //compliment.setGravity(Gravity.CENTER);         //UNNEEDED?

                p2.setEllipsize(TextUtils.TruncateAt.END);      //ellipses
                p2.setMaxLines(2);

                p2.setText(contacts_2.get(0).get_name());
                p2.setGravity(Gravity.CENTER);
                p2.setTextSize(20);
                p2.setTextColor(Color.WHITE);
                p2.setTypeface(BangersFont);
                return p2;
            }
        });

    }


    //P3 Click Listener
    void p3_Click() {

        //MEAN BUTTON CLICKED
        btnP3Mean.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                counter_mean++;
                contacts_3_Index++;

                if (contacts_3_Index == contacts_3.size())
                    contacts_3_Index = 0;

                txtswitchP3.setText(contacts_3.get(contacts_3_Index).get_name());

                //change counter picture
                if(counter_mean == 1)
                    counterpicture.setImageResource(R.drawable.count1);
                if(counter_mean == 2)
                    counterpicture.setImageResource(R.drawable.count2);

                //counter of 3 goes to lose page
                if(counter_mean == 3)
                    startActivity(MeanGameOver);
            }
        });

        //NICE BUTTON CLICKED
        btnP3Nice.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                counter_nice++;

                // Update the global arraylist
                Contact clicked_contact = new Contact(contacts_3.get(contacts_3_Index).get_id(), contacts_3.get(contacts_3_Index).get_name(), contacts_3.get(contacts_3_Index).get_phone());
                Compliment clicked_message = new Compliment(compliments_for_view.get(compliment_Index).get_id(), compliments_for_view.get(compliment_Index).get_message());
                // Initiate SMS
                // String c3number = contacts_3.get(contacts_3_Index).get_phone();
                // String c3name = contacts_3.get(contacts_3_Index).get_name();
                // String c3compliment = compliments_for_view.get(compliment_Index).get_message();
                //phone.message(c3number, c3name, c3compliment);
                clicked_messages.add_contacts_sent(clicked_contact);
                clicked_messages.add_messages_sent(clicked_message);

                //if sent 3 compliments, start NiceGameOver Activity
                if (counter_nice == 3) {
                    startActivity(NiceGameOver);
                }

                //disable buttons. change color. change icons
                btnP3Nice.setEnabled(false);
                btnP3Mean.setEnabled(false);
                txtswitchP3.setBackgroundColor(Color.parseColor("#33ffffe5"));
                btnP3Nice.setImageResource(R.drawable.icon_nicebw_60_65);
                btnP3Mean.setImageResource(R.drawable.icon_meanbw_60_65);

                //make a quick message
                Toast.makeText(getApplicationContext(), "Compliment '" + compliments_for_view.get(compliment_Index).get_message() + "' sent to " + contacts_3.get(contacts_3_Index).get_name(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    //P3 TxtView Factory
    void p3_setFactory() {
        txtswitchP3.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {

                //Create TextView for p1
                TextView p3 = new TextView(GamePage.this);

                //layout parameters. centers vertically and horizontally. and give parameters to TextView
                FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT, Gravity.CENTER);
                p3.setLayoutParams(params);
                //compliment.setGravity(Gravity.CENTER);         //UNNEEDED?

                p3.setEllipsize(TextUtils.TruncateAt.END);      //ellipses
                p3.setMaxLines(2);

                p3.setText(contacts_3.get(0).get_name());
                p3.setGravity(Gravity.CENTER);
                p3.setTextSize(20);
                p3.setTextColor(Color.WHITE);
                p3.setTypeface(BangersFont);
                return p3;
            }
        });

    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//**************************************
//*******START COMPLIMENT METHODS*******
//**************************************
    void compliment_init() {
        btnNext = (Button) findViewById(R.id.compliment_btnNext);
        btnPrevious = (Button) findViewById(R.id.compliment_btnPrevious);
        textswitcher = (TextSwitcher) findViewById(R.id.compliment_TextSwitcher);


    }

    void compliment_AnimationAdd()
    {
        Animation in = AnimationUtils.loadAnimation(this, R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this,R.anim.slide_out_right);
        textswitcher.setInAnimation(in);
        textswitcher.setOutAnimation(out);

    }


    void compliment_AnimationMinus()
    {
        Animation in = AnimationUtils.loadAnimation(this, R.anim.slide_in_right);
        Animation out = AnimationUtils.loadAnimation(this,R.anim.slide_out_left);
        textswitcher.setInAnimation(in);
        textswitcher.setOutAnimation(out);
    }


    // Click listener method for button
    void compliment_Click() {

        //Next button on click actions
        btnNext.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                compliment_Index++;

                if (compliment_Index == compliments_for_view.size())
                    compliment_Index = 0;

                compliment_AnimationAdd();
                textswitcher.setText(compliments_for_view.get(compliment_Index).get_message());
            }
        });

        //Previous button on click actions
        btnPrevious.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                compliment_Index--;

                if (compliment_Index < 0)
                    compliment_Index = compliments_for_view.size() - 1;

                compliment_AnimationMinus();
                textswitcher.setText(compliments_for_view.get(compliment_Index).get_message());
            }
        });
    }


    //Set Factory for TextSwitcher
    void compliment_setFactory() {
        textswitcher.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {

                //Create TextView for compliment messages
                TextView compliment = new TextView(GamePage.this);

                //layout parameters. centers vertically and horizontally. and give parameters to TextView
                FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT, Gravity.CENTER);
                compliment.setLayoutParams(params);

                compliment.setEllipsize(TextUtils.TruncateAt.END);      //ellipses
                compliment.setMaxLines(5);                              //max lines shown
                compliment.setTextSize(30);
                compliment.setTextColor(Color.YELLOW);
                compliment.setGravity(Gravity.CENTER);
                compliment.setTypeface(BangersFont);


                compliment.setText(compliments_for_view.get(0).get_message());

                return compliment;
            }
        });

    }

    /////////////////////////////
    //END COMPLIMENT METHODS////
    /////////////////////////////

    // This function built based off of code from http://eagle.phys.utk.edu/guidry/android/readContacts.html
    private ArrayList<Contact> processContacts() {
        try {
            ContentResolver cr = getContentResolver();
            Cursor cu = cr.query(URI, null, null, null, null);

            if (cu.getCount() > 0) {
                // Loop over all contacts

                while (cu.moveToNext()) {
                    // Get ID information (id, name and lookup key) for this contact. id is an identifier
                    // number, name is the name associated with this row in the database, and
                    // lookupKey is an opaque value that contains hints on how to find the contact
                    // if its row id changed as a result of a sync or aggregation.
                    id = cu.getString(cu.getColumnIndex(ID));
                    name = cu.getString(cu.getColumnIndex(DNAME));

                    // Query phone numbers for this contact (may be more than one), so use a
                    // while-loop to move the cursor to the next row until moveToNext() returns
                    // false, indicating no more rows. Store the results in arrays since there may
                    // be more than one phone number stored per contact. The if-statement
                    // enclosing everything ensures that the contact has at least one phone
                    // number stored in the Contacts database.

                    phcounter = 0;
                    if (Integer.parseInt(cu.getString(cu.getColumnIndex(HPN))) > 0) {
                        Cursor pCur = cr.query(PURI, null, CID + " = ?", new String[]{id}, null);
                        while (pCur.moveToNext()) {
                            ph[phcounter] = pCur.getString(pCur.getColumnIndex(PNUM));
                            phType[phcounter] = pCur.getString(pCur.getColumnIndex(PHONETYPE));
                            phcounter++;
                        }
                        pCur.close();
                    }

                    // Append list of contacts to the Contact list (consider checking for phone_type = "2" mobile later
                    Contact person = new Contact(id, name, ph[0]);
                    contacts_all.add(person);
                }
            }
            cu.close();
        } catch(Exception e)
        {
            //Log.d("HELPO", "The cursor section does not work");
        }
        return contacts_all;
    }

}   //end class

