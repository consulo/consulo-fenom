package ru.klkvsk.fenom.parser;

import consulo.annotation.component.ExtensionImpl;
import consulo.language.Language;
import jakarta.annotation.Nonnull;

import consulo.language.ast.ASTNode;
import consulo.language.ast.IElementType;
import consulo.language.ast.IFileElementType;
import consulo.language.parser.ParserDefinition;
import consulo.language.parser.PsiParser;
import consulo.language.lexer.Lexer;
import consulo.language.file.FileViewProvider;
import consulo.language.psi.PsiElement;
import consulo.language.ast.TokenSet;
import consulo.language.version.LanguageVersion;
import consulo.language.psi.PsiFile;
import ru.klkvsk.fenom.FenomLanguage;
import ru.klkvsk.fenom.lexer.FenomLexer;
import ru.klkvsk.fenom.psi.FenomTypes;
import ru.klkvsk.fenom.psi.impl.FenomFileImpl;
import ru.klkvsk.fenom.psi.impl.FenomMacroAttrImpl;
import ru.klkvsk.fenom.psi.impl.FenomMacroNodeImpl;
import ru.klkvsk.fenom.psi.impl.FenomPsiElement;

@ExtensionImpl
public class FenomParserDefinition implements ParserDefinition
{
	@Nonnull
	@Override
	public Language getLanguage()
	{
		return FenomLanguage.INSTANCE;
	}

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
