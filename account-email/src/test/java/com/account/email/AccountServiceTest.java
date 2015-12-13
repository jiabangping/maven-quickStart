package com.account.email;

import javax.mail.Message;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetup;

public class AccountServiceTest {

	private GreenMail greenMail;
	
	@Before
	public void startMailServer() {
		greenMail = new GreenMail(ServerSetup.SMTP);
		greenMail.setUser("test@juvenxu.com", "123456");
		greenMail.start();
	}
	
	@Test
	public void testSendMail() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		AccountEmailService service = (AccountEmailService) ctx.getBean("accountEmailService");
		String subject = "Test Subject";
		String htmlText = "<h3>Test</h3>";
		service.sendMail("1591637630@qq.com", subject,htmlText);
//		greenMail.wait(2000, 1);
		greenMail.waitForIncomingEmail(2000, 1);
		Message[] msgs = greenMail.getReceivedMessages();
		System.out.println(msgs[0].getSubject()+","+ GreenMailUtil.getBody(msgs[0]).trim());
		Assert.assertEquals(1, msgs.length);
		Assert.assertEquals(subject, msgs[0].getSubject());
		Assert.assertEquals(htmlText, GreenMailUtil.getBody(msgs[0]).trim());
	}
	@After
	public void stopMailServer() throws Exception {
		greenMail.stop();
	}
}
