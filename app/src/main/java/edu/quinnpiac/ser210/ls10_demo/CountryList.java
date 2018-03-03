package edu.quinnpiac.ser210.ls10_demo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class CountryList extends ListFragment {

	CountryListListener myActivity;
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		myActivity = (CountryListListener) activity;
	}

	static interface CountryListListener{
	void itemClickedMoveToDetail(int countryId);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {	

        // Keys used in Hashmap
        String[] from = { "flag","txt","cur" };
        
        // Ids of views in listview_layout
        int[] to = { R.id.flag,R.id.txt,R.id.cur};        
        
        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), new Country().getAdaptorList(), R.layout.listview_layout, from, to);
		
		setListAdapter(adapter);
		
		return super.onCreateView(inflater, container, savedInstanceState);		
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		// call a method in myActivity to start an intent
		myActivity.itemClickedMoveToDetail(position);
	}
}
