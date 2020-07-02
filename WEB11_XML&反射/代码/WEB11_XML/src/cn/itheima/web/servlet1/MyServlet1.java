package cn.itheima.web.servlet1;

public class MyServlet1 implements IMyServlet{

	@Override
	public void init() {
		System.out.println("MyServlet1诞生了……");
	}

	@Override
	public void service() {
		System.out.println("MyServlet1开始服务了……");
	}

	@Override
	public void destory() {
		System.out.println("MyServlet1销毁了……");
	}

}
