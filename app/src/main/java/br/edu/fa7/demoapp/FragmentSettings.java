package br.edu.fa7.demoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by posgrad on 19/08/2015.
 */
public class FragmentSettings extends Fragment implements View.OnClickListener {

    private Toolbar mMainToolBar;
    private AppCompatActivity mMainActivity;
    private Button mStartedService;
    private Button mStartBoundedService;
    private Button mStopBoundedService;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_settings, container, false);

        mMainActivity = (AppCompatActivity)getActivity();

        mMainToolBar = (Toolbar) mMainActivity.findViewById(R.id.main_toolbar);
        mMainToolBar.setTitle("Settings");
        mMainToolBar.setLogo(null);
        mMainActivity.setSupportActionBar(mMainToolBar);
        mMainActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mStartedService = (Button) v.findViewById(R.id.settings_started_service);
        mStartBoundedService = (Button) v.findViewById(R.id.settings_bounded_service_start);
        mStopBoundedService = (Button) v.findViewById(R.id.settings_bounded_service_stop);

        mStartedService.setOnClickListener(this);
        mStartBoundedService.setOnClickListener(this);
        mStopBoundedService.setOnClickListener(this);


        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.settings_started_service:
                Intent it = new Intent(getActivity(), StartedService.class);
                getActivity().startService(it);

                break;

            case R.id.settings_bounded_service_start:
                break;

            case R.id.settings_bounded_service_stop:
                break;
        }
    }
}
