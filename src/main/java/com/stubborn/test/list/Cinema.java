package com.stubborn.test.list;

import java.util.Objects;

/**
 * @author 丁少东
 * @create 2018-06-08 上午10:49
 **/
public class Cinema {
    private String id;
    private String name;

    public Cinema() {
    }

    public Cinema(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cinema cinema = (Cinema) o;
        return Objects.equals(id, cinema.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
