package com.greenguide.dlsu.greenguide;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;
import com.greenguide.dlsu.greenguide.data.model.Spot;
import com.greenguide.dlsu.greenguide.data.stored.PrintingSpot;

import java.util.ArrayList;
import java.util.List;

public class Printing extends AppCompatActivity {


    private Toolbar toolbar;
    private RecyclerView recycler;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_printing);
        recycler = (RecyclerView) findViewById(R.id.printinglist);
        recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recycler.setHasFixedSize(true);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        title = (TextView) findViewById(R.id.printingtitle);
        String fontPath = "fonts/Montserrat-Regular.ttf";
        Typeface tf = Typeface.createFromAsset(getBaseContext().getAssets(), fontPath);
        title.setTypeface(tf);

        setTitle("");

        List<ExpandableParentListItem> expandableParentListItems = new ArrayList<>();
        List<ParentListItem> parentListItems = new ArrayList<>();
        expandableParentListItems.add(new ExpandableParentListItem("Manila Campus"));
        List<ExpandableChildListItem> childItemList = new ArrayList<>();
        for(Spot s : PrintingSpot.getInstance().getPrintingMnlList()){
            childItemList.add( new ExpandableChildListItem(s.getName(), s.getDescription()));
        }
        expandableParentListItems.get(0).setChildItemList(childItemList);
        parentListItems.add(expandableParentListItems.get(0));

        expandableParentListItems.add(new ExpandableParentListItem("STC Campus"));
        List<ExpandableChildListItem> childItemList1 = new ArrayList<>();
        for(Spot s : PrintingSpot.getInstance().getPrintingStcList()){
            childItemList1.add(new ExpandableChildListItem(s.getName(), s.getDescription()));
        }
        expandableParentListItems.get(1).setChildItemList(childItemList1);
        parentListItems.add(expandableParentListItems.get(1));


        expandableParentListItems.add(new ExpandableParentListItem("Outside DLSU"));
        List<ExpandableChildListItem> childItemList2 = new ArrayList<>();
        for(Spot s : PrintingSpot.getInstance().getPrintingOffList()){
            childItemList2.add(new ExpandableChildListItem(s.getName(), s.getDescription()));
        }
        expandableParentListItems.get(2).setChildItemList(childItemList2);
        parentListItems.add(expandableParentListItems.get(2));


        ExpandableAdapter adapter = new ExpandableAdapter(getBaseContext(), parentListItems);
        recycler.setAdapter(adapter);


    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
