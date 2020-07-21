#### EasyInject

旨在于使用注解解决减少书写常用的模板型代码，目前支持单例注解
如果你喜欢这个框架请star一下，你的一个star是我前进的动力，欢迎反馈问题

* dependencies

  添加依赖

```java
def easy = '1.0.0'
implementation 'com.lakehubo:easyinject:$easy'
annotationProcessor 'com.lakehubo:injectutilAnnotationProcessor:$easy'
```

* use it

```java
@Singleton()
public class SingleTonTester {

    public String test;
		
    public SingleTonTester() {
        test = System.currentTimeMillis() + "";
    }

    public void showTime() {
        Log.e("lake", Thread.currentThread().getName() + ":showTime: " + test);
    }
}
```

* test it

```java
for (int i = 0; i < 100; i++)
    new Thread(() -> {
        SingleTonTester_Single.getInstance().showTime();
    }).start();
```

当你使用了`@Singleton()`注解你想设置`SingleTonTester`类为单例时，通过`make`编译项目，
编译器会自动生成对应的单例类`SingleTonTester_Single`，生成的该类为单例，原有并不会有任何改变，
所以，当你使用单例来保障线程安全时，需要使用生成的`SingleTonTester_Single`类。

```java
SingleTonTester_Single.getInstance()
```

因为通过继承来实现的单例类，所以，被注解类需要为可继承的（非final修饰的class）。
在注解类中，请保持构造函数至少为`protected`可继承或者`public`公有类型。

* other param set
  单例注解，还支持单例模式的实现类型
  
```java
SingletonType.DLC //双检查锁机制
SingletonType.INNER_STATIC //静态内部类机制
SingletonType.STATIC_BOX //静态块机制
```

* use it

```java
@Singleton(SingletonType.DLC)
public class SingleTonTester {}
```

**当无参数时，默认为DLC模式的单例**

