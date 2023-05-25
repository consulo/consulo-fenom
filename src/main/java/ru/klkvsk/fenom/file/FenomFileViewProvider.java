package ru.klkvsk.fenom.file;

import consulo.language.Language;
import consulo.language.impl.file.MultiplePsiFilesPerDocumentFileViewProvider;
import consulo.language.impl.psi.PsiFileImpl;
import consulo.language.parser.ParserDefinition;
import consulo.language.plain.PlainTextLanguage;
import consulo.language.psi.LanguageSubstitutors;
import consulo.language.psi.PsiFile;
import consulo.language.psi.PsiManager;
import consulo.language.template.TemplateDataLanguageMappings;
import consulo.language.template.TemplateLanguage;
import consulo.language.template.TemplateLanguageFileViewProvider;
import consulo.virtualFileSystem.VirtualFile;
import consulo.xml.lang.html.HTMLLanguage;
import ru.klkvsk.fenom.FenomLanguage;
import ru.klkvsk.fenom.psi.FenomTypes;

import jakarta.annotation.Nonnull;
import java.util.Set;


public class FenomFileViewProvider extends MultiplePsiFilesPerDocumentFileViewProvider implements TemplateLanguageFileViewProvider
{
	// main language of the file (HTML)
	private final Language myTemplateDataLanguage;


	// default constructor from parent
	public FenomFileViewProvider(PsiManager manager, VirtualFile file, boolean physical)
	{
		super(manager, file, physical);

		// get the main language of the file
		Language dataLang = TemplateDataLanguageMappings.getInstance(manager.getProject()).getMapping(file);
		if(dataLang == null)
		{
			dataLang = HTMLLanguage.INSTANCE;
		}

		// some magic?
		if(dataLang instanceof TemplateLanguage)
		{
			myTemplateDataLanguage = PlainTextLanguage.INSTANCE;
		}
		else
		{
			myTemplateDataLanguage = LanguageSubstitutors.substituteLanguage(dataLang, file, manager.getProject());
		}
	}

	// constructor to be used by self
	public FenomFileViewProvider(PsiManager psiManager, VirtualFile virtualFile, boolean physical, Language myTemplateDataLanguage)
	{
		super(psiManager, virtualFile, physical);
		this.myTemplateDataLanguage = myTemplateDataLanguage;
	}


	@Nonnull
	@Override
	public Language getBaseLanguage()
	{
		return FenomLanguage.INSTANCE;
	}

	@Nonnull
	@Override
	public Language getTemplateDataLanguage()
	{
		return myTemplateDataLanguage;
	}

	@Nonnull
	@Override
	public Set<Language> getLanguages()
	{
		return Set.of(FenomLanguage.INSTANCE, myTemplateDataLanguage);
	}

	@Override
	protected MultiplePsiFilesPerDocumentFileViewProvider cloneInner(VirtualFile virtualFile)
	{
		return new FenomFileViewProvider(getManager(), virtualFile, false, myTemplateDataLanguage);
	}


	@Override
	protected PsiFile createFile(Language lang)
	{
		// creating file for main lang (HTML)
		if(lang == myTemplateDataLanguage)
		{
			PsiFileImpl file = (PsiFileImpl) ParserDefinition.forLanguage(lang).createFile(this);
			file.setContentElementType(FenomTypes.TEMPLATE_DATA);
			return file;
		}
		else if(lang == FenomLanguage.INSTANCE)
		{
			return ParserDefinition.forLanguage(lang).createFile(this);
		}
		else
		{
			return null;
		}
	}
}
