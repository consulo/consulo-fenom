package ru.klkvsk.fenom.psi.impl;

import consulo.language.ast.ASTNode;
import consulo.language.psi.PsiElement;
import ru.klkvsk.fenom.psi.FenomTypes;

/**
 * Curly brackets macro
 */
public class FenomMacroAttrImpl extends FenomPsiElement
{

	public FenomMacroAttrImpl(ASTNode node)
	{
		super(node);
	}

	public String getMacroName()
	{
		for(PsiElement el : getChildren())
		{
			if(el.getNode().getElementType() == FenomTypes.MACRO_NAME)
			{
				return el.getText();
			}
		}
		return null;
	}

	public PsiElement getParams()
	{
		for(PsiElement el : getChildren())
		{
			if(el.getNode().getElementType() == FenomTypes.PARAMS)
			{
				return el;
			}
		}
		return null;
	}
}
