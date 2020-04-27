package com.example.ezone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter_qna extends BaseAdapter {

    private ArrayList<LVModule_qna> arr = new ArrayList<LVModule_qna>();

    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public LVModule_qna getItem(int position) {
        return arr.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Context context = parent.getContext();

        /* 'listview_custom' Layout을 inflate하여 convertView 참조 획득 */
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.unit_qna, parent, false);
        }

        /* 'listview_custom'에 정의된 위젯에 대한 참조 획득 */
        TextView qna_cate = (TextView)convertView.findViewById(R.id.qna_cate);
        TextView qna_title = (TextView)convertView.findViewById(R.id.qna_title) ;
        TextView qna_detail = (TextView)convertView.findViewById(R.id.qna_detail) ;

        /* 각 리스트에 뿌려줄 아이템을 받아오는데 mMyItem 재활용 */
        LVModule_qna f1 = getItem(position);
        System.out.println(position+"getView실행");
        /* 각 위젯에 세팅된 아이템을 뿌려준다 */
        qna_cate.setText(f1.getQna_cate());
        qna_title.setText(f1.getQna_title());
        qna_detail.setText(f1.getQna_detail());

        /* (위젯에 대한 이벤트리스너를 지정하고 싶다면 여기에 작성하면된다..)  */


        return convertView;
    }

    /* 아이템 데이터 추가를 위한 함수. 자신이 원하는대로 작성 */
    public void addItem(String qna_cate, String qna_title, String qna_detail) {

        System.out.println("add Item실행");
        LVModule_qna f1 = new LVModule_qna(qna_cate, qna_title, qna_detail);

        /* mItems에 MyItem을 추가한다. */
        arr.add(f1);
    }

}
