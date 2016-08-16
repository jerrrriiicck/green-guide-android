package com.greenguide.dlsu.greenguide;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LpepD2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LpepD2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LpepD2 extends Fragment {

    RecyclerView recycler;
    ListAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lpep_d2, container, false);

        ArrayList<Schedule> list = new ArrayList();
        list.add(new Schedule("Registration","7:00AM"));
        list.add(new Schedule("Prayer Services","8:00AM"));
        list.add(new Schedule("Lasallian Module","8:15AM"));
        list.add(new Schedule("Movement to eating area","10:00AM"));
        list.add(new Schedule("AM Snacks","10:15AM"));
        list.add(new Schedule("Movement to classrooms","10:30AM"));
        list.add(new Schedule("Student Testimonial Videos\n" +
                "DO Module","10:45AM"));
        list.add(new Schedule("Movement to eating areas","12:00PM"));
        list.add(new Schedule("Lunch","12:10PM"));
        list.add(new Schedule("Movement to HSSH Grounds","1:10PM"));
        list.add(new Schedule("LAMBS Sponsors Program","1:30PM"));
        list.add(new Schedule("Learning the Alma Mater Song\n" +
                "Teaching of Lasallian Cheers","2:00PM"));
        list.add(new Schedule("CAO Presentation","3:30PM"));
        list.add(new Schedule("LPEP Party Celebration","4:10PM"));
        list.add(new Schedule("Movement to CSO Tour","4:30PM"));
        list.add(new Schedule("CSO Tour","4:40PM"));
        adapter = new ListAdapter(list);
        recycler = (RecyclerView) v.findViewById(R.id.lpepd2list);
        recycler.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(v.getContext());
        recycler.setLayoutManager(llm);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setAdapter(adapter);

        return v;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}