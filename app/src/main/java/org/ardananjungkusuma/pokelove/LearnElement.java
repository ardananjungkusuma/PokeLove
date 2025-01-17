package org.ardananjungkusuma.pokelove;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LearnElement#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LearnElement extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private TextView newsFlash;
    private LinearLayout newsCard;

    public LearnElement() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LearnElement.
     */
    public static LearnElement newInstance(String param1, String param2) {
        LearnElement fragment = new LearnElement();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_learn_element, container, false);
        newsFlash = (TextView)view.findViewById(R.id.newsFlash);
        newsCard = (LinearLayout)view.findViewById(R.id.newsCard);
        String news1 = "[---News Flash---] Hello Trainer! Do you want to see Element Chart? Click Here!!!";
        newsFlash.setText(news1);
        newsFlash.setSelected(true);
        newsFlash.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        newsFlash.setSingleLine();
        newsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ElementChart.class);
                startActivity(intent);
            }
        });
        return view;
    }
}