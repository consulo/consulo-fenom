package ru.klkvsk.fenom.lexer;

import java.io.Reader;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.lexer.LookAheadLexer;
import com.intellij.lexer.MergingLexerAdapter;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import ru.klkvsk.fenom.psi.FenomTypes;


public class FenomTopLexer extends MergingLexerAdapter
{
	// To be merged
	private static final TokenSet TOKENS_TO_MERGE = TokenSet.create(FenomTypes.COMMENT, FenomTypes.WHITE_SPACE, FenomTypes.TEMPLATE_HTML_TEXT);

	public FenomTopLexer()
	{
		super(new LookAheadLexer(new FlexAdapter(new FenomTopFlexLexer((Reader) null)))
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