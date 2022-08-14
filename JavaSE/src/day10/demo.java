package day10;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;

public class demo {

    @Test
    public void testFileReader(){

        FileReader fileReader = null;


        try {
            fileReader = new FileReader("io.txt");
            try {
                int a = fileReader.read();
                System.out.println(a);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    @Test
    public void testFileReader1(){
        FileReader fileReader = null;

        try {
            fileReader = new FileReader("io.txt");
            int a = -1;
            while ((a = fileReader.read()) != -1){
                System.out.print((char)a);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if(fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void testFileReader2() {
        FileReader fileReader = null;


        try {
            fileReader = new FileReader("io.txt");
            char[] str = new char[20];
            int length = -1;
            while ((length = fileReader.read(str)) != -1) {
                System.out.println(Arrays.toString(str));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if(fileReader!=null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void testFileWriter(){
        FileReader fileReader = null;
        FileWriter fileWriter = null;

        try {
            fileReader = new FileReader("io.txt");
            fileWriter = new FileWriter("io_back.txt");

            char[] buffer = new char[20];
            int length = -1;

            while((length = fileReader.read(buffer))!=-1){
                System.out.println(length);
                System.out.println(Arrays.toString(buffer));

                fileWriter.write(buffer,0,length);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileWriter!=null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fileReader!=null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testInputStream(){
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            inputStream = new FileInputStream("a.png");
            outputStream = new FileOutputStream("a_back.png");

            byte[] buffer= new byte[1024];
            int length = -1;


                while((length = inputStream.read(buffer))!=-1){
                    outputStream.write(buffer);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
            if(outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Test
    public void testObjectOutputStream(){
        Student student = new Student();
        student.setAge(12);
        student.setId(1);
        student.setName("李四");
        OutputStream outputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            outputStream = new FileOutputStream("student");
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(student);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(objectOutputStream!=null){
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testObjectInputStream(){
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            fileInputStream = new FileInputStream("student");
            objectInputStream = new ObjectInputStream(fileInputStream);
            Student student = (Student) objectInputStream.readObject();
            System.out.println(student);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(objectInputStream!=null){
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fileInputStream!=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
