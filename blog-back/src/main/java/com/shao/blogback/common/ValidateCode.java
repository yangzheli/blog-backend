package com.shao.blogback.common;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class ValidateCode {
    private Random random = new Random();
    private int width = 120;//宽
    private int heigth = 40;//高
    private int num = 4;//随机产生字符个数
    private int lineSize = 30;//干扰线数量
    private String randomString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private final String KEY = "ValidateCode";

    private Font getFont() {
        return new Font("Times New Roman", Font.ROMAN_BASELINE, 30);
    }

    private Color getRandomColor(int low, int high) {
        low = Math.min(low, 255);
        high = Math.min(high, 255);
        int r = low + random.nextInt(high - low);
        int g = low + random.nextInt(high - low);
        int b = low + random.nextInt(high - low);
        return new Color(r, g, b);
    }

    /**
     * 绘制干扰线
     */
    private void drawLine(Graphics g) {
        int x1 = random.nextInt(width);
        int y1 = random.nextInt(heigth);
        int x2 = x1 + random.nextInt(20);
        int y2 = y1 + random.nextInt(10);
        g.drawLine(x1, y1, x2, y2);
    }

    /**
     * 绘制字符串
     */
    private String getRandomString(Graphics g, String res, int index) {
        g.setFont(getFont());
        g.setColor(getRandomColor(100, 200));
        int k = randomString.length();
        String str = String.valueOf(randomString.charAt(random.nextInt(k)));
        g.drawString(str, 5 + index * 30, 30);
        res += str;
        return res;
    }

    /**
     * 生成随机字符串图片
     */
    public void getRandomImage(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        //BufferedImage类是具有缓冲区的Image类
        BufferedImage image = new BufferedImage(width, heigth, BufferedImage.TYPE_INT_BGR);
        Graphics g = image.getGraphics();
        g.fillRect(0, 0, width, heigth);
        g.setColor(getRandomColor(100, 200));
        g.setFont(getFont());

        //绘制干扰线
        for (int i = 0; i < lineSize; i++) {
            drawLine(g);
        }

        //绘制字符串
        String res = "";
        for (int i = 0; i < num; i++) {
            res = getRandomString(g, res, i);
        }

        session.removeAttribute(KEY);
        session.setAttribute(KEY, res);
        try {
            ImageIO.write(image, "PNG", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
