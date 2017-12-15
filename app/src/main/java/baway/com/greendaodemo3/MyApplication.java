package baway.com.greendaodemo3;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import baway.com.greendaodemo3.gen.DaoMaster;
import baway.com.greendaodemo3.gen.DaoSession;

/**
 * Created by 贾秀坤 on 2017/11/15.
 */

public class MyApplication extends Application {
    private static MyApplication instance;
    private DaoMaster.DevOpenHelper helper;
    private SQLiteDatabase db;
    private DaoMaster daoMaster;
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        setData();
    }

    /**
     * 设置greendao
     */
    private void setData() {
        //通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象
        helper = new DaoMaster.DevOpenHelper(this, "beatiful-db", null);
        //写的权限
        db = helper.getWritableDatabase();
        //该数据库指的是daomaster,所以多个session指的同一个数据库链接
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public static MyApplication getInstance() {
        return instance;
    }

    public SQLiteDatabase getDb() {
        return db;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
