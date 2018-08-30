/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.semesterII.simulator.util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Randula
 */
public class ImageResizer {

    private final int WIDTH = 390;
    private final int HEIGHT = 270;

    public String resize(String location)
            throws IOException {

        /**
         * reads the new input image
         */
        File inputFile = new File(location);
        BufferedImage inputImage = ImageIO.read(inputFile);

        /**
         * create the output image
         */
        BufferedImage outputImage = new BufferedImage(WIDTH, HEIGHT, inputImage.getType());

        /**
         * set the size of the new image
         */
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(inputImage, 0, 0, WIDTH, HEIGHT, null);
        g2d.dispose();

        /**
         * set the new file name
         */
        String[] formatName = location.split("\\.");
        System.out.println(location);
        String outputPath = formatName[0] + "1." + formatName[1];

        /**
         * writes the new image into the file
         */
        ImageIO.write(outputImage, "png", new File(outputPath));
        return outputPath;
    }
}
