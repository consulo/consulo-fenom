package ru.klkvsk.fenom;

import consulo.language.Language;
import consulo.language.template.TemplateLanguage;

public class FenomLanguage extends Language implements TemplateLanguage
{
	public static final FenomLanguage INSTANCE = new FenomLanguage();

	private FenomLanguage()
	{
		super("FENOM");
	}
}