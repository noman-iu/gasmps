/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gasmps.utils;

import java.io.File;
import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author akhtar
 */
@Component
@Scope("singleton")
public class Global {

	public Global() {
		
	}

	static final String regex1 = "^[0-9]*$";
	static Pattern p1 = Pattern.compile(regex1);
	static final String regex2 = "^[a-zA-Z]*$";
	static Pattern p2 = Pattern.compile(regex2);
	static final String regex3 = "^[a-zA-Z0-9]*$";
	static Pattern p3 = Pattern.compile(regex3);
	static final String regex4 = "^[a-zA-Z0-9@\\-_,/. ]*$";
	static Pattern p4 = Pattern.compile(regex4);
	static final String regex5 = "^[a-zA-Z0-9\\-_ ]*$";
	static Pattern p5 = Pattern.compile(regex5);
	static final String regex6 = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
	static Pattern p6 = Pattern.compile(regex6);
	static final String regex7 = "^[a-zA-Z0-9\\-_ ]*$";
	static Pattern p7 = Pattern.compile(regex7);
	static final String regex8 = "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$";
	static Pattern p8 = Pattern.compile(regex8);
	static final String regex9 = "^[a-zA-Z]*$";
	static Pattern p9 = Pattern.compile(regex9);
	

	/**
	 * Utility Method to pad a string S with a size of N with char C on the left
	 * (True) or on the right(false)
	 *
	 * @param s
	 *            (String) to be padded
	 * @param n
	 *            (int) Resultants size of the padded string
	 * @param c
	 *            (String) Padding character
	 * @param paddingLeft
	 *            (True/False) - Left Padding
	 *
	 * @author akhtar
	 */
	public static String paddingString(String s, int n, String c, boolean paddingLeft) {

		StringBuffer str = new StringBuffer(s);
		int strLength = str.length();
		if (n > 0 && n > strLength) {
			for (int i = 0; i <= n; i++) {
				if (paddingLeft) {
					if (i < n - strLength)
						str.insert(0, c);
				} else {
					if (i > strLength)
						str.append(c);
				}
			}
		}
		return str.toString().trim();
	}

	public static String validateInputData(String input) {
		String response = "OK";
		try {
			String attributeArray[] = null;
			boolean ret = false;
			int i;
			String containerArray[] = input.split("\\#");
			for (i = 0; i < containerArray.length; i++) {

				attributeArray = containerArray[i].split("\\|");
				ret = Global.validateInputString(Integer.parseInt(attributeArray[1]), attributeArray[2]);
				if (ret) {
					continue;
				} else {
					System.err.println("validateInputData:" + attributeArray[0] + "," + attributeArray[1] + ","
							+ attributeArray[2]);
					response = containerArray[i].split("\\|")[0];
					break;
				}

			}

		} catch (Exception ex) {
			response = "NOK";
			ex.printStackTrace();
		}
		return response;
	}

	/**
	 * Utility Method to validate a string _input with a given input format
	 * _inputType
	 *
	 * for _inputType value 0 : Numeric String (0 to 9) any time value 1 : Alphabet
	 * String (Aa to Zz) any time value 2 : Alphabet and Numeric String (Aa0 to Zz9)
	 * any time value 3 : Alpha-Numeric with , / - _ @ and space value 4 :
	 * //Alpha-Numeric with - _ and space
	 *
	 * 
	 * @author akhtar
	 */

	public static boolean validateInputString(int inputType, String input) {
		boolean ret = false;
		switch (inputType) {
		case 1: // Numeric
		{
			Matcher m1 = p1.matcher(input);
			ret = m1.find();
		}
			break;
		case 2: // Alpha
		{
			Matcher m2 = p2.matcher(input);
			ret = m2.find();
		}
			break;
		case 3: // Alpha-Numeric
		{
			Matcher m3 = p3.matcher(input);
			ret = m3.find();
		}
			break;
		case 4: // Alpha-Numeric with , / - _ @ and space
		{
			Matcher m4 = p4.matcher(input);
			ret = m4.find();
		}
			break;
		case 5: // Alpha-Numeric with - _ and space
		{
			Matcher m5 = p5.matcher(input);
			ret = m5.find();
		}
			break;
		case 6: // Email
		{
			Matcher m6 = p6.matcher(input);
			ret = m6.find();
		}
			break;
		case 7: // message
		{
			Matcher m7 = p7.matcher(input);
			ret = m7.find();
		}
			break;
		case 8: // Name:FirstName,LastName
		{
			Matcher m8 = p8.matcher(input);
			ret = m8.find();
		}
			break;
		case 9: // alphabet with space only
		{
			Matcher m9 = p9.matcher(input);
			ret = m9.find();
		}
			break;
		case 10: {
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy");
			try {
				sdf1.parse(input);
				ret = true;
			} catch (ParseException pe) {
				ret = false;
			}
		}
			break;
		default:
			break;
		}

		return ret;
	}

