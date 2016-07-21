package org.konurbaev.myfirstapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MyActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "org.konurbaev.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        String message = sharedPref.getString(getString(R.string.edit_message_preference), null);
        EditText editText = (EditText)findViewById(R.id.edit_message);
        editText.setText(message);
    }

    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText)findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EditText editText = (EditText)findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(getString(R.string.edit_message_preference), message);
        editor.commit();
    }

    public void viewList(View view){
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }

    public void showArticles(View view) {
        Intent intent = new Intent(this, NewsArticlesActivity.class);
        startActivity(intent);
    }

}
