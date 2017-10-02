package com.gasmps.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

/**
 *
 * @author akhtar
 */

@Component
public class Regex {

	private String inpuString;
	private int type;

	public Regex() {
	}

	public Regex(String inpuString, int type) {
		this.inpuString = inpuString;
		this.type = type;
	}

	public String getInpuString() {
		return inpuString;
	}

	public void setInpuString(String inpuString) {
		this.inpuString = inpuString;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public boolean isValid() throws NullPointerException {
		Matcher matcher;
		boolean isValid = false;
		switch (type) {
		case 1:
			matcher = Constant.RegexPattern.EMAIL_REGEX.matcher(inpuString);
			isValid = matcher.find();
			break;
		case 2:
			matcher = Constant.RegexPattern.MOBILE_REGEX.matcher(inpuString);
			isValid = matcher.find();
			break;
		case 3:
			matcher = Constant.RegexPattern.NUMBER_REGEX.matcher(inpuString);
			isValid = matcher.find();
			break;
		}
		return isValid;
	}

	public static boolean isValid(String inpuString, int type) {
		Matcher matcher;
		boolean isValid = false;
		switch (type) {
		case 1:
			matcher = Constant.RegexPattern.EMAIL_REGEX.matcher(inpuString);
			isValid = matcher.find();
			break;
		case 2:
			matcher = Constant.RegexPattern.MOBILE_REGEX.matcher(inpuString);
			isValid = matcher.find();
			break;
		case 3:
			matcher = Constant.RegexPattern.NUMBER_REGEX.matcher(inpuString);
			isValid = matcher.find();
			break;
		}
		return isValid;
	}
}
