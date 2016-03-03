package main.java.com.epam.preprod.kushnarenko.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.com.epam.preprod.kushnarenko.captcha.CaptchaManager;

public class CaptchaServlet extends HttpServlet {

    private static final long serialVersionUID = 8320272835383062593L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int width = 150;
        int height = 50;
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        Font font = new Font("TimesRoman", Font.ITALIC, 30);
        g2d.setFont(font);
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);
        g2d.setPaint(new Color(0));
        g2d.fillRect(0, 0, width, height);
        g2d.setColor(new Color(255, 255, 255));

        Random r = new Random();
        int index = 6;

        char[] data = new char[index];
        for (int i = 0; i < data.length; i++) {
            int a = r.nextInt(25);
            data[i] = (char) (97 + a);
        }

        String captcha = String.copyValueOf(data);

        String captchaId = request.getParameter("captchaId");
        CaptchaManager cg = (CaptchaManager) getServletContext().getAttribute("manager");
        cg.send(captchaId, captcha, request, response);

        int x = 0;
        int y = 0;
        for (int i = 0; i < data.length; i++)

        {
            x += 10 + (Math.abs(r.nextInt()) % 15);
            y = 20 + Math.abs(r.nextInt()) % 20;
            g2d.drawChars(data, i, 1, x, y);
        }

        g2d.dispose();

        response.setContentType("image/png");
        OutputStream os = response.getOutputStream();
        ImageIO.write(bufferedImage, "png", os);
        os.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
