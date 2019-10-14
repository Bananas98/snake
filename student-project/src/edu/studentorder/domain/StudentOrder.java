package edu.studentorder.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StudentOrder {
    private long studentOrderId;
    private Adult husbent;
    private  Adult wife;
    private List<Child>  children;

    public long getStudentOrderId() {
        return studentOrderId;
    }

    public void setStudentOrderId(long studentOrderId) {
        this.studentOrderId = studentOrderId;
    }

    public Adult getHusbent() {
        return husbent;
    }

    public void setHusbent(Adult husbent) {
        this.husbent = husbent;
    }

    public Adult getWife() {
        return wife;
    }

    public void setWife(Adult wife) {
        this.wife = wife;
    }

    public void addChild(Child child){
        if (children == null){
            children = new ArrayList<>(5 );
        }
        children.add(child);
    }
    public List<Child> getChild() {
            return children;
    }
}
