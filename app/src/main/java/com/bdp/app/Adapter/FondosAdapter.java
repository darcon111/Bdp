package com.bdp.app.Adapter;


import com.bdp.app.Fragment.AcreditarFragment;
import com.bdp.app.Fragment.RenovarFragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

/**
 * Created by Belal on 2/3/2016.
 */
//Extending FragmentStatePagerAdapter
public class FondosAdapter extends FragmentStatePagerAdapter {

    //integer to count number of tabs
    int tabCount;
    private int ITEM_ONE=1;


    //Constructor to the class
    public FondosAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                RenovarFragment tab1 = new RenovarFragment();
                return tab1;
            case 1:
                AcreditarFragment tab2 = new AcreditarFragment();
                return tab2;
            default:
                return null;
        }
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Usuarios1";
            case 1:
                return "Usuarios2";

            default:
                return null;
        }
    }
}