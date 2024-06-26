package a.practice.b1firebaseapp;

public class Student {

    String docId;
    String name;
    int age;

    public Student(String docId, String name, int age) {
        this.docId = docId;
        this.name = name;
        this.age = age;
    }

    public Student() {
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
