package com.apm.test;

import com.apm.UserService;
import javassist.*;
import org.junit.Test;

public class ApmTest {
    @Test
    public void apmTest() throws InterruptedException {
        //创建一个类池  只有存在这个类池的类才能被修改
        ClassPool classPool = new ClassPool();
        //将当前系统的classLoader当中的类增加到类池里面   通过classLoader 可以找到使用当前加载器加载的全部的类
        //ByteArrayClassPath  把一个字节加入到类池
        //ClassClassPath  把一个Class加入到类池
        //DirClassPath 把目录下的所有的Class加入到类池
        //JarClassPath 把一个jar包里的class加入到类池
        //JarDirClassPath 把一个目录下的jar的class加入到类池
        //LoaderClassPath 把一个加载器加载的类加载到类池
        //URLClassPath 把一个url加载到类池
        classPool.appendSystemPath();
        //获取对应的类
        try {
            String bodyTemp = "{\n\t%s\n\t%s\n\t%s\n\t%s\n}";
            CtClass ctClass = classPool.get("com.apm.UserService");
            CtMethod sayHello = ctClass.getDeclaredMethod("sayHello");
            CtMethod copyMethod = CtNewMethod.copy(sayHello, ctClass, null);
            sayHello.setName(sayHello.getName()+"$javaagent");
            copyMethod.setBody(String.format(bodyTemp, "long startTime = System.currentTimeMillis();",
                    sayHello.getName()+"();","long end = System.currentTimeMillis();",
                    "System.out.println(\"总耗时：\"+(end - startTime));"));

            //把修改后的类重新装载进JVM
            ctClass.addMethod(copyMethod);
            ctClass.toClass();
        } catch (NotFoundException | CannotCompileException e) {
            e.printStackTrace();
        }
        new UserService().sayHello();
    }


    @Test
    public void apmTest2() throws InterruptedException {
        //创建一个类池  只有存在这个类池的类才能被修改
        ClassPool classPool = new ClassPool();
        //将当前系统的classLoader当中的类增加到类池里面   通过classLoader 可以找到使用当前加载器加载的全部的类
        //ByteArrayClassPath  把一个字节加入到类池
        //ClassClassPath  把一个Class加入到类池
        //DirClassPath 把目录下的所有的Class加入到类池
        //JarClassPath 把一个jar包里的class加入到类池
        //JarDirClassPath 把一个目录下的jar的class加入到类池
        //LoaderClassPath 把一个加载器加载的类加载到类池
        //URLClassPath 把一个url加载到类池
        classPool.appendSystemPath();
        //获取对应的类
        try {
            String bodyTemp = "{\n\t%s\n\t%s\n\t%s\n\t%s\n}";
            CtClass ctClass = classPool.get("com.apm.UserService");
            CtMethod sayHello = ctClass.getDeclaredMethod("sayHello1");
            CtMethod copyMethod = CtNewMethod.copy(sayHello, ctClass, null);
            sayHello.setName(sayHello.getName()+"$javaagent");

            //$$ 匹配全部的文件
            //$0 匹配 this
            //$1 匹配第一个参数
            //$2 匹配第二个参数
            //$3 匹配第三个参数
            //$r 返回值强制类型转换
            //$class 当前类的名字
            //$type 返回值的类型
            //sig 方法参数类型数组  $sig  $sig[0]  $sig[1]  $sig[2]
            copyMethod.setBody("{" +
                        "long startTime = System.currentTimeMillis();" +
                        sayHello.getName()+"($$);" +
                        "long end = System.currentTimeMillis();" +
                        "System.out.println($1);" +
                        "System.out.println($2);" +
                        "System.out.println($3);" +
                        "System.out.println($class);" +
                        "System.out.println($type);" +
                        "System.out.println($sig);" +
                        "System.out.println(\"总耗时：\"+(end - startTime));" +
                        "return ($r)$3;" +
                    "}");

            //把修改后的类重新装载进JVM
            ctClass.addMethod(copyMethod);
            ctClass.toClass();
        } catch (NotFoundException | CannotCompileException e) {
            e.printStackTrace();
        }
        new UserService().sayHello1("huangfu",12,"huangfu");
    }
}
