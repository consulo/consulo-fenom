package ru.klkvsk.fenom.psi;

import javax.annotation.Nonnull;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.impl.PsiFileEx;

public interface FenomFile extends PsiFileEx
{
	@Nonnull
	@Override
	FileType getFileType();
}