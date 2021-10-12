package com.myduyen.baitaptuan4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.SeekBar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnClickListener{
    SeekBar mSeekBarTime, mSeekBarVol;
    static MediaPlayer sMediaPlayer;
    private Runnable mRunnable;
    int currentIndex = 0;
    RecyclerView rcv;
    CustomRecyclerView adt;
    List<Song> mSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcv = findViewById(R.id.rcv);
        mSongs = new ArrayList<Song>();

        mSongs.add(new Song("Nắng Có Còn Xuân","Mỹ Duyên",R.drawable.rectangle4,R.raw.nang_co_con_xuan));
        mSongs.add(new Song("Đã Từng","Hương Ly",R.drawable.rectangle2,R.raw.da_tung));
        mSongs.add(new Song("Cánh Hồng Phai ","Mỹ Hằng",R.drawable.rectangle3,R.raw.canh_hong_phai));
        mSongs.add(new Song("Tình Yêu Cao Thượng","Hương Lan",R.drawable.rectangle1,R.raw.tinh_yeu_cao_thuong));
        mSongs.add(new Song("Răng Khôn","Thu Diệp",R.drawable.rectangle1,R.raw.rang_khon));
        mSongs.add(new Song("Đã Từng","Huy Hoàng",R.drawable.rectangle2,R.raw.da_tung));
        adt = new CustomRecyclerView(mSongs,this);
        rcv.setHasFixedSize(true);
        rcv.setAdapter(adt);
        rcv.setLayoutManager(new GridLayoutManager(this,2));
    }

    @Override
    public void clickItem(Song song) {
        Intent intent  = new Intent(MainActivity.this,PlaySong.class);
        intent.putExtra("song",song);
        intent.putExtra("listMusic", (Serializable) mSongs);
        intent.putExtra("index",mSongs.indexOf(song));
        startActivity(intent);

    }
}