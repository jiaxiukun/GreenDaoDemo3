package baway.com.greendaodemo3.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 贾秀坤 on 2017/11/15.
 */
@Entity
public class Been {
    @Id(autoincrement = true)
    private long id;
    private String name;
    @Transient //不储存在数据库中
    private int useMasage;
    @Generated(hash = 403737926)
    public Been(long id, String name) {
        this.id = id;
        this.name = name;
    }
    @Generated(hash = 385868016)
    public Been() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
