/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.awt.Transparency;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Isao Felipe Morigaki
 */
public class Utilidades {
    public static byte[] lerArquivo (String caminhoArquivo) throws IOException {
	byte[] conteudo = null;
	StringBuffer sb = new StringBuffer("");
	BufferedReader reader = null;
	try {
		reader = new BufferedReader(new FileReader(caminhoArquivo));
		String line = null;
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
                // convert string to byte array
		conteudo = sb.toString().trim().getBytes();
	} catch (IOException e) {
		throw new IOException("Unable to convert file to byte array. " + e.getMessage());
	} finally {
		if (reader != null) {
			reader.close();
		}
	}
	return conteudo;
    }
    public static BufferedImage createRGBImage(byte[] bytes, int width, int height) {
        DataBufferByte buffer = new DataBufferByte(bytes, bytes.length);
        ColorModel cm = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_sRGB), new int[]{8, 8, 8}, false, false, Transparency.OPAQUE, DataBuffer.TYPE_BYTE);
        return new BufferedImage(cm, Raster.createInterleavedRaster(buffer, width, height, width * 3, 3, new int[]{0, 1, 2}, null), false, null);
    }
}
