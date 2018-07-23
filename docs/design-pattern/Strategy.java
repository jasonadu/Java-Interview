package com.example.demo.dp;

interface IStrategy {
	public int doOperation(int num1, int num2);
}

class OperationAdd implements IStrategy {
	@Override
	public int doOperation(int num1, int num2) {
		return num1 + num2;
	}
}

class OperationSubstract implements IStrategy {
	@Override
	public int doOperation(int num1, int num2) {
		return num1 - num2;
	}
}

class OperationMultiply implements IStrategy {
	@Override
	public int doOperation(int num1, int num2) {
		return num1 * num2;
	}
}

class Context {
	private IStrategy strategy;

	public Context(IStrategy strategy) {
		this.strategy = strategy;
	}

	public int executeStrategy(int num1, int num2) {
		return strategy.doOperation(num1, num2);
	}
}

/**
 * 
 * http://www.runoob.com/design-pattern/strategy-pattern.html
 * 介绍：
 * 在策略模式（Strategy Pattern）中，一个类的行为或其算法可以在运行时更改，属于行为型模式。
 * 创建表示各种策略的对象和一个行为，随着策略对象改变而改变的 context 对象。策略对象改变 context 对象的执行算法。
 * 优点： 1、算法可以自由切换。 2、避免使用多重条件判断。 3、扩展性良好。
 * 缺点： 1、策略类会增多。 2、所有策略类都需要对外暴露。
 * 如果一个系统的策略多于四个，就需要考虑使用混合模式，解决策略类膨胀的问题。
 * 
 * 意图：定义一系列的算法,一个个封装起来, 使它们可相互替换。
 * 主要解决：在有多种算法相似的情况下，使用 if...else 所带来的复杂和难以维护。
 * 何时使用：系统有许多类，而区分它们的只是行为。
 * 如何解决：将这些算法封装成一个个，任意地替换。
 * 关键代码：实现同一个接口。
 * 
 * 应用实例： 
 * 1.JAVA AWT 中的 LayoutManager。
 * 2.org.springframework.beans.factory.support.CglibSubclassingInstantiationStrategy
 * 3.org.hibernate.cfg.NamingStrategy
 *   org.springframework.boot.orm.jpa.hibernate.SpringNamingStrategy
 *   	2.1 camelcase EJB3NamingStrategy
 *   	2.2 snakecase ImprovedNamingStrategy
 */
public class Strategy {
	public static void main(String[] args) {
		Context context = new Context(new OperationAdd());
		System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

		context = new Context(new OperationSubstract());
		System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

		context = new Context(new OperationMultiply());
		System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
	}
}
