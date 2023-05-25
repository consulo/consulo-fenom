package ru.klkvsk.fenom.lexer;

import consulo.language.ast.IElementType;
import consulo.language.ast.TokenSet;
import consulo.language.lexer.Lexer;
import consulo.language.lexer.LookAheadLexer;
import consulo.language.lexer.MergingLexerAdapter;
import ru.klkvsk.fenom.psi.FenomTypes;


public class FenomTopLexer extends MergingLexerAdapter
{
	// To be merged
	private static final TokenSet TOKENS_TO_MERGE = TokenSet.create(FenomTypes.COMMENT, FenomTypes.WHITE_SPACE, FenomTypes.TEMPLATE_HTML_TEXT);

	public FenomTopLexer()
	{
		super(new LookAheadLexer(new FenomTopFlexLexer())
		{

			@Override
			protected void lookAhead(Lexer lex)
			{
				IElementType type = lex.getTokenType();
				addToken(type);
				lex.advance();
			}
		}, TOKENS_TO_MERGE);
	}
}