package org.ace.web.bean;

/**
 * Created by xiaochenlong on 2015/12/27.
 */
public class Simple {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Simple{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
