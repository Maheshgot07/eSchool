package common.datamodel.util;

public class StringUtil {

	public static boolean isBlankOrNull(String input) {
		if (input == null) {
			return true;
		}
		else if("".equalsIgnoreCase(input.trim())) {
			return true;
		}
		return false;
	}
}
