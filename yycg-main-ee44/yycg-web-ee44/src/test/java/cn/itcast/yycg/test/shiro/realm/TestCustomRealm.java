package cn.itcast.yycg.test.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;

public class TestCustomRealm extends AuthenticatingRealm {
	
	@Override
	public String getName() {
		return "TestCustomRealm";
	}

	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String principal=(String)token.getPrincipal();
		
		if (!"jack".equals(principal)) {
			return null;
		}
		String pwd="1234";
		
		
		
		return new SimpleAuthenticationInfo(principal,pwd,getName());
	}

}
