package com.example.shengbin.adenturetime;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.arasthel.asyncjob.AsyncJob;
import com.example.shengbin.adenturetime.json.*;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Episodes extends AppCompatActivity {
    ArrayList <Episode>episodes = new ArrayList<Episode>();
    DAOAdventuretimeDB db = new DAOAdventuretimeDB();
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episodes);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        db.mostrarEpisodes(getBaseContext(), episodes);
        System.out.println(episodes.size());



        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_episodes, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        ArrayList <Episode>episodes = new ArrayList<Episode>();
        DAOAdventuretimeDB db = new DAOAdventuretimeDB();
        ProgressDialog progress;

        Context context;
        int position ;


        public PlaceholderFragment() {
            this.context=getContext();
        }
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
                db.mostrarEpisodes(getContext(), episodes);
        }
        public void  past (){
             this.position= -1;

        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {

            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_episodes, container, false);

            position = getArguments().getInt(ARG_SECTION_NUMBER);

            ImageView atras = (ImageView)rootView.findViewById(R.id.atras);
            if(position == 1){
                atras.setVisibility(View.GONE);
            }else{

                atras.setVisibility(View.VISIBLE);
            }
            final int poscion = position -1;



            // Instanciem els objectes del layaot
            TextView titul = (TextView)rootView.findViewById(R.id.title);
            TextView descripcio = (TextView)rootView.findViewById(R.id.description);
            ImageView image = (ImageView)rootView.findViewById(R.id.imageView3);
            ListView list = (ListView)rootView.findViewById(R.id.listaPerson);
            titul.setText(episodes.get(poscion).getTitle());
            getActivity().setTitle("");
            descripcio.setText(episodes.get(poscion).getDescription());

            final ArrayList items = new ArrayList<>();
            final AdaptadorPersonalitzatCharacters adapter = new AdaptadorPersonalitzatCharacters(
                    getContext(),
                    R.layout.character_adapter_list,
                    items
            );
            new AsyncJob.AsyncJobBuilder<Boolean>()
                    .doInBackground(new AsyncJob.AsyncAction<Boolean>() {
                        @Override
                        public Boolean doAsync() {
                            db.mostrarEpisodeCharacter(getContext(),items,episodes.get(poscion).getId());
                            return true;
                        }
                    })
                    .doWhenFinished(new AsyncJob.AsyncResultAction() {
                        @Override
                        public void onResult(Object o) {
                            adapter.notifyDataSetChanged();

                        }
                    }).create().start();

            list.setAdapter(adapter);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent i = new Intent(getContext(), DetailsChacarter.class);
                    i.putExtra("item", adapter.getItem(position));
                    startActivity(i);

                }
            });
            Picasso.with(getContext())
                    .load(episodes.get(position-1).getTitleCard())
                    .fit()
                    .into(image);




            return rootView;
        }

    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position +1);
        }

        @Override
        public int getCount() {

            return 46;
        }

        public int getCount(int i) {

            return i;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
                case 3:
                    return "SECTION 4";
                case 4:
                    return "SECRION 5";
                case 5:
                    return "SECTION 6";
                case 6:
                    return "SECTION 7";
                case 7:
                    return "SECTION 8";
                case 8:
                    return "SECTION 9";
                case 9:
                    return "SECTION 10";
                case 10:
                    return "SECTION 11";
                case 11:
                    return "SECTION 12";
                case 12:
                    return "SECTION 13";
                case 13:
                    return "SECTION 14";

            }
            return null;
        }
    }
}
