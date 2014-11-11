//Package
package com.gregorywlodarek.torontotransit.torontotransit;

//Imports
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


/**
 * Holds all the tabs that the user can swipe to horizontally.
 *
 * @version 1.0
 * @author Grzegorz Wlodarek
 */
public class TabPagerAdapter extends FragmentStatePagerAdapter
{

    //Instance variables
    private Favourites fav = new Favourites();
    private Find find = new Find();
    private Info info = new Info();
    private Nearby nearby = new Nearby();
    private FavouritesData fd = FavouritesData.createFavouritesData();

    /**
     * Default Constructor.
     *
     * @param fm Fragment Manager.
     */
    public TabPagerAdapter(FragmentManager fm)
    {
        super(fm);
    }

    /**
     * Returns the Fragment at the specified position (i).
     *
     * @param i The fragment spot.
     * @return the fragment at given i.
     */
    public Fragment getItem(int i)
    {
        switch (i)
        {
            case 0:
                //Subscribe this tab to FavouritesData to update the Favourites tab whenever
                //FavouritesData changes its state.
                fd.subscribe(fav);
                return fav;
            case 1:
                return find;
            case 2:
                return nearby;
            case 3:
                return info;
        }

        return null;

    }

    /**
     * Contains the number of fragments in the application.
     *
     * @return the number of fragments.
     */
    public int getCount()
    {
        return 4;
    }

}
