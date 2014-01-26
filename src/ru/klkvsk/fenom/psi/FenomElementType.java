package ru.klkvsk.fenom.psi;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import com.intellij.psi.tree.IElementType;
import ru.klkvsk.fenom.FenomLanguage;

public class FenomElementType extends IElementType
{
	public FenomElementType(@NotNull @NonNls String debugName)
	{
		super(debugName, FenomLanguage.INSTANCE);
	}
}