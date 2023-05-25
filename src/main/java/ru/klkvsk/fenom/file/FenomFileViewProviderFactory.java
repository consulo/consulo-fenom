package ru.klkvsk.fenom.file;

import consulo.annotation.component.ExtensionImpl;
import consulo.language.Language;
import consulo.language.file.FileViewProvider;
import consulo.language.file.LanguageFileViewProviderFactory;
import consulo.language.psi.PsiManager;
import consulo.virtualFileSystem.VirtualFile;
import jakarta.annotation.Nonnull;
import ru.klkvsk.fenom.FenomLanguage;


@ExtensionImpl
public class FenomFileViewProviderFactory implements LanguageFileViewProviderFactory
{
	@Override
	public FileViewProvider createFileViewProvider(VirtualFile virtualFile, Language language, PsiManager psiManager, boolean physical)
	{
		return new FenomFileViewProvider(psiManager, virtualFile, physical);
	}

	@Nonnull
	@Override
	public Language getLanguage()
	{
		return FenomLanguage.INSTANCE;
	}
}
