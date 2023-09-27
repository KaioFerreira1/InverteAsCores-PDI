package org.pdi.methods;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class InverterAsCores {
    public static void InverterAsCores () {
        //Caminho da imagem de saída
        String saidaDeImagem = "output.jpg";

        try {
            BufferedImage imagem = ImageIO.read(new File("C:\\Users\\kaiof\\Downloads\\sombrinhas.jpg"));

            int width = imagem.getWidth();
            int height = imagem.getHeight();

            BufferedImage imagemsaida = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {

                    int pixel = imagem.getRGB(x, y);


                    int red = 255 - ((pixel >> 16) & 0xFF);
                    int green = 255 - ((pixel >> 8) & 0xFF);
                    int blue = 255 - (pixel & 0xFF);


                    int newPixel = (red << 16) | (green << 8) | blue;

                    imagemsaida.setRGB(x, y, newPixel);
                }
            }

            // Salve a nova imagem
            ImageIO.write(imagemsaida, "jpg", new File(saidaDeImagem));
            System.out.println("Imagem processada e salva com sucesso.");

            JFrame janela = new JFrame();
            ImageIcon icon = new ImageIcon(imagemsaida);
            JLabel label = new JLabel(icon);
            janela.add(label);
            janela.pack();
            janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            janela.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
