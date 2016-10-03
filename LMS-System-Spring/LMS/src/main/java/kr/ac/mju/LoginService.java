package kr.ac.mju;

import java.io.IOException;

import kr.ac.mju.VUser.ELoginInfo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class LoginService 
{
	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	UserDAO userDAO = (UserDAO) context.getBean("UserDAO");
	// 로그인 성공, 아이디, 패스워드 에러를 등록함 회원을 반환
	public VUser login(VLogin vLogin) throws IOException 
	{
		VUser vUser = new VUser();
		CUser user = userDAO.search(vLogin);
		if(user.getID().equals(vLogin.getID())) 
		{
			if(user.getPw().equals(vLogin.getPw())) 
			{
				vUser.setId(user.getID());
				vUser.setPw(user.getPw());
				vUser.setName(user.getName());
				vUser.setType(user.getType());

				vUser.seteLoginInfo(ELoginInfo.success);
				return vUser;
			}
			vUser.seteLoginInfo(ELoginInfo.passwordError);
			return vUser;
		}
		vUser.seteLoginInfo(ELoginInfo.idError);
		return vUser;
	}

	// 회원가입 폼에 입력한 정보를 DAO로 전달
	public void join(CUser user)
	{
		userDAO.insert(user);
	}
}

