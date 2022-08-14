package day11;

public class Student {

//    @Override
//    public String toString() {
//        return "hello";
//    }
    public static void main(String[] args) {
        Student student = new Student();
        //获取类加载器
        System.out.println(student.getClass().getClassLoader());
        //
//        System.out.println(student.toString());

    }
}
