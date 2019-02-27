package ru.klkvsk.fenom.parser;

import javax.annotation.Nonnull;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import consulo.lang.LanguageVersion;
import ru.klkvsk.fenom.lexer.FenomLexer;
import ru.klkvsk.fenom.psi.FenomTypes;
import ru.klkvsk.fenom.psi.impl.FenomFileImpl;
import ru.klkvsk.fenom.psi.impl.FenomMacroAttrImpl;
import ru.klkvsk.fenom.psi.impl.FenomMacroNodeImpl;
import ru.klkvsk.fenom.psi.impl.FenomPsiElement;

public class FenomParserDefinition implements ParserDefinition
{
	@Nonnull
	@Override
	public Lexer createLexer(@Nonnull LanguageVersion languageVersion)
	{
		return new FenomLexer();
	}

	@Override
	public PsiParser createParser(@Nonnull LanguageVersion languageVersion)
	{
		return new FenomParser();
	}

	@Override
	public IFileElementType getFileNodeType()
	{
		return FenomTypes.FILE;
	}

	@Nonnull
	@Override
	public TokenSet getWhitespaceTokens(@Nonnull LanguageVersion languageVersion)
	{
		return FenomTypes.WHITESPACES;
	}

	@Nonnull
	@Override
	public TokenSet getCommentTokens(@Nonnull LanguageVersion languageVersion)
	{
		return FenomTypes.COMMENTS;
	}

	@Nonnull
	@Override
	public TokenSet getStringLiteralElements(@Nonnull LanguageVersion languageVersion)
	{
		return FenomTypes.STRING_LITERALS;
	}

	@Nonnull
	@Override
	public PsiElement createElement(ASTNode node)
	{
		IElementType type = node.getElementType();

		if(type == FenomTypes.MACRO_NODE)
		{
			return new FenomMacroNodeImpl(node);
		}
		else if(type == FenomTypes.MACRO_ATTR)
		{
			return new FenomMacroAttrImpl(node);
		}
		else
		{
			return new FenomPsiElement(node);
		}
	}

	@Override
	public PsiFile createFile(FileViewProvider fileViewProvider)
	{
		return new FenomFileImpl(fileViewProvider);
	}

	@Override
	public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode astNode, ASTNode astNode1)
	{
		return SpaceRequirements.MAY;
	}
}
