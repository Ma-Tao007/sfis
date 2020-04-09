package com.servlets;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/randomCode")
public class RandomCodeServlet extends HttpServlet
{
	// 验证码图片的宽度
		private int width=60;
		// 验证码图片的高度
		private int height=20;
		
		@Override
		protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
				throws ServletException, IOException
		{
			BufferedImage buffImg=new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
			Graphics2D g2=buffImg.createGraphics();
			
			// 创建一个随机数生成器类
			Random random=new Random();
			g2.setColor(Color.white);
			g2.fillRect(0, 0, width, height);
			
			// 创建字体，字体大小根据图片高度决定
			Font font=new Font("Times New Romann", Font.PLAIN, 18);
			// 设置字体
			g2.setFont(font);
			
			//画边框
			g2.setColor(Color.black);
			g2.drawRect(0, 0, width-1, height-1);
			
			// 随机产生160条干扰线，使其他程序不能轻易探测到认证码
			g2.setColor(Color.gray);
			for(int i=0;i<160;i++)
			{
				int x=random.nextInt(width);
				int y=random.nextInt(height);
				int x1=random.nextInt(12);
				int y1=random.nextInt(12);
				g2.drawLine(x, y, x+x1, y+y1);
			}
			
			// 保存随机长生的验证码，以便于用户登录后进行验证
			StringBuffer randomCode=new StringBuffer();
			int red=0,green=0,blue=0;
			
			// 随机产生4位数字的验证码
			for(int i=0;i<4;i++)
			{
				// 得到随机产生的验证码数字
				String strRand=String.valueOf(random.nextInt(10));
				
				//产生随机的颜色分量来构造颜色值，每位数字颜色值不同
				red=random.nextInt(110);
				green=random.nextInt(50);
				blue=random.nextInt(50);
				
				// 用随机产生的颜色将验证码绘制到图中
				g2.setColor(new Color(red, green, blue));
				g2.drawString(strRand, 13*i+6, 16);
				
				// 将产生的四个随机数组合在一起
				randomCode.append(strRand);
			}
			
			// 将四个数字的验证码保存到 session 中
			HttpSession session=arg0.getSession();
			session.setAttribute("randomCode", randomCode.toString());
			
			//静止图像缓存
			arg1.setHeader("Pragma", "no-cache");
			arg1.setHeader("Cache-Control", "no-cache");
			arg1.setDateHeader("Expires", 0);
			
			arg1.setContentType("image/jpeg");
			
			// 将图像输出到 servlet 输出流中
			ServletOutputStream sos=arg1.getOutputStream();
			ImageIO.write(buffImg, "jpeg", sos);
			sos.close();
			
		}
}
