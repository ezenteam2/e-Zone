package com.example.ezone;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_qna  extends AppCompatActivity {

    ListView qnaListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ht_user_m_qna);

        qnaListView = (ListView)findViewById(R.id.qnaListView);

        dataSettingQna();
    }

    private void dataSettingQna(){
        Adapter_qna adapter = new Adapter_qna();

        adapter.addItem("공지사항",
                "CCTV 설치 및 운영에 대한 스페이스클라우드의 권고안을 확인해주세요.",
                "안녕하세요, 이용자 여러분.\n" +
                        "스페이스클라우드 팀 입니다.\n" +
                        "지난 1일, 뉴스 매체를 통해 파티룸 내 CCTV 촬영 갈등 이슈 보도가 있었습니다. \n" +
                        "이용자의 개인정보보호 이슈와 CCTV 설치 목적 및 위치에 대한 갈등이 제기 되었고, \n" +
                        "개인정보를 엄중하게 보호하고 운영해야 할 의무를 갖고 있음을 다시 한번 숙지하게 되었습니다.");
        adapter.addItem("공지사항",
                "[조치완료] 현재 서비스 내 예약이 불가한 사항이 접수되어 조치중입니다",
                "안녕하세요, \n" +
                        "스페이스클라우드 운영팀입니다.\n" +
                        "현재 스페이스클라우드 서비스 내에서 예약시,\n" +
                        "예약이 불가한 현상이 발생하여 긴급조치중에 있습니다.\n" +
                        "감사합니다.");
        adapter.addItem("공지사항",
                "[종료] 서버 점검 안내 (1월 21일 20시 30분 ~ 21시 30분)",
                "안녕하세요, 이용자님.\n" +
                        "스페이스클라우드 운영팀 입니다.\n" +
                        "스페이스클라우드의 원활한 서비스 제공을 위해\n" +
                        "서버 점검이 진행됩니다.\n" +
                        "일시 : 20년 1월 21일 20시 30분 ~ 21시 30분");
        adapter.addItem("공지사항",
                "[공지] eZone 운영정책 일부 개정 안내",
                "안녕하세요. eZone 운영정책을 일부 개정하게 되어 안내드립니다. ◼︎ 약관 개정 세부 내용 제 5조 쿠폰 항목 신설\n" +
                        "1) 이용 금액을 할인 받을 수 있는 할인권을 말합니다. 쿠폰 종류 및 내용은 회사의 정책에 따라 달라질 수 있습니다.\n");
        adapter.addItem("공지사항",
                "[공지] 법인 카드 결제관련 안내",
                "안녕하세요, 스페이스클라우드 팀입니다.\n" +
                        "단체나 기업의 공간 이용 결제에 대한 카드사용(법인카드 결제)에 대해 안내드립니다.\n" +
                        "(일부 용도 제한 카드는 사용이 불가능할 수 있습니다.)");

        qnaListView.setAdapter(adapter);
    }


}
