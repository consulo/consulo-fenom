package ru.klkvsk.fenom.psi;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import com.intellij.psi.tree.IElementType;
import ru.klkvsk.fenom.FenomLanguage;

public class FenomTokenType extends IElementType
{

	public FenomTokenType(@NotNull @NonNls String debugName)
	{
		super(debugName, FenomLanguage.INSTANCE);
	}

	@Override
	public String toString()
	{
		return "FenomTokenType." + super.toString();
	}
}