package baway.com.greendaodemo3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import baway.com.greendaodemo3.entity.Been;
import baway.com.greendaodemo3.gen.BeenDao;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mCount;
    private Button add;
    private Button delete;
    private Button updata;
    private Button find;
    private BeenDao beenDao;
    private Been been;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
        beenDao = MyApplication.getInstance().getDaoSession().getBeenDao();
    }

    private void initEvent() {
        add.setOnClickListener(this);
        delete.setOnClickListener(this);
        updata.setOnClickListener(this);
        find.setOnClickListener(this);
    }

    private void initView() {
        mCount = (TextView) findViewById(R.id.mCount);
        add = (Button) findViewById(R.id.button);
        delete = (Button) findViewById(R.id.button2);
        updata = (Button) findViewById(R.id.button3);
        find = (Button) findViewById(R.id.button4);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                addData();
                break;
            case R.id.button2:
                deleData();
                break;
            case R.id.button3:
                upData();
                break;
            case R.id.button4:
                findData();
                break;
        }
    }

    //查
    private void findData() {
        List<Been> list = beenDao.loadAll();
        String username = "";
        for (int i = 0; i < list.size(); i++) {
            username += list.get(i).getName();
        }
        mCount.setText("查询全部数据==》" + username);
    }

    //改
    private void upData() {
        been = new Been(0, "dongzhuo");
        beenDao.update(been);
        mCount.setText(been.getName());
    }

    private void deleteUsernameById(long id) {
        beenDao.deleteByKey(id);
    }

    //删
    private void deleData() {
        deleteUsernameById(0);
        //没有办法传到hellowworld
    }

    //增
    private void addData() {
        been = new Been(0, "lvbu");
        beenDao.insert(been); //增加一条

        mCount.setText(been.getName());
    }
}
