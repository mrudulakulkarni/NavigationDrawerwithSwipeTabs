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
public class StockFragment extends Fragment {


    public StockFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_stock,container,false);
        final ArrayList<Stocklist> stocks = new ArrayList<>();

        Stocklist s1= new Stocklist("Aban Offshore");
        Stocklist s2= new Stocklist("Assoc alcohol");
        Stocklist s3= new Stocklist("AxisBank");
        Stocklist s4= new Stocklist("NBCC");
        Stocklist s5= new Stocklist("Sbi");
        Stocklist s6= new Stocklist("YesBank");
        Stocklist s7= new Stocklist("TCS");

        stocks.add(s1);
        stocks.add(s2);
        stocks.add(s3);
        stocks.add(s4);
        stocks.add(s5);
        stocks.add(s6);
        stocks.add(s7);


        BindDictionary<Stocklist> dictionary= new BindDictionary<>();
        dictionary.addStringField(R.id.textname, new StringExtractor<Stocklist>() {
            @Override
            public String getStringValue(Stocklist stock1, int position) {
                return stock1.getName();
            }
        });

        FunDapter dapter= new FunDapter(StockFragment.this.getActivity(),stocks,R.layout.stock_layout,dictionary);
        ListView listview= (ListView)view.findViewById(R.id.stocklistview);

        listview.setAdapter(dapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Stocklist selecteditem = stocks.get(position);
                Toast.makeText(StockFragment.this.getActivity(),selecteditem.getName(),Toast.LENGTH_SHORT).show();

            }
        });


        return view;
    }
}
