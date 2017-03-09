package com.example.admin.navigationdrawerwithswipetabs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.amigold.fundapter.BindDictionary;
import com.amigold.fundapter.FunDapter;
import com.amigold.fundapter.extractors.StringExtractor;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class SummaryFragment extends Fragment {


    public SummaryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =inflater.inflate(R.layout.fragment_summary,container,false);
        final ArrayList<Summarylist> summary= new ArrayList<>();

        Summarylist s1= new Summarylist("Stocks");
        Summarylist s2= new Summarylist("MutualFunds");
        Summarylist s3= new Summarylist("Ulip");
        Summarylist s4= new Summarylist("Bullion");
        Summarylist s5= new Summarylist("Loans");
        Summarylist s6= new Summarylist("Property");
        Summarylist s7= new Summarylist("Assets");

        summary.add(s1);
        summary.add(s2);
        summary.add(s3);
        summary.add(s4);
        summary.add(s5);
        summary.add(s6);
        summary.add(s7);

        BindDictionary<Summarylist> dictionary= new BindDictionary<>();
        dictionary.addStringField(R.id.textname, new StringExtractor<Summarylist>() {
            @Override
            public String getStringValue(Summarylist summary1, int position) {
                return summary1.getName();
            }
        });

        FunDapter dapter= new FunDapter(SummaryFragment.this.getActivity(),summary,R.layout.summary_layout,dictionary);
        ListView listview= (ListView)view.findViewById(R.id.summarylistview);

        listview.setAdapter(dapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Summarylist selecteditem = summary.get(position);
                Toast.makeText(SummaryFragment.this.getActivity(),selecteditem.getName(),Toast.LENGTH_SHORT).show();

            }
        });


        return view;
    }

}
