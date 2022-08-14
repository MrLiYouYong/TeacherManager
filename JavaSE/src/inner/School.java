package inner;

import jdk.dynalink.beans.StaticClass;

import java.sql.SQLOutput;

//public class School {
//    public int no = 1;
//    private String name = "山东科技大学";
//
//    class Teacher{
//        //2
//        private String teacher_name = "张三";
//        private int no = 001;
//        public int id = 01;
//        public void print(){
//            System.out.println("我是"+name+"的老师"+teacher_name+"，我的编号："+no);//1
//            System.out.println(this.no+School.this.no);//③
//            School.this.use1();
//        }
//    }
//
//    public static void main(String[] args) {
//        School school = new School();
//        school.use1();
//    }
//    public void use1() {
//        System.out.println();
//        Teacher teacher = new Teacher();//①
//        teacher.print();
//    }
//}
//class OtherSchool{
//    School.Teacher teacher1 = new School().new Teacher();//②
//}


//public class School {
//    public int no = 1;
//    private String name = "山东科技大学";
//    private static String name1 = "山东科技大学1";
//    private static int no1 = 2;
//
//    static class Teacher{
//        private String teacher_name = "张三";
//        private int no = 001;
//        public int id = 01;
//        public void print(){
//            System.out.println("我是"+name1+"的老师"+teacher_name+"，我的编号："+no);//1
//        }
//    }
//
//    public void use1() {
//        System.out.println();
//        Teacher teacher = new Teacher();//①
//        teacher.print();
//    }
//
//    public static void main(String[] args) {
//        School school = new School();
//        school.use1();
//    }
//}
//class OtherSchool{
//    School.Teacher teacher1 = new School.Teacher();//②
//}

//public class School {
//    public int no = 1;
//    private String name = "山东科技大学";
//
//    public void function(String str) {
//        /** 局部内部类Inner*/
//
//        class Inner {//2
//
//            private int no1 = 0;
//            private String name = "山东科技大学1";
//            public void print() {
//                System.out.println(no);//1
//                System.out.println(name);
//                System.out.println(School.this.name);//1
//                System.out.print(str);
//                System.out.println("局部内部类...");
//            }
//        }
//        //4(在局部内部类上面定义会报错)
//        Inner inner = new Inner();
//        inner.print();
//    }
//
//    public static void main(String[] args) {
//
//        School school = new School();
//        school.function("我正在访问一个");
//    }
//}

interface Teacher {
    String sayHello(String name);
    void print();
}

public class School{
    private int no = 1;
    public final int id = 1;
    private String name = "山东科技大学";

    public  void main(String[] args) {
        //实现上面的接口创建了一个匿名内部类
        final int i = 1;
        int j = 19;
        Teacher teacher = new Teacher() {
            String name = "匿名内部类";
            public void print(){
                System.out.println(i);
                System.out.println(j);
                School school = new School();
                System.out.println(school.no);
                System.out.println(School.this.no);
                System.out.println(name);
            }
            public String sayHello(String name) { return "hello, " + name ; }
        };
        System.out.println(teacher.sayHello("leo"));
        teacher.print();
    }

}
