package goldbigdragon.github.io.util;

public class NumericUtil {
	public static boolean isFloat(String value, float min, float max) {
		try {
			if (Float.parseFloat(value) >= min && Float.parseFloat(value) <= max) {
				return true;
			} else {
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean isInteger(String value, float min, float max) {
		try {
			if (Integer.parseInt(value) >= min && Integer.parseInt(value) <= max) {
				return true;
			} else {
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
