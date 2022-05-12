# Flink流批一体API开发

Apache Flink是一个面向分布式数据流处理和批量数据处理的开源计算平台，它能够基于同一个Flink运行时（Flink Runtime），提供支持流处理和批处理两种类型应用的功能。

![](assets/1602831101602.png)

## 回顾I. Java泛型

> 在Flink中几乎所有处理数据Function函数接口都是**泛型**，**创建子类时需要指定具体类型**。

![1652281242117](assets/1652281242117.png)

> 在Java集合类中：`List`列表就是泛型，指定列表存储数据类型；其中`add`方法，接收参数也是泛型，表示接收数据类型。

![1652281624626](E:/Heima/%E5%B0%B1%E4%B8%9A%E7%8F%AD%E6%95%99%E5%B8%88%E5%86%85%E5%AE%B9%EF%BC%88%E6%AF%8F%E6%97%A5%E6%9B%B4%E6%96%B0%EF%BC%89/NoSQL%20Flink/%E9%A2%84%E4%B9%A0%E8%B5%84%E6%96%99/Flink/fake_flink-%E7%AC%AC2%E5%A4%A9-%E9%A2%84%E4%B9%A0%E8%B5%84%E6%96%99/flink-%E7%AC%AC2%E5%A4%A9-%E9%A2%84%E4%B9%A0%E8%B5%84%E6%96%99/assets/1652281624626.png)

```Java
package cn.itcast.flink.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Java中列表ArrayList就是泛型类
 */
public class JavaListTest {

	public static void main(String[] args) {
		// 创建列表
		List<String> list = new ArrayList<>() ;

		// 添加数据到列表中
		list.add("hello");
		list.add("world");
		list.add("word");
		list.add("count");

		// 打印数据
		System.out.println(list);
	}

}
```

## 回顾II. Java匿名内部类

> 在Java中OOP中，如果需要**创建接口Interface实现类对象**，有三种方式：**1、单独定义类创建，实例对象**、**2、直接创建匿名内部类对象**、**3、使用Lambda表达式**。

![1652306239945](assets/1652306239945.png)

> 以Java中创建线程启动为例，采用不同方式创建Runnable对象。

![1652306438488](assets/1652306438488.png)

- 方式1：**单独定义类创建，实例对象**

------

![1652306784456](assets/1652306784456.png)

```Java
package cn.itcast.flink.test;

public class JavaThreadTest {

	// 方式一：创建类，实现接口（属于内部类 -> 定义在类中的类）
	static class MyThread implements Runnable {
		@Override
		public void run() {
            long counter = 1 ;
			while (true){
				System.out.println(counter + "...........................");
				counter ++ ;
			}
		}
	}

	public static void main(String[] args) {
		// 创建一个线程, todo: 1、单独定义类创建，实例对象
		Thread thread = new Thread(new MyThread());
		// 启动线程
		thread.start();
	}

}
```

- 方式2：**直接创建匿名内部类对象**

------

![1652307032486](assets/1652307032486.png)

- 方式3：**使用Lambda表达式**

------

![1652307449759](assets/1652307449759.png)

> 将匿名内部类改为lambda表达式：代码简洁，Java8以后支持特性

```Java
		// 创建一个线程, todo: 3、使用Lambda表达式
		Thread thread = new Thread(
			() -> {
				long counter = 1 ;
				while (true){
					System.out.println(counter + "...........................");
					counter ++ ;
				}
			}
		);
```

![1652307642516](assets/1652307642516.png)

## 回顾III. MySQL JDBC

> 在Java中提供JDBC接口准备，方便对数据库进行操作，以MySQL为例，编写JDBC代码读写表数据。

- 创建表：

```SQL
-- 创建数据库
CREATE DATABASE IF NOT EXISTS db_flink ;
-- 创建表
CREATE TABLE IF NOT EXISTS db_flink.t_student (
                             id int(11) NOT NULL AUTO_INCREMENT,
                             name varchar(255) DEFAULT NULL,
                             age int(11) DEFAULT NULL,
                             PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 插入数据
INSERT INTO db_flink.t_student VALUES ('1', 'jack', 18);
INSERT INTO db_flink.t_student VALUES ('1', 'jack', 18);
INSERT INTO db_flink.t_student VALUES ('2', 'tom', 19);
INSERT INTO db_flink.t_student VALUES ('3', 'rose', 20);
INSERT INTO db_flink.t_student VALUES ('4', 'tom', 19);

-- 查询数据
SELECT id, name, age FROM db_flink.t_student ;
```

