package ru.klkvsk.fenom;

import com.intellij.lang.Language;
import com.intellij.psi.templateLanguages.TemplateLanguage;

public class FenomLanguage extends Language implements TemplateLanguage
{
	public static final FenomLanguage INSTANCE = new FenomLanguage();

	private FenomLanguage()
	{
		super("FENOM");
	}
}