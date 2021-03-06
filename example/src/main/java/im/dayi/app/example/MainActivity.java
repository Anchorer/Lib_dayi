package im.dayi.app.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import im.dayi.app.library.view.CustomProgressDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1 = (Button) findViewById(R.id.main_btn1);
        Button btn2 = (Button) findViewById(R.id.main_btn2);
        Button btn3 = (Button) findViewById(R.id.main_btn3);
        Button btn4 = (Button) findViewById(R.id.main_btn4);
        btn1.setOnClickListener(new ShowDialogListener(btn1.getText().toString()));
        btn2.setOnClickListener(new ShowDialogListener(btn2.getText().toString()));
        btn3.setOnClickListener(new ShowDialogListener(btn3.getText().toString()));
        btn4.setOnClickListener(new ShowDialogListener(btn4.getText().toString()));
    }

    class ShowDialogListener implements View.OnClickListener {
        private String text;
        public ShowDialogListener(String text) {
            this.text = text;
        }
        @Override
        public void onClick(View v) {
            CustomProgressDialog.showProgressDialog(MainActivity.this, true, text);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
