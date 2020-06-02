package sg.edu.rp.c346.id_18021531.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button btnDBS, btnOC, btnUOB;
String SelectedButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnDBS = findViewById(R.id.button);
        btnOC = findViewById(R.id.button2);
        btnUOB = findViewById(R.id.button3);

        registerForContextMenu(btnDBS);
        registerForContextMenu(btnOC);
        registerForContextMenu(btnUOB);




    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"website");
        menu.add(0,1,1,"contact the bank");

        if (v.getId() == btnDBS.getId()) {
            SelectedButton = "DBS";

        } else if (v.getId() == btnOC.getId()) {
            SelectedButton = "OCBC";
        } else {
            SelectedButton = "UOB";
        }
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (SelectedButton == "DBS") {
            if (item.getItemId() == 0) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.DBS.com"));
                startActivity(intent);


                return true;
            } else if (item.getItemId() == 1) {
                //code for action
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18001111111"));
                startActivity(intent);
                return true;
            }
        }else if (SelectedButton == "OCBC") {
            if (item.getItemId() == 0) {

                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.ocbc.com"));
                startActivity(intent);


                return true;
            } else if (item.getItemId() == 1) {
                //code for action
                Intent intent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:" + "18003633333"));
                startActivity(intent);
                return true;
            }
        }else if (SelectedButton == "UOB"){
            if (item.getItemId() == 0) {

                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);


                return true;
            } else if (item.getItemId() == 1) {
                //code for action
                Intent intent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:" + "18002222121"));
                startActivity(intent);
                return true;
            }

        }
        return super.onContextItemSelected(item);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            btnDBS.setText("DBS");
            btnOC.setText("OCBC");
             btnUOB.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            btnDBS.setText("星展银行");
            btnOC.setText("华侨银行");
            btnUOB.setText("大华银行");
            return true;
        }


        return super.onOptionsItemSelected(item);
    }



}
