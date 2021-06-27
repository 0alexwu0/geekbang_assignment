package jvm;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HelloClassLoader extends ClassLoader{
    private static String sClassPath;

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        if(args.length < 1){
            System.out.println("Please input class path");
            return;
        }

        //取得入参
        sClassPath = args[0];

        Class<?> classHello = new HelloClassLoader().findClass("Hello");
        if(classHello == null){
            System.out.println("Class not found");
            return;
        }

        //调用Hello类下面的hello方法
        Method mHello = classHello.getDeclaredMethod("hello",null);
        if(mHello == null){
            System.out.println("Method not found");
            return;
        }
        mHello.invoke(classHello.newInstance(),null);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class classHello = null;

        //获取类的文件数据
        byte[] bytesHello = getClassCode();
        if(bytesHello == null){
            return null;
        }

        //解密类数据
        bytesHello = decodeClassCode(bytesHello);
        if(bytesHello == null){
            return null;
        }

        //转换为class
        classHello = defineClass(name, bytesHello, 0, bytesHello.length);
        return classHello;
    }

    //类的文件读取
    private byte[] getClassCode(){
        File fileCode = new File(sClassPath);
        if (!fileCode.exists()){
            return null;
        }

        FileInputStream inCode = null;
        ByteArrayOutputStream outCode = null;

        try {
            inCode = new FileInputStream(fileCode);
            outCode = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int size = 0;
            while ((size = inCode.read(buffer)) != -1) {
                outCode.write(buffer, 0, size);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inCode.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
        return outCode.toByteArray();
    }

    //解密类的字节数据
    private byte[] decodeClassCode(byte[] bytesCode){
        for(int i=0;i<bytesCode.length;i++){
            bytesCode[i] = (byte) (0xff - bytesCode[i]);
        }
        return bytesCode;
    }
}