- JDBC方式读取数据

```JAva
package cn.itcast.flink.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 基于JDBC方式读取MySQL数据库表中数据
 */
public class MySQLJdbcReadTest {

	public static void main(String[] args) throws Exception{
		// step1、加载驱动
		Class.forName("com.mysql.jdbc.Driver") ;
		// step2、获取连接Connection
		Connection conn = DriverManager.getConnection(
			"jdbc:mysql://node1.itcast.cn:3306/?useSSL=false",
			"root",
			"123456"
		);
		// step3、创建Statement对象，设置语句（INSERT、SELECT）
		PreparedStatement pstmt = conn.prepareStatement("SELECT id, name, age FROM db_flink.t_student") ;
		// step4、执行操作，获取ResultSet对象
		ResultSet result = pstmt.executeQuery();
		// step5、遍历获取数据
		while (result.next()){
			// 获取每个字段的值
			int stuId = result.getInt("id");
			String stuName = result.getString("name");
			int stuAge = result.getInt("age");
			System.out.println("id = " + stuId + ", name = " + stuName + ", age = " + stuAge);
		}
		// step6、关闭连接
		result.close();
		pstmt.close();
		conn.close();
	}

}
```

- JDBC方式写入数据

```Java
package cn.itcast.flink.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * 基于JDBC方式写入数据到MySQL数据库表中
 */
public class MySQLJdbcWriteTest {

	public static void main(String[] args) throws Exception{
		// step1、加载驱动
		Class.forName("com.mysql.jdbc.Driver") ;
		// step2、获取连接Connection
		Connection conn = DriverManager.getConnection(
			"jdbc:mysql://node1.itcast.cn:3306/?useSSL=false",
			"root",
			"123456"
		);
		// step3、创建Statement对象，设置语句（INSERT、SELECT）
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO db_flink.t_student(id, name, age) VALUES (?, ?, ?)") ;
		// step4、执行操作
		pstmt.setInt(1, 99);
		pstmt.setString(2, "Jetty");
		pstmt.setInt(3, 28);
		pstmt.executeUpdate();
		// step5、关闭连接
		pstmt.close();
		conn.close();
	}

}
```

## I. 基础概念

### 1. DataStream

在Flink计算引擎中，将数据当做：==数据流DataStream==，分为**有界数据流**和**无界数据流**。

> [任何类型的数据都可以形成一种事件流，如信用卡交易、传感器测量、机器日志、网站或移动应用程序上的==用户交互记录==，所有这些数据都形成一种流。]()

![](assets/1614992955800.png)

> - 1）、`有边界流（bounded stream`）：==有定义流的开始，也有定义流的结束。==有界流可以在摄取所有数据后再进行计算。有界流所有数据可以被排序，所以并不需要有序摄取。有界流处理通常被称为`批处理。`
> - 2）、`无边界流（unbounded stream）`：==有定义流的开始，但没有定义流的结束==。它们会无休止地产生数据。无界流的数据必须持续处理，即数据被摄取后需要立刻处理。不能等到所有数据都到达再处理，因为输入是无限的，在任何时候输入都不会完成。处理无界数据通常要求以特定顺序摄取事件，例如事件发生的顺序，以便能够推断结果的完整性。

`DataStream（数据流）`官方定义：

![](assets/1614993124158.png)

> `DataStream（数据流）`源码中定义：

![](assets/1630115685862.png)

> DataStream有如下几个子类：

![1633571725510](assets/1633571725510.png)

- 1）、`DataStreamSource`：
  - 表示从数据源直接获取数据流DataStream，比如从Socket或Kafka直接消费数据
- 2）、`KeyedStream`：
  - 当DataStream数据流进行分组时（调用keyBy），产生流称为KeyedStream，按照指定Key分组；
  - 通常情况下数据流被分组以后，需要进行窗口window操作或聚合操作。
- 3）、`SingleOutputStreamOperator`：
  - 当DataStream数据流没有进行keyBy分组，而是使用转换函数，产生的流称为SingleOutputStreamOperator。
  - 比如使用filter、map、flatMap等函数，产生的流就是`SingleOutputStreamOperator`
- 4）、`IterativeStream`：迭代流，表示对流中数据进行迭代计算，比如机器学习，图计算等。

> `DataStream`类是泛型（类型参数），数据类型支持如下所示：

![1633533861903](assets/1633533861903.png)

