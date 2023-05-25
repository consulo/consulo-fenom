package ru.klkvsk.fenom.psi;

import consulo.virtualFileSystem.fileType.FileType;
import consulo.language.psi.PsiFileEx;
import jakarta.annotation.Nonnull;

public interface FenomFile extends PsiFileEx
{
	@Nonnull
	@Override
	FileType getFileType();
}