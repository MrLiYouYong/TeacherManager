package day11;

public class Car {
    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

//        System.out.println(car1.hashCode());
//        System.out.println(car2.hashCode());
//        System.out.println(car3.hashCode());

        Class<?extends Car> aClass1 = Car.class;
        Class<?extends Car> aClass2 = Car.class;
        Class<?extends Car> aClass3 = Car.class;

//        System.out.println(aClass1.hashCode());
//        System.out.println(aClass2.hashCode());
//        System.out.println(aClass3.hashCode());

        System.out.println(aClass1.getClassLoader());// APPClassLoader  应用程序类加载器
        System.out.println(aClass1.getClassLoader().getParent());//PlatformClassLoader   扩展类加载器
        System.out.println(aClass1.getClassLoader().getParent().getParent());//null  1.不存在  2.获取不到    启动类加载器
    }
}
