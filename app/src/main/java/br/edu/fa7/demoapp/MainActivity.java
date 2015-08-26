package br.edu.fa7.demoapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //recuperando a instancia do fragment support manager
        mFragmentManager = getSupportFragmentManager();

        //Criando e exibindo
        FragmentMain fragmentMain = new FragmentMain();
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_content, fragmentMain);
        fragmentTransaction.commit();
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

        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();

        switch (id){
            case R.id.action_settings:
                FragmentSettings fragmentSettings = new FragmentSettings();
                fragmentTransaction.replace(R.id.main_content, fragmentSettings);
                break;
            case android.R.id.home:
                FragmentMain fragmentMain = new FragmentMain();
                fragmentTransaction.replace(R.id.main_content, fragmentMain);
                break;
        }

        fragmentTransaction.commit();
        return true;
    }

//    @Override
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.settings_started_service:
//                break;
//
//            case R.id.settings_bounded_service_start:
//                break;
//
//            case R.id.settings_bounded_service_stop:
//                break;
//        }
//    }
}
