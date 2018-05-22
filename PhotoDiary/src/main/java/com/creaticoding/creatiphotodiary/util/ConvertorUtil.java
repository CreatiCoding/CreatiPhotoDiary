package com.creaticoding.creatiphotodiary.util;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

/**
 * 변환 유틸
 * 
 * @author creaticoding
 */
@Component
public class ConvertorUtil {
	/**
	 * awt 버퍼 이미지 -> byte[] 변수
	 * 
	 * @param BufferedImage
	 * @return byte[]
	 */
	public byte[] BufferedImage2ByteArray(BufferedImage originalImage) {
		byte[] imageInByte;
		ByteArrayOutputStream baos;
		if (originalImage == null)
			return null;
		try {
			baos = new ByteArrayOutputStream();
			ImageIO.write(originalImage, "jpg", baos);
			baos.flush();
			imageInByte = baos.toByteArray();
			baos.close();
			return imageInByte;
		} catch (IOException e) {
			return null;
		}
	}

	/**
	 * byte[] 변수 -> awt 버퍼 이미지
	 * 
	 * @param byte[]
	 * @return BufferedImage
	 */
	public BufferedImage byteArr2bufferedImage(byte[] imageInByte) {
		InputStream in;
		BufferedImage bImageFromConvert;
		if (imageInByte == null)
			return null;
		try {
			in = new ByteArrayInputStream(imageInByte);
			bImageFromConvert = ImageIO.read(in);
			in.close();
			ImageIO.write(bImageFromConvert, "jpg",
					new File(new ClassPathResource("image/temp.jpg").getURI().getPath()));
			return bImageFromConvert;
		} catch (IOException e) {
			return null;
		}
	}
}