> 在Flink计算引擎中，提供4个层次API，如下所示：

![](assets/levels_of_abstraction.svg)

> Flink中流计算DataStream层次API在使用时，还是包括三个方面：`Source/Transformation/Sink`

![](assets/1614758699392.png)

> 基于Flink开发流式计算程序五个步骤：

```ini
# 1）、Obtain an execution environment,
	执行环境-env：StreamExecutionEnvironment
	
# 2）、Load/create the initial data,
    数据源-source：DataStream
    
# 3）、Specify transformations on this data,
    数据转换-transformation：DataStream API（算子，Operator）
    
# 4）、Specify where to put the results of your computations,
    数据接收器-sink
	
# 5）、Trigger the program execution
	触发执行-execute
```

![](assets/1614758736610.png)

> 在IDEA中创建Flink Stream流计算编程模板：`FlinkClass`

![1652279769455](assets/1652279769455.png)

模块中内容：`FlinkClass`

```java
#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "") package ${PACKAGE_NAME};#end

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class ${NAME} {

	public static void main(String[] args) throws Exception {
		// 1. 执行环境-env
		StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
		
		// 2. 数据源-source
		
		// 3. 数据转换-transformation
		
		// 4. 数据终端-sink
		
		// 5. 触发执行-execute
		env.execute("${NAME}") ;
	}

}  
```

> 依据上述定义FlinkStream模块Template，创建Flink Stream编程类：`StreamDemo`

![1652307926272](assets/1652307926272.png)

### 2. 并行度设置

> 一个Flink程序由多个Operator组成(`source、transformation和 sink`)。

![](assets/1630241888273.png)

> 一个Operator由多个并行的SubTask（以线程方式）来执行， 一个Operator的并行SubTask(数目就被称为该Operator(任务)的**并行度**(`Parallelism`)。

![](assets/1630241797904.png)

在Flink 中，并行度设置可以从4个层次级别指定，具体如下所示：

![](assets/1630243097602.png)

- 1）、==Operator Level（算子级别）==(可以使用)

> 一个operator、source和sink的并行度可以通过调用 `setParallelism()`方法来指定。

![1630243927963](assets/1630243927963.png)

- 2）、==Execution Environment Level==（Env级别，可以使用)

> 执行环境并行度可以通过调用`setParallelism()`方法指定。

![1630243963333](assets/1630243963333.png)

- 3）、==Client Level==(客户端级别，推荐使用)

> 并行度可以在客户端将job提交到Flink时设定，对于CLI客户端，可以通过`-p`参数指定并行度

![1630244027260](assets/1630244027260.png)

- 4）、==System Level==（系统默认级别，尽量不使用）

> 在系统级可以通过设置`flink-conf.yaml`文件中的`parallelism.default`属性来指定所有执行环境的默认并行度。

总结：并行度的优先级：`算子级别 > env级别 > Client级别 > 系统默认级别` 

- 1）、如果source不可以被并行执行，即使指定了并行度为多个，也不会生效
- 2）、实际生产中，推荐`在算子级别显示指定各自的并行度`，方便进行显示和精确的资源控制。
- 3）、slot是静态的概念，是**指taskmanager具有的并发执行能力**； `parallelism`是动态的概念，是指`程序运行时实际使用的并发能力`。



### 3. 资源槽Slot

![1633569666984](assets/1633569666984.png)

> Flink中运行Task任务（SubTask）在Slot资源槽中：
> [Slot为子任务SubTask运行资源抽象，每个TaskManager运行时设置Slot个数。]()

```ini
官方建议：
	Slot资源槽个数  =  CPU Core核数
也就是说，
    分配给TaskManager多少CPU Core核数，可以等价为Slot个数
```

![](assets/1626485199097.png)

> 每个TaskManager运行时设置内存大小：[TaskManager中内存==平均==划分给Slot]()。

```
举例说明：
	假设TaskManager中分配内存为：4GB，Slot个数为4个，此时每个Slot分配内存就是 4GB / 4 = 1GB 内存	
```

> 每个Slot中运行SubTask子任务，以线程Thread方式运行。
>
> - 不同类型SubTask任务，可以运行在同一个Slot中，称为：[Slot Sharded 资源槽共享]()
> - 相同类型SubTask任务必须运行在不同Slot中。

![](assets/1630759894498.png)

## II. Data Source & Data Sink



## III. DataStream Transformations



## 附I. Maven模块



## 附II. Lombok使用及插件安装







