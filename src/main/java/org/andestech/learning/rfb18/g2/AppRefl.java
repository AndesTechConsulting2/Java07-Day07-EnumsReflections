package org.andestech.learning.rfb18.g2;

import com.sun.istack.internal.NotNull;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.text.DateFormat;
import java.util.Arrays;
import java.lang.annotation.Annotation;

@SuperClass
@Logger(level = LoggingLevel.OnlyErrors)
class Data
{
 int a,b,c;

 private int d = 0;

    public int getD() {
        return d;
    }

    private int e;
    private int f;

    public void _startA(){
        System.out.println("_startA...");
    }

 public void startA(){
     System.out.println("startA...");
 }

    public void startB(){
        System.out.println("startB...");
    }

    public void startC(){
        System.out.println("startC...");
    }

    private void startD(){
        System.out.println("startD private...");
    }

    private static void startStaticE(){
        System.out.println("startE private static...");
    }

    public static void startStaticF(){
        System.out.println("startF public static...");
    }


}


public class AppRefl

{

    public static void main(String[] args ) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException {


     //1
     Class<?> c = Data.class;

     Data data = new Data();

     //invoke private method

        System.out.println("d=" + data.getD());
        Method m1 = c.getDeclaredMethod("startD");
        m1.setAccessible(true);
        m1.invoke(data);

     // change private field

        Field f1 = data.getClass().getDeclaredField("d");
        f1.setAccessible(true);
        f1.set(data, 100);

        for(Field f: c.getDeclaredFields()) {

            System.out.println(f.getName());
        }





     //2
     Class c2 = data.getClass();


     //3
     Class c3 = Class.forName("org.andestech.learning.rfb18.g2.Data");


     //------------------------------

     boolean flag = false;
     for(Annotation ann: c.getAnnotations())
     {

         System.out.println(ann.toString());
         if(c.isAnnotationPresent(Logger.class)){

         Logger l =c.getAnnotation(Logger.class);
         switch (l.level())
         {
             case Full:
                 //...
                 System.out.println("Full logging..."); break;
             case OnlyErrors:
                 //...
                 System.out.println("Error logging..."); break;
             //..

         }

         }

     //  if(c.isAnnotationPresent(SuperClass.class)){f}

     //  if(ann.toString().equals("@org.andestech.learning.rfb18.g2.SuperClass()")) {flag = true;
     //      System.out.println("SuperClass found...");}

     }

     //if(flag)
     if(c.isAnnotationPresent(SuperClass.class))
     for(Method m: c.getDeclaredMethods())
     {
         System.out.println(m.getName()+ " : " + m.getModifiers());


         if(m.getModifiers() == 1)
         {   if(m.getName().startsWith("start")) m.invoke(data);}


         if(m.getModifiers() == 2)
         {
             m.setAccessible(true);
             m.invoke(data);
         }

     }

    }
}
