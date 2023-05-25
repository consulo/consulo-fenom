package ru.klkvsk.fenom.lexer;

import consulo.language.lexer.MergingLexerAdapter;
import consulo.language.ast.TokenSet;
import ru.klkvsk.fenom.psi.FenomTypes;


public class FenomSubLexer extends MergingLexerAdapter
{
	// To be merged
	private static final TokenSet TOKENS_TO_MERGE = TokenSet.create(FenomTypes.WHITE_SPACE);

	public FenomSubLexer()
	{
		super(new FenomSubFlexLexer(), TOKENS_TO_MERGE);
	}
}
