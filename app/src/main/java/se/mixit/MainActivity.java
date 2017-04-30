package se.mixit;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Go=(Button)findViewById(R.id.Go);
        Go.setOnClickListener(this);
    }
    public void onClick(View V)
    {
        Feistel F=new Feistel();
        String Input;
        String Output;
        RadioButton Encrypt=(RadioButton)findViewById(R.id.radio_Encrypt);
        EditText e=(EditText)findViewById(R.id.text_Message);
        Input=e.getText().toString();
        e=(EditText)findViewById(R.id.text_Key);
        String Key=e.getText().toString();
        if(Encrypt.isEnabled())
            Output=F.encrypt(Input,Key);
        else
            Output=F.decrypt(Input,Key);
        TextView T=(TextView) findViewById(R.id.text_Output);
        T.setText(Output);

        ClipboardManager clipboard = (ClipboardManager)
                getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData c= ClipData.newPlainText("From app",Output);
        clipboard.setPrimaryClip(c);
        Toast.makeText(this, "Text Copied to clipboard", Toast.LENGTH_SHORT).show();
    }
}
