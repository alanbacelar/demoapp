package br.edu.fa7.demoapp;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by posgrad on 19/08/2015.
 */
public class FragmentMain extends Fragment implements RecyclerViewOnClickListener, AdapterView.OnItemClickListener {

    private Toolbar mMainToolBar;
    private AppCompatActivity mMainActivity;
    private RecyclerView mRecyClerView;
    private PersonAdapter adapter;
    private  List<Person> list = new ArrayList<>();
    private ListView navMenu;
    private DrawerLayout drawerLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        mMainActivity = (AppCompatActivity) getActivity();

        mMainToolBar = (Toolbar) mMainActivity.findViewById(R.id.main_toolbar);
        mMainToolBar.setTitle("Demo App");
        mMainToolBar.setSubtitle("Main Activity");
        mMainToolBar.setLogo(R.mipmap.ic_launcher);
        mMainActivity.setSupportActionBar(mMainToolBar);
        mMainActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        List<String> navMenuList = new ArrayList<>();
        navMenuList.add("item 1");
        navMenuList.add("item 2");
        navMenuList.add("item 3");

        navMenu = (ListView) mMainActivity.findViewById(R.id.nav_drawer_menu);
        navMenu.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, navMenuList));

        navMenu.setOnItemClickListener(this);

        drawerLayout = (DrawerLayout) mMainActivity.findViewById(R.id.drawer_layout);


        for (int i = 0; i < 100; i++){
            Integer count = new Integer(i);
            String nome = "João "+count.toString();
            list.add(new Person(nome, "joao@acme.com", R.mipmap.ic_launcher));
        }


        LinearLayoutManager llm = new LinearLayoutManager(mMainActivity);
        adapter = new PersonAdapter(list, mMainActivity);

        adapter.setListener(this);

        mRecyClerView = (RecyclerView) v.findViewById(R.id.fragment_main_recyclerview);

        mRecyClerView.setAdapter(adapter);
        mRecyClerView.setLayoutManager(llm);

        return v;
    }

    @Override
    public void onClick(View v, int position) {

        if(position != -1) {
            Person person = list.remove(position);
            adapter.notifyItemRemoved(position);
            Toast.makeText(getActivity(), "Removido " + person.getName(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        android.support.v4.app.FragmentTransaction fragmentTransaction =
                mMainActivity.getSupportFragmentManager().beginTransaction();

        switch (position){
            case 0:
                FragmentSettings fragmentSettings = new FragmentSettings();
                fragmentTransaction.replace(R.id.main_content, fragmentSettings);

                break;
            case 1:
                break;
            case 2:
                break;

        }
        drawerLayout.closeDrawers();
        fragmentTransaction.commit();
    }
}