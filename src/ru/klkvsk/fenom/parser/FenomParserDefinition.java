package ru.klkvsk.fenom.parser;

import org.jetbrains.annotations.NotNull;
import com.intellij.lang.ASTNode;
import com.intellij.lang.LanguageVersion;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import ru.klkvsk.fenom.lexer.FenomLexer;
import ru.klkvsk.fenom.psi.FenomTypes;
import ru.klkvsk.fenom.psi.impl.FenomFileImpl;
import ru.klkvsk.fenom.psi.impl.FenomMacroAttrImpl;
import ru.klkvsk.fenom.psi.impl.FenomMacroNodeImpl;
import ru.klkvsk.fenom.psi.impl.FenomPsiElement;

public class FenomParserDefinition implements ParserDefinition
{
	@NotNull
	@Override
	public Lexer createLexer(Project project, @NotNull LanguageVersion languageVersion)
	{
		return new FenomLexer();
	}

	@Override
	public PsiParser createParser(Project project, @NotNull LanguageVersion languageVersion)
	{
		return new FenomParser();
	}

	@Override
	public IFileElementType getFileNodeType()
	{
		return FenomTypes.FILE;
	}

	@NotNull
	@Override
	public TokenSet getWhitespaceTokens(@NotNull LanguageVersion languageVersion)
	{
		return FenomTypes.WHITESPACES;
	}

	@NotNull
	@Override
	public TokenSet getCommentTokens(@NotNull LanguageVersion languageVersion)
	{
		return FenomTypes.COMMENTS;
	}

	@NotNull
	@Override
	public TokenSet getStringLiteralElements(@NotNull LanguageVersion languageVersion)
	{
		return FenomTypes.STRING_LITERALS;
	}

	@NotNull
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
