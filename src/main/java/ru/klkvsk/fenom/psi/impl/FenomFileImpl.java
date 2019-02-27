package ru.klkvsk.fenom.psi.impl;

import javax.annotation.Nonnull;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
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
