package cn.itcast.yycg.first.web.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class FirstAction extends ActionSupport {

	public String first() {
		return "first";
	}
}
