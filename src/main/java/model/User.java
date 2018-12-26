package model;

import java.sql.Timestamp;
import java.util.Date;

public class User {
    private Integer id;
    private String name;
    private Timestamp createTime;
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }


    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString(){
        return "{"+
                "id"+id+
                "name"+name+
                "createTime"+createTime+
                "status"+status+
                "}";
    }
}
