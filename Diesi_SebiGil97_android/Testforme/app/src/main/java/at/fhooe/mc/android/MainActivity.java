package at.fhooe.mc.android;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import static android.content.ContentValues.TAG;

public class MainActivity extends Activity implements View.OnClickListener {
    public static final String TAG = "Stuff";
    public NameList friends=new NameList();
    public NameList friendsRestore;
    @Override
    protected void onCreate(Bundle _savedInstanceState) {
        super.onCreate(_savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b=null;

        b=findViewById(R.id.activity_main_button_load);
        b.setOnClickListener(this);

        b=findViewById(R.id.activity_main_button_save);
        b.setOnClickListener(this);

        b=findViewById(R.id.activity_main_button_saveSerial);
        b.setOnClickListener(this);
    }


    @Override
    public void onClick(View _v) {
        switch(_v.getId()){
            case R.id.activity_main_button_save : {
                Log.i(TAG, "Press Button Save");
                EditText name=(EditText) findViewById(R.id.activity_main_editText_inputName);
                friends.append(new Name(name.getText().toString()));                //add friends name

            } break;
            case R.id.activity_main_button_load : {
                //normal version
                /*TextView loadName=(TextView) findViewById(R.id.activity_main_textView_name) ;
                loadName.setText(friends.toText());
                */

                //wiederherstellung aus seriallisierung

                try (FileInputStream fis = new FileInputStream ("NameList.ser");
                     ObjectInputStream ois = new ObjectInputStream (fis)) {
                     final NameList friendsRestore = (NameList) ois.readObject (); //final NameList

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                TextView loadName=(TextView) findViewById(R.id.activity_main_textView_name) ;
                loadName.setText(friendsRestore.toText());

                Log.i(TAG, "Press Button Load");
            } break;
           case R.id.activity_main_button_saveSerial : {
                try (FileOutputStream fos = new FileOutputStream ("NameList.ser");
                     ObjectOutputStream oos = new ObjectOutputStream (fos)) {
                    oos.writeObject (friends);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Log.i(TAG, "Press Button SerialSafe");
            } break;
            default : {
                Log.i(TAG, "unexpected ID");
            } break;
        }
    }



}
