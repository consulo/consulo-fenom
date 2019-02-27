package ru.klkvsk.fenom.psi;

import org.jetbrains.annotations.NonNls;
import javax.annotation.Nonnull;
import com.intellij.psi.tree.IElementType;
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