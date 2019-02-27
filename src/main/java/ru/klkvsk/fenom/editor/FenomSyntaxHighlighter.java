package ru.klkvsk.fenom.editor;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nonnull;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import ru.klkvsk.fenom.lexer.FenomLexer;
import ru.klkvsk.fenom.psi.FenomTypes;

public class FenomSyntaxHighlighter extends SyntaxHighlighterBase implements FenomSyntaxHighlighterKeys
{
	// Groups of IElementType's
	public static final TokenSet sBAD = TokenSet.create(FenomTypes.BAD_CHARACTER);
	public static final TokenSet sCOMMENTS = TokenSet.create(FenomTypes.COMMENT);
	public static final TokenSet sBRACES = TokenSet.create(FenomTypes.OPENING, FenomTypes.CLOSING);
	public static final TokenSet sIDENTIFIERS = TokenSet.create(FenomTypes.IDENTIFIER);
	public static final TokenSet sKEYWORDS = TokenSet.create(FenomTypes.KEYWORD, FenomTypes.MACRO_NAME);
	public static final TokenSet sSTRINGS = TokenSet.create(FenomTypes.STRING);
	public static final TokenSet sVARIABLES = TokenSet.create(FenomTypes.VARIABLE);
	public static final TokenSet sPUNCTUATION = TokenSet.create(FenomTypes.COLON, FenomTypes.SEMICOLON, FenomTypes.EXCLAMATION, FenomTypes.COMMA,
			FenomTypes.ASSIGN, FenomTypes.MODIFIER, FenomTypes.ARRAY, FenomTypes.BRACKETS, FenomTypes.DOT, FenomTypes.LOGIC, FenomTypes.EXCLAMATION);
	public static final TokenSet sNUMBERS = TokenSet.create(FenomTypes.NUMBER);

	// Static container
	private static final Map<IElementType, TextAttributesKey> ourAttributes = new HashMap<IElementType, TextAttributesKey>();


	// Fill in the map
	static
	{
		fillMap(ourAttributes, sBAD, BAD_CHARACTER);
		fillMap(ourAttributes, sCOMMENTS, COMMENT);
		fillMap(ourAttributes, sBRACES, BRACKETS);
		fillMap(ourAttributes, sIDENTIFIERS, IDENTIFIER);
		fillMap(ourAttributes, sKEYWORDS, KEYWORD);
		fillMap(ourAttributes, sSTRINGS, STRING);
		fillMap(ourAttributes, sVARIABLES, VARIABLE);
		fillMap(ourAttributes, sPUNCTUATION, COMMA);
		fillMap(ourAttributes, sNUMBERS, NUMBER);
	}


	@Nonnull
	@Override
	public Lexer getHighlightingLexer()
	{
		return new FenomLexer();
	}

	@Nonnull
	@Override
	public TextAttributesKey[] getTokenHighlights(IElementType type)
	{
		return pack(ourAttributes.get(type));
	}
}