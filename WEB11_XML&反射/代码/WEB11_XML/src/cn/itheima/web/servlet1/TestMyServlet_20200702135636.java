package cn.itheima.web.servlet1;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class TestMyServlet {
	
	@Test
	public void testMyServlet(){
		try {
			//1.创建解析器对象
			SAXReader saxReader = new SAXReader();
			//2.使用解析器加载web.xml文件得到document对象
			Document document = saxReader.read("src/cn/itheima/web/servlet1/web.xml");
			//3.获取根元素节点
			Element rootElement = document.getRootElement();
			//4.根据元素名称获取子元素节点
			Element servletElement = rootElement.element("servlet");
			//5.根据元素名称获取servlet-class的文本节点
			String servletClass = servletElement.element("servlet-class").getText();
			//System.out.println(servletClass);
			//6.通过类全名获取字节码文件
			Class clazz = Class.forName(servletClass);
			//7.创建实例对象
			MyServlet1 my = (MyServlet1) clazz.newInstance();
			//8.调用实例对象里面的方法
			my.init();
			my.service();
			my.destory();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
