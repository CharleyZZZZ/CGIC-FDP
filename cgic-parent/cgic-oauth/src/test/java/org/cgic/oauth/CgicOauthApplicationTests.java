package org.cgic.oauth;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CgicOauthApplicationTests {

	final BASE64Decoder decoder = new BASE64Decoder();

	@Test
	public void contextLoads() throws IOException {

		String jwtToken = "eyJhY2NvdW50Tm9uRXhwaXJlZCI6dHJ1ZSwiYWNjb3VudE5vbkxvY2tlZCI6dHJ1ZSwiYXV0aG9y\r\naXRpZXMiOlt7ImF1dGhvcml0eSI6IlJPTEVfMSJ9XSwiY3JlZGVudGlhbHNOb25FeHBpcmVkIjp0\r\ncnVlLCJkaXNwbGF5TmFtZSI6IuW8oOS4iSIsImVtYWlsIjoiemhhbmdzYW5AcHVidWQuY29tIiwi\r\nZW5hYmxlZCI6dHJ1ZSwicGFzc3dvcmQiOiIxMjM0NTYiLCJyb2xlcyI6W3sicm9sZUNvZGUiOiJS\r\nT0xFXzEiLCJyb2xlSWQiOjEsInJvbGVOYW1lIjoi6KeS6ImyMeWPtyJ9XSwidXNlcklkIjoxLCJ1\r\nc2VybmFtZSI6InpoYW5nc2FuIn0=";
		System.out.println(new String (decoder.decodeBuffer(jwtToken),"UTF-8"));

	}

}
