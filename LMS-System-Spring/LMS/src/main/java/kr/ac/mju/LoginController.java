package kr.ac.mju;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import kr.ac.mju.VUser.ELoginInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private LoginService loginService;	

	// 로그인
	@RequestMapping(value = "/LoginController/login.do", method = RequestMethod.POST)
	public String login(HttpServletRequest request) throws IOException 
	{
		request.setCharacterEncoding("utf-8");
		String userID = request.getParameter("userID");
		String userPassword = request.getParameter("userPassword");

		VLogin vLogin = new VLogin();
		vLogin.setID(userID);
		vLogin.setPw(userPassword);

		if(vLogin.getID().equals("")||vLogin.getPw().equals(""))
		{
			logger.info("해당 사용자가 없습니다.");
			return "redirect:/";
		}

		VUser vUser = loginService.login(vLogin);
		logger.info("로그인요청:"+vLogin.getID());
		if(vUser.geteLoginInfo()==ELoginInfo.idError) 
		{
			request.getSession().setAttribute("userSession", vUser);
			logger.info("아이디 에러 입니다."); 
			return "alert";
		}
		else if(vUser.geteLoginInfo()==ELoginInfo.passwordError) 
		{
			request.getSession().setAttribute("userSession", vUser);
			logger.info("패스워드 에러 입니다.");
			return "alert";
		}
		else if(vUser.geteLoginInfo()==ELoginInfo.success){
			request.getSession().setAttribute("userSession", vUser);
			System.out.println(vUser.getType());
			if(vUser.getType().equals("prof")) 
			{
				return "professor/menu";
			} 
			else
			{
				return "student/menu";
			}
		}
		else 
		{
			logger.info("에러");
			return "redirect:/";
		}
	}
	// 로그아웃
	@RequestMapping(value = "/LoginController/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request)
	{
		request.getSession().removeAttribute("userSession");
		return "redirect:/";
	}
	// 회원가입 페이지
	@RequestMapping(value = "/LoginController/join.do", method = RequestMethod.GET)
	public String join(HttpServletRequest request)
	{
		return "common/join";
	}
	// 회원가입 전송
	@RequestMapping(value = "/LoginController/join.do", method = RequestMethod.POST)
	public String joinDo(HttpServletRequest request) throws IOException 
	{
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		CUser user = new CUser(id, pw, name, type);
		
		loginService.join(user);
		
		return "redirect:/";
	}
}

