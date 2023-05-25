package ru.klkvsk.fenom.psi;

import org.jetbrains.annotations.NonNls;
import jakarta.annotation.Nonnull;
import consulo.language.ast.IElementType;
import ru.klkvsk.fenom.FenomLanguage;

public class FenomTokenType extends IElementType
{

	public FenomTokenType(@Nonnull @NonNls String debugName)
	{
		super(debugName, FenomLanguage.INSTANCE);
	}

	@Override
	public String toString()
	{
		return "FenomTokenType." + super.toString();
	}
}