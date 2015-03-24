package internationalization;

import java.util.Locale;


public class LocaleUse {

	public static void main(String[] args) {
		
		String[] listofCountriesCode=Locale.getISOCountries();
		for(String countryCode:listofCountriesCode)
		{
			Locale locale=new Locale("", countryCode);
			System.out.println(locale.getDisplayCountry());
		}
	}

}
