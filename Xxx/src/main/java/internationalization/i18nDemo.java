package internationalization;
import java.util.Locale;
import java.util.ResourceBundle;
public class i18nDemo {
	public static void main(String[] args) {
		Locale locale1 = new Locale("en", "US");
		Locale locale2 = new Locale("es", "US");
		ResourceBundle labels1 = ResourceBundle.getBundle("messages", locale1);
		System.out.println(labels1.getString("label1"));
		ResourceBundle labels2 = ResourceBundle.getBundle("messages", locale2);
		System.out.println(labels2.getString("label2"));
	}
}
