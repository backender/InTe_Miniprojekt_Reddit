package reddit;

import java.util.Locale;

import javax.faces.context.FacesContext;

public class LocaleBean {
	
	public void de() {
		FacesContext.getCurrentInstance()
        .getViewRoot().setLocale(Locale.GERMAN);
	}

	public void en() {
		FacesContext.getCurrentInstance()
        .getViewRoot().setLocale(Locale.ENGLISH);
	}
}
