package ru.klkvsk.fenom.lexer;

import java.io.Reader;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.MergingLexerAdapter;
import com.intellij.psi.tree.TokenSet;
import ru.klkvsk.fenom.psi.FenomTypes;


public class FenomSubLexer extends MergingLexerAdapter
{
	// To be merged
	private static final TokenSet TOKENS_TO_MERGE = TokenSet.create(FenomTypes.WHITE_SPACE);

	public FenomSubLexer()
	{
		super(new FlexAdapter(new FenomSubFlexLexer((Reader) null)), TOKENS_TO_MERGE);
	}
}
