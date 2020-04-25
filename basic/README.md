# 异常分类

## 说明
异常分为两类，Exception和Error,都是继承自Throwable类
## ERROR
1. 指java运行时系统的内部错误和资源耗尽错误。应用程序不会抛出该类对象。如果出现这样的错误，除了告知用户，剩下的就是尽力使程序安全的终止。
2. Error类：OutOfMemoryError、AWTError、ThreadDeath等
## Exception
Exception有两类，一个是运行时异常RuntimeException,一个是检查异常CheckedExcetion
### RuntimeException:
如：NullPointerExcetion、ClassCastException。RuntimeException是那些可能在java虚拟机正常运行期间抛出的异常的超类。如果出现RuntimeException那一定是程序错误
### CheckedExcetion
如：如I/O错误导致的IOException、SQLException。
一般是外部错误，这种异常都发生在编译阶段，java编译器会强制程序去捕获此类异常，即会出现要求你把这段可能出现异常的程序进行try catch，该类异常一般包括几个方面:
1. 试图文件尾部读取数据
2. 试图打开一个错误格式的URL
3. 试图根据给定的字符串查找class对象，而这个字符串表示的类并不存在.
# 异常的处理方式
抛出异常有三种方式：1.throw 2. throws 3. 系统自动抛出

DEMO:地址 com.share.basic.exception;

     
     public static int div(int a,int b) throws Exception{
         return a/b;
     }
 
     public static void throwDemo(String s){
         if(s.equals("abc")){
             throw new NumberFormatException();
         }else {
             System.out.println(s);
         }
     }
区别：
1. throws 用在函数上，后面跟的是异常类，可以跟多个；throw是用在函数内，后面跟异常对象
2. throws 用来声明异常,让调用者只知道该功能可能出现问题,可以给出预先的处理方式；throw抛出具体
的问题对象,执行到throw，功能就已经结束了，跳转到调用者，并将具体的问题对象抛给调用者。也就是说
throw语句独立存在时，下面不能定义其他语句，因为执行不到。
3. throws表示出现异常的一种可能行性，并不一定会发生这些异常；throw则是抛出了异常，执行throw则一定抛出了某种异常对象
4. 两者都是消极处理异常方式，知识抛出活着可能抛出异常，但是不会有函数去处理异常，真正的处理异常由函数的上层调用处理

# 反射
运行中知道类所有的属性和方法，在java中的反射机制是指在运行状态中，对任意一个类都能够知道这个类所有的属性和方法；并且对任意一个对象，都能够调用他的任意一个方法;这种动态获取信息以及动态调用对象方法的功能成为java反射机制
## API
1. Class 类：反射的核心类，可以获取类的属性，方法等信息
2. Field 类：Java.lang.reflec包中的类，表示类的成员变量，可以用来获取和设置类之中的属性值。
3. Method 类：Java.lang.reflec包中的类，表示类的方法，可以用来获取类中的方法信息或者执行方法
4. Constructor 类：Java.lang.reflec包中的类，表示类的构造方法
## 使用步骤
1. 获取想要操作的类的Class对象，他是反射的核心，通过Class对象我们可以任意调用类的方法
2. 调用Class类中的方法，既就是反射的使用阶段
3. 使用反射API来操作这些信息
## 获取Class对象的方法
 调用某个对象的getClass() 方法

    
    DisposeException disposeException = new DisposeException();
    Class<? extends DisposeException> aClass = disposeException.getClass();

 调用某个类的class 属性来获取该类对应的Class对象


    Class<DisposeException> disposeExceptionClass = DisposeException.class;
    
 使用Class类中的forName()静态方法(最安全/性能最好)
    
    
        Class<?> clazz = null;
        try {
            clazz = Class.forName("com.share.basic.exception.DisposeException");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //获取方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods) {
            System.out.println("方法:" + m);
        }
        //获取属性
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
            System.out.println("属性:" + f);
        }
        //获取构造方法
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor c : declaredConstructors) {
            System.out.println("构造器" + c);
        }
    
## 创建对象的方法
1. 使用Class对象的newInstance() 方法来创建该Class对象对应的实例，但是这种方法要求该Class对象对应的类有默认的空构造器
2. 先使用Class对象获取指定的Constructor对象，再调用Constructor对象的newInstance()方法来创建Class对象对应类的实例，通过这种方法可以选定构造方法创建实例


    try {
        DisposeException d = (DisposeException) clazz.newInstance();
        Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(int.class);
        DisposeException d1 = (DisposeException) declaredConstructor.newInstance(1);
    } catch (InstantiationException e) {
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        e.printStackTrace();
    } catch (NoSuchMethodException e) {
        e.printStackTrace();
    } catch (InvocationTargetException e) {
        e.printStackTrace();
    }
    




