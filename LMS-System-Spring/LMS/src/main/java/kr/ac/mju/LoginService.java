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
	// �α��� ����, ���̵�, �н����� ������ ����� ȸ���� ��ȯ
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

	// ȸ������ ���� �Է��� ������ DAO�� ����
	public void join(CUser user)
	{
		userDAO.insert(user);
	}
}

