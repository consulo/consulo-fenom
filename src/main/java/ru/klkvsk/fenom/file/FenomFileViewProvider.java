package ru.klkvsk.fenom.file;

import com.intellij.lang.Language;
import com.intellij.lang.LanguageParserDefinitions;
import com.intellij.lang.html.HTMLLanguage;
import com.intellij.openapi.fileTypes.PlainTextLanguage;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.LanguageSubstitutors;
import com.intellij.psi.MultiplePsiFilesPerDocumentFileViewProvider;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.impl.source.PsiFileImpl;
import com.intellij.psi.templateLanguages.TemplateDataLanguageMappings;
import com.intellij.psi.templateLanguages.TemplateLanguage;
import com.intellij.psi.templateLanguages.TemplateLanguageFileViewProvider;
import ru.klkvsk.fenom.FenomLanguage;
import ru.klkvsk.fenom.psi.FenomTypes;

import javax.annotation.Nonnull;
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
			myTemplateDataLanguage = LanguageSubstitutors.INSTANCE.substituteLanguage(dataLang, file, manager.getProject());
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
			PsiFileImpl file = (PsiFileImpl) LanguageParserDefinitions.INSTANCE.forLanguage(lang).createFile(this);
			file.setContentElementType(FenomTypes.TEMPLATE_DATA);
			return file;
		}
		else if(lang == FenomLanguage.INSTANCE)
		{
			return LanguageParserDefinitions.INSTANCE.forLanguage(lang).createFile(this);
		}
		else
		{
			return null;
		}
	}
}
