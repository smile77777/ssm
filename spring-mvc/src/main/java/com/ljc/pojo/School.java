package com.ljc.pojo;

public class School {
    private String name;
    private String addriss;

    public School() {
        System.out.println("School 构造方法执行ing");
    }

    public School(String name, String addriss) {
        this.name = name;
        this.addriss = addriss;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddriss() {
        return addriss;
    }

    public void setAddriss(String addriss) {
        this.addriss = addriss;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", addriss='" + addriss + '\'' +
                '}';
    }
}
