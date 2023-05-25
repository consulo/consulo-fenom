// This is a generated file. Not intended for manual editing.
package ru.klkvsk.fenom.parser;

import jakarta.annotation.Nonnull;

import consulo.language.parser.PsiBuilder;
import consulo.language.parser.PsiBuilder.Marker;
import consulo.language.ast.IElementType;
import consulo.language.version.LanguageVersion;
import consulo.language.ast.ASTNode;
import consulo.language.parser.PsiParser;
import ru.klkvsk.fenom.psi.FenomTypes;

public class FenomParser implements PsiParser
{
	@Nonnull
	@Override
	public ASTNode parse(IElementType root, PsiBuilder builder, LanguageVersion languageVersion)
	{
		Marker marker = builder.mark();

		// Process all tokens
		while(!builder.eof())
		{
			IElementType type = builder.getTokenType();

			if(type == FenomTypes.OPENING)
			{
				parseMacro(builder);
			}

			builder.advanceLexer(); // move to next token
		}

		marker.done(root);
		return builder.getTreeBuilt();
	}

	// {macro ...}
	private void parseMacro(PsiBuilder builder)
	{
		Marker macroStart = builder.mark();
		builder.advanceLexer();

		// is there a name?
		String tagName = null;
		if(builder.getTokenType() == FenomTypes.MACRO_NAME)
		{
			Marker macroNameMark = builder.mark();
			tagName = builder.getTokenText();
			builder.advanceLexer();
			macroNameMark.done(FenomTypes.MACRO_NAME);
		}

		// params
		Marker paramsMark = builder.mark();
		parseParams(tagName, builder, FenomTypes.CLOSING);
		paramsMark.done(FenomTypes.PARAMS);

		// finish him
		if(builder.getTokenType() == FenomTypes.CLOSING)
		{
			builder.advanceLexer();
		}
		macroStart.done(FenomTypes.MACRO_NODE);
	}

	// custom params
	private void parseParams(String macroName, PsiBuilder builder, IElementType closing)
	{
		// just process it atm
		while(builder.getTokenType() != closing && !builder.eof())
		{
			builder.advanceLexer();
		}

	}
}
