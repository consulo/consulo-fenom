package ru.klkvsk.fenom.psi.impl;

import consulo.language.file.FileViewProvider;
import consulo.virtualFileSystem.fileType.FileType;
import consulo.language.impl.psi.PsiFileBase;
import jakarta.annotation.Nonnull;
import ru.klkvsk.fenom.FenomLanguage;
import ru.klkvsk.fenom.file.FenomFileType;
import ru.klkvsk.fenom.psi.FenomFile;

public class FenomFileImpl extends PsiFileBase implements FenomFile
{
	public FenomFileImpl(FileViewProvider viewProvider)
	{
		super(viewProvider, FenomLanguage.INSTANCE);
	}

	@Nonnull
	@Override
	public FileType getFileType()
	{
		return FenomFileType.INSTANCE;
	}

	@Override
	public String toString()
	{
		return "FenomFile:" + getName();
	}
}
