## 1. 语法

​	 `Java` 泛型数组不能直接通过 `E[] arr = new E[]` 定义。

```java
// 正确打开方式
E[] arr = (E[]) new Object[SIZE]; 
```

​	在单元测试中，实例化了一个`Integer` 列表，在对 `get` 方法进行测试时

```java
// 执行以下语句
assertEquals(1, alist.get(0)); // get方法返回 Integer 类型
```

​    出现方法的模糊匹配，即二义性问题。

```java
assertEquals(Object, Object)  
assertEquals(long, long)
```

```java
// 正确打开方式
assertEquals(Integer.valueOf(1), alist.get(0));
```



## 2.  接口

​      将列表的共有方法抽象为一个`List` 接口，对外呈现。 

​      接口中的方法都是抽象方法，`public abstract`可缺省，具体类在实现该接口时必须对方法进行重写，最好标注`@Override`。

> 注意： Java 中关键字都为小写，类名首字母为大写，采用驼峰命名法



## 3.  类、方法注释规范

> 一个程序的可读性，关键取决于注释。
>

#### 3.1 类注释

​		类注释一般**必须放在所有的`import`语句之后**。类定义之前，主要声明该类可以做什么，以及创建者、创建日期、版本和包名等一些信息。以下是一个类注释的模板：

```java
/**
 * @projectName（项目名称）: project_name
 * @package（包）: package_name.file_name
 * @className（类名称）: type_name
 * @description（类描述）: 一句话描述该类的功能
 * @author（创建人）: user 
 * @createDate（创建时间）: datetime  
 * @updateUser（修改人）: user 
 * @updateDate（修改时间）: datetime
 * @updateRemark（修改备注）: 说明本次修改内容
 * @version（版本）: v1.0
 */
public class demo{
    /* class body */
}
```

#### 3.2 方法注释

​		方法注释必须紧靠在方法定义的前面，主要声明**方法参数、返回值、异常**等信息。除了可以使用通用标签外，还可以使用下列的以`@`开始的标签。

```java
/**
 * @description: 计算两个整型数的和
 * @param num1: 加数1
 * @param num2: 加数2
 * @return: 两个加数的和
 * @throws: 整型加法溢出
 */
public int add(int num1,int num2) throws Exception {
    long value = num1 + num2;
    if ((int) value != value){
        throws new ArithmeticException("integer overflow");
    }
    return (int)value;
}
```

