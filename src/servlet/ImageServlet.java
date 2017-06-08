package servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * Created by admin on 20.12.2016.
 */
@WebServlet(name = "ImageServlet", urlPatterns = "/image")
public class ImageServlet extends HttpServlet {

    protected void generateImage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/png");
        OutputStream out = response.getOutputStream();
        try {
            BufferedImage im = new BufferedImage(300, 200,
                    BufferedImage.TYPE_INT_RGB);
            Random random = new Random();
            Graphics g = im.getGraphics();
            g.setColor(new Color(0, 0,0));
            g.fillRect(0, 0, im.getWidth(), im.getHeight());
            g.setColor(new Color(
                    random.nextInt(200) + 55,
                    random.nextInt(200) + 55,
                    random.nextInt(200) + 55));
            g.setFont(new Font(null, Font.BOLD, 30));
            g.drawString("Hello world!", 50, 50);
            ImageIO.write(im, "png", out);
        } finally {
            out.close();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        generateImage(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        generateImage(request, response);
    }
}
