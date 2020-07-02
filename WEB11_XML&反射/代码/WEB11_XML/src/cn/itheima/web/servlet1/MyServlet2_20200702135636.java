package cn.itheima.web.servlet1;

public class MyServlet2 implements IMyServlet{

	@Override
	public void init() {
		System.out.println("MyServlet2诞生了……");
	}

	@Override
	public void service() {
		System.out.println("MyServlet2开始服务了……");
	}

	@Override
	public void destory() {
		System.out.println("MyServlet2销毁了……");
	}

}
