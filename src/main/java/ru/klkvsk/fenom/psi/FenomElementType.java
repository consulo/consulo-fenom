package ru.klkvsk.fenom.psi;

import jakarta.annotation.Nonnull;

import consulo.language.ast.IElementType;
import org.jetbrains.annotations.NonNls;
import ru.klkvsk.fenom.FenomLanguage;

public class FenomElementType extends IElementType
{
	public FenomElementType(@Nonnull @NonNls String debugName)
	{
		super(debugName, FenomLanguage.INSTANCE);
	}
}