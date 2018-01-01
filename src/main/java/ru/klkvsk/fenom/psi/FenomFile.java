package ru.klkvsk.fenom.psi;

import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.impl.PsiFileEx;

public interface FenomFile extends PsiFileEx
{
	@NotNull
	@Override
	FileType getFileType();
}