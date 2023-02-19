package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvdanhsach;
    EditText edtnt,edtnd;
    Button btnthem,btnsua,btnxoa;
    int vitri;
    int img1=R.drawable.ic_baseline_wb_sunny_24;
    int img2=R.drawable.dam;
    int img3=R.drawable.ic_baseline_severe_cold_24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvdanhsach =findViewById(R.id.lvdanhsach);
        edtnt =findViewById(R.id.edtnt);
        edtnd=findViewById(R.id.edtnd);
        btnxoa=findViewById(R.id.btnxoa);
        btnsua=findViewById(R.id.btnsua);
        btnthem=findViewById(R.id.btnthem);
        ArrayList<Thoi_tiet> wether;
        wether=new ArrayList<>();
       wether.add(new Thoi_tiet(img1,"today","30"));
        wether.add(new Thoi_tiet(R.drawable.ic_baseline_wb_sunny_24,"today","30"));
        wether.add(new Thoi_tiet(R.drawable.ic_baseline_wb_sunny_24,"today","30"));
//        wether.add(new Thoi_tiet(R.drawable.ic_baseline_wb_sunny_24,"today",30));
//        wether.add(new Thoi_tiet(R.drawable.ic_baseline_wb_sunny_24,"today",30));
//        wether.add(new Thoi_tiet(R.drawable.ic_baseline_wb_sunny_24,"today",30));
//
        MyAdapter adapter=new MyAdapter(MainActivity.this,wether);
        lvdanhsach.setAdapter(adapter);
        lvdanhsach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                edtnt.setText(wether.get(i).getNgay());
                edtnd.setText(wether.get(i).getNhietDo());
                vitri=i;
            }
        });
       lvdanhsach.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
           @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                Bundle bd=new Bundle();
               bd.putInt("key3",wether.get(i).getIdAnh());
               bd.putString("key1",wether.get(i).getNgay());
                bd.putString("key2", String.valueOf(wether.get(i).getNhietDo()));
                intent.putExtras(bd);
                startActivity(intent);

                return false;
            }
        });
        btnsua.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View v) {
                int nd = Integer.parseInt(edtnd.getText().toString());
                String nt=edtnt.getText().toString();
                if(nd>=30) {
                    wether.set(vitri, new Thoi_tiet(img1, nt, String.valueOf(nd)));
                    adapter.notifyDataSetChanged();
                    edtnt.getText().clear();
                    edtnd.getText().clear();
                }
                else if (20<=nd&&nd<30) {
                    wether.set(vitri, new Thoi_tiet(img2, nt, String.valueOf(nd)));
                    edtnt.getText().clear();
                    edtnd.getText().clear();
                    adapter.notifyDataSetChanged();

                }
                else {
                    wether.set(vitri, new Thoi_tiet(img3, nt, String.valueOf(nd)));
                    edtnt.getText().clear();
                    edtnd.getText().clear();
                    adapter.notifyDataSetChanged();

                }

            }
      });
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nd = Integer.parseInt(edtnd.getText().toString());
                String nt=edtnt.getText().toString();

                if (nd>=30) {
                      wether.add(new Thoi_tiet(img1,nt,String.valueOf(nd)));
                    edtnt.getText().clear();
                    edtnd.getText().clear();
                    adapter.notifyDataSetChanged();
                }
                else if (20<=nd&&nd<30) {
                    wether.add(new Thoi_tiet(img2,nt,String.valueOf(nd)));
                    edtnt.getText().clear();
                    edtnd.getText().clear();
                    adapter.notifyDataSetChanged();

                }
                else {
                     wether.add(new Thoi_tiet(img3,nt,String.valueOf(nd)));
                     edtnt.getText().clear();
                     edtnd.getText().clear();
                     adapter.notifyDataSetChanged();

                 }


            }
       });
       btnxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public
                void onClick(View v) {
                showDeleteDialog();
                wether.remove(wether.get(vitri));
                edtnt.getText().clear();
                edtnd.getText().clear();
               adapter.notifyDataSetChanged();
            }
        });

   }
    private void showDeleteDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete")
                .setMessage("Are you sure you want to delete?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // xử lý xóa ở đây
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
        // Create the AlertDialog object and return it
        builder.create().show();
    }


    private class OnClickListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {

        }
    }


}

