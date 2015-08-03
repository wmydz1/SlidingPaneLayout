package com.logoocc.slidingpanelayout.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.logoocc.slidingpanelayout.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by samchen on 8/3/15.
 */
public class MenuFragment extends Fragment {

    private View v;
    private CircleView civPhoto;
    private TextView tvNick;
    private ListView lvItems;
    private List<Map<String, Object>> data;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (v == null) {
            v = inflater.inflate(R.layout.layout_menu, null);
            civPhoto = (CircleView) v.findViewById(R.id.menu_photo);
            tvNick = (TextView) v.findViewById(R.id.menu_nick);
            lvItems = (ListView) v.findViewById(R.id.menu_items);
            tvNick.setText("samchen");
            loadData();
            SimpleAdapter adapter = new SimpleAdapter(getActivity(),data,
                    R.layout.layout_menu_item,new String[]{"icn","title"},
                    new int[]{R.id.menu_item_icn,R.id.menu_item_title});
            lvItems.setAdapter(adapter);
        }


        ViewGroup parent = (ViewGroup) v.getParent();
        if (parent != null) {
            parent.removeView(v);
        }

        return v;

    }

    private void loadData() {

        data = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("icn", R.mipmap.icn1);
        map.put("title", "签到");
        data.add(map);

        map =new HashMap<String, Object>();
        map.put("icn", R.mipmap.icn2);
        map.put("title", "我的钻石");
        data.add(map);

        map =new HashMap<String, Object>();
        map.put("icn", R.mipmap.icn3);
        map.put("title", "我的图书");
        data.add(map);

        map =new HashMap<String, Object>();
        map.put("icn", R.mipmap.icn4);
        map.put("title", "我的消息");
        data.add(map);

        map =new HashMap<String, Object>();
        map.put("icn", R.mipmap.icn5);
        map.put("title", "我的朋友");
        data.add(map);

        map =new HashMap<String, Object>();
        map.put("icn", R.mipmap.icn6);
        map.put("title", "我的画作");
        data.add(map);

    }

}
