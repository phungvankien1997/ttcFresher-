package com.example.myapplication;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    @BindView(R.id.input)
    EditText input;
    @BindView(R.id.btnSum)
    Button btnSum;
    @BindView(R.id.showResurl)
    TextView showResurl;
    @BindView(R.id.listData)
    TextView listData;
    @BindView(R.id.listDataAfter)
    TextView listDataAfter;

    private int tong1 = 0 ;
    private int tong2 = 0 ;
    private int list[] = {1,8,7,6,9} ;
    private int k = 0 ;
    private List<Bill> listBill = new ArrayList<>() ;
    public static final char SPACE = ' ';
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int k = Integer.valueOf(input.getText().toString().trim());
        input.setInputType(InputType.TYPE_CLASS_NUMBER |
                InputType.TYPE_NUMBER_VARIATION_NORMAL);
//      sắp xếp mảnh theo giá trị tăng dần
      homeWord2();
      homeWord34();
      homeWord56();
      homeWordString12();
      homeWordString345();
      homeWordDateTime();
    }
    private void homeWordDateTime()  {
//        bai 1 :
        String dtStart = "2019-09-23 21:17:37";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        Date date2 = null;
        try {
            Date date = format.parse(dtStart);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            date2 = format.parse(dtStart);
        } catch (ParseException e) {
            e.printStackTrace();
        }
// bai tap 2

        Calendar calendar =Calendar.getInstance() ;
        calendar.setTime(date2);
//         ngay dau tien cua thang
        calendar.add(Calendar.DAY_OF_MONTH,calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        date2 = calendar.getTime() ;

//         ngay cuoi cung cua tnga
        calendar.add(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        date2=calendar.getTime() ;

//        ngay dau tuan trong thang
        calendar.add(Calendar.DAY_OF_MONTH,Calendar.MONDAY - calendar.get(Calendar.DAY_OF_WEEK));

//         nagy do cong them 100 ngay
        calendar.add(Calendar.DAY_OF_MONTH ,100);
        date2 = calendar.getTime() ;

//         hien thi ngay
         String  showDay =  format2.format(date2);

//          bai tap 3
        String a = "2019-09-01" ;
        String b = "2019-09-23" ;
        Date fromDate = null ;
        Date toDate = null;
//        format lai day
        try {
            a= format.format(format2.parse(a));
            b= format.format(format2.parse(b));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
             fromDate = format2.parse(a);
             toDate = format2.parse(b);

        } catch (ParseException e) {
            e.printStackTrace();
        }

//         tinh ra han thoi gian luon
        long k = (getHourZero(toDate.getTime()) - getHourZero(fromDate.getTime())) / (1000 * 60 * 60 * 24);
        if(k>0){
//             ngay b lon hon a
        }else {
//             ngay a lon hon hoac bang ngay b
        }


// bai 4 em ko hieu la tinh tong so ngay a va b hay ntn ạ , neu tinh hieu giua 2  ngay
        long getDiff = fromDate.getTime() - toDate.getTime();
//         ket qua tinh theo ngay
        long getDaysDiff = getDiff / (24 * 60 * 60 * 1000);

//         bai 5,6,7 em skip duoc khong anh oi
    }
    private static long getHourZero(long timeStamp) {
        return timeStamp - ((timeStamp + 25200000) % 86400000);
    }

    private void  homeWordString345(){
        List<String> listDataCutString = new ArrayList<String>();
        listDataCutString.add("Java");
        listDataCutString.add("C++");
        listDataCutString.add("PHP");
        listDataCutString.add("Android");

        String ghepchuoi = "";

        for (int i = 0; i<listDataCutString.size() ; i++) {
            if(i== listDataCutString.size() -1){
                ghepchuoi= ghepchuoi+ listDataCutString.get(i);
            }else {
                ghepchuoi= ghepchuoi+listDataCutString.get(i)+",";
            }
        }

        listDataCutString.clear();

        String[] separated = ghepchuoi.split(",");
        for (String item : separated){
            listDataCutString.add(item);
        }

//        bai tap 5 :
        String raw= " i am fresher" ;
        String from = " fresher" ;
        String to = "senior";
        raw.replace(from,to);
    }
    private void homeWordString12(){
//         bai tap 1
        String data = "phung van kien kien 1997 kien @gmailcom" ;
        String characters = "n" ;
        int count = 0 ;
// so lan xuat hien  ky tu trong chuoi
        for (int i = 0; i <data.length() ; i++) {
            if (characters.equals(data.charAt(i))) {
                count++ ;
            }
        }
//         vi tri ky tu cuoi cung
        int last = data.lastIndexOf(characters) ;
//         vi tri dau tien
        int begin = data.indexOf(characters);

//         bai tap 2: ky tu xuat hien nhieu nhat
        int max =0 ;
        String kytuxuathiennhieunhat ="";

        for (int i = 0; i <data.length() ; i++) {
            int solanxuathien =0 ;
            for (int j = 0; j <data.length() ; j++) {
             if(data.charAt(i) == data.charAt(j)){
                 solanxuathien++ ;
             }
            }
            if(max<solanxuathien){
                max = solanxuathien ;
                kytuxuathiennhieunhat = String.valueOf(data.charAt(i));
            }
        }
//        dem so lan xuat hien cac chuoi con trong chuoi
        Map<String, Integer> wordMap = countWords(data);
        for (String key : wordMap.keySet()) {

            Log.i("ketqua", "key + \" \" + wordMap.get(key) + \"\\n");
        }
    }
    public static Map<String, Integer> countWords(String input) {
        // khởi tạo wordMap
        Map<String, Integer> wordMap = new TreeMap<String, Integer>();
        if (input == null) {
            return wordMap;
        }
        int size = input.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (input.charAt(i) != SPACE) {
                // build một từ
                sb.append(input.charAt(i));
            } else {
                // thêm từ vào wordMap
                addWord(wordMap, sb);
                sb = new StringBuilder();
            }
        }
        // thêm từ cuối cùng tìm được vào wordMap
        addWord(wordMap, sb);
        return wordMap;
    }
    public static void addWord(Map<String, Integer> wordMap, StringBuilder sb) {
        String word = sb.toString();
        if (word.length() == 0) {
            return;
        }
        if (wordMap.containsKey(word)) {
            int count = wordMap.get(word) + 1;
            wordMap.put(word, count);
        } else {
            wordMap.put(word, 1);
        }
    }


    private void  homeWord56(){
        initData();
//         bai tap 5 , cac bill co tien hon 10000
        List<Bill> bill10000 = new ArrayList<>();
        for (Bill item : listBill){
            if(item.getMoney() >10000){
                bill10000.add(item);
            }
        }
//         bai tap 6 : key la ngay , value la cac bill cung ngay
        HashMap<String, HashSet<Bill>> hashmap = new HashMap<String, HashSet<Bill>>();

         for(Bill item :listBill){
             if (hashmap.containsKey(item)) {
                 // teleId da co thi chi get ra va add them
                 hashmap.get(item.getDate()).add( item);
             } else {
                 // add teleId moi tao moi hashSet , add hashSet ,put vao hashMap
                 HashSet<Bill> bill = new HashSet<>();
                 bill.add(item);
                 hashmap.put(item.getDate(),bill);
             }
         }
// bai tap 7 va 8 em khong hieu de bai a



    }
    private void homeWord2(){
        int bientrunggian = 0 ;
        String chuoimang1 = "" ;
        for (int i = 0; i < list.length ; i++) {
            chuoimang1 = chuoimang1+list[i] +"," ;
        }
        listData.setText(chuoimang1);
        for (int i = 0; i < list.length -1 ; i++) {
            for (int j = i+1; j <list.length ; j++) {
                if(list[i]>list[j]){
//                    xu ly neu so truoc lon so sau thi doi vi tri
                    bientrunggian = list[j] ;
                    list[j] = list[ i] ;
                    list[i] = bientrunggian ;
                }
            }
        }

        for (int i = 0; i < list.length ; i++) {
            chuoimang1 = chuoimang1+list[i] +"," ;
        }
        listDataAfter.setText(chuoimang1);
    }
    private void homeWord34(){
         initData();
//         sắp xếp danh sách theo money tăng dần
        Collections.sort(listBill, new Comparator<Bill>() {
            @Override
            public int compare(Bill o1, Bill o2) {
                if(o1.getMoney() < o2.getMoney()){
                    return -1 ;
                }else {
                    if(o1.getMoney() ==o2.getMoney()){
                        return  0 ;
                    }else {
                        return 1 ;
                    }
                }
            }
        });


//         lap danh sach distinct  ngày lập hóa đơn
        List<String> day = new ArrayList<>();
        List<Bill> billClone = new ArrayList<>();


        for (int i = 0; i < listBill.size(); i++) {
            if (!billClone.contains(listBill.get(i))) {
                billClone.add(listBill.get(i));
            }
        }
        listBill.clear();
        listBill.addAll(billClone);
//        danh sach ngay ko trung nhau
        for(Bill numberBill : listBill){
            day.add(numberBill.getDate()) ;
        }

    }
    @SuppressLint("StringFormatMatches")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSum:

//             kienpv bai toan 1 , tinh tong theo 2 thuat toan
                for (int i = 0; i < k ; i++) {
                    tong1 +=i;
                }
                tong2 = k*(k+1)/2 ;
                showResurl.setText(getString(R.string.resurl,k)+" "+tong1);
                break;
        }
    }
    public void initData(){
          listBill = new ArrayList<>() ;
          listBill.add(new Bill(1,"kienpv",2000,"2019/01/01"));
          listBill.add(new Bill(2,"kienpv",1999,"2019/03/01"));
          listBill.add(new Bill(3,"kienpv",2001,"2019/03/01"));
          listBill.add(new Bill(4,"kienpv",20000,"2019/01/05"));
          listBill.add(new Bill(5,"kienpv",10000,"2019/01/04"));
    }
}