	/*
	 * This Utility Method is used to validate Image Data Input : Image path
	 * Output:true/false
	 */

	@SuppressWarnings("finally")
	public static boolean validateImageData(String path) {
		boolean isImage = false;
		try {
			File file = new File(path);
			ImageInputStream iis = ImageIO.createImageInputStream(file);
			Iterator<ImageReader> readers = ImageIO.getImageReaders(iis);
			iis.flush();
			iis.close();
			String formatName = "";
			if (!readers.hasNext()) {
				isImage = false;
			} else {
				ImageReader reader = readers.next();
				formatName = reader.getFormatName();
				if ("jpeg".equalsIgnoreCase(reader.getFormatName())) {

					isImage = true;
					formatName = "jpeg";

				} else if ("png".equalsIgnoreCase(reader.getFormatName())) {
					isImage = true;
					formatName = "png";

				} else if ("jpg".equalsIgnoreCase(reader.getFormatName())) {

					isImage = true;
					formatName = "jpg";

				} else {
					isImage = false;
				}

			}
			// System.out.println("Is Image Format: "+isImage);
			// System.out.println("Image Format: " + formatName);
		} catch (Exception ex) {
			isImage = false;
			ex.printStackTrace();
		} finally {
			return isImage;
		}

	}

	/*
	 * This Utility Method is used to validate PDF Data Input : Image path
	 * Output:true/false
	 */

	@SuppressWarnings("finally")
	public static boolean validatePDFData(String path) {

		org.apache.pdfbox.pdfparser.PDFParser parser = null;
		PDDocument pdDoc = null;
		COSDocument cosDoc = null;
		PDFTextStripper pdfStripper;
		boolean isPDF = false;

		try {
			String parsedText;
			File file = new File(path);
			parser = new PDFParser(new FileInputStream(file));
			parser.parse();
			cosDoc = parser.getDocument();
			pdfStripper = new PDFTextStripper();
			pdDoc = new PDDocument(cosDoc);
			parsedText = pdfStripper.getText(pdDoc);
			isPDF = true;

		} catch (Exception ex) {
			isPDF = false;
			ex.printStackTrace();
		} finally {
			try {
				if (cosDoc != null)
					cosDoc.close();
				if (pdDoc != null)
					pdDoc.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return isPDF;
		}
	}

	public static void main(String at[]) {

		// System.err.println(Utility.validateInputString(9,"ghu"));
		Global.validatePDFData(null);
	}


	

	/*public static void emailAlert(EmailAlert el) {

		Connection con = null;
		try {
			DataSource ds = Global.getDataSourse();
			con = ds.getConnection();
			String log_id = Global.getSequence("EMAIL_ID");
			String sqlInsert = "insert into tbl_email_alert (email_id , mail_receiver , email_message , email_subject , email_preority , email_status , email_mode , email_path , email_attachment_type , email_attachment)"
					+ " values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement psInsert = con.prepareStatement(sqlInsert);
			psInsert.setString(1, log_id.trim());
			psInsert.setString(2, el.getMailReceiver());
			psInsert.setString(3, el.getEmailMessage());
			psInsert.setString(4, el.getEmailSubject());
			psInsert.setString(5, el.getEmailPreority());
			psInsert.setString(6, el.getEmailStatus());
			psInsert.setString(7, el.getEmailMode());
			psInsert.setString(8, el.getEmailPath());
			psInsert.setString(9, el.getEmailAttachmentType());
			psInsert.setBlob(10, new javax.sql.rowset.serial.SerialBlob(el.getEmailAttachment()));
			psInsert.execute();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		}

	}*/

}
