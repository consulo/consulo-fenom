package ru.klkvsk.fenom.psi;

import javax.annotation.Nonnull;

import org.jetbrains.annotations.NonNls;
import com.intellij.psi.tree.IElementType;
import ru.klkvsk.fenom.FenomLanguage;

public class FenomElementType extends IElementType
{
	public FenomElementType(@Nonnull @NonNls String debugName)
	{
		super(debugName, FenomLanguage.INSTANCE);
	}
}