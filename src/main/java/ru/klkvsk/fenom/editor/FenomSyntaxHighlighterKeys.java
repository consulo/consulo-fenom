package ru.klkvsk.fenom.editor;

import consulo.codeEditor.DefaultLanguageHighlighterColors;
import consulo.codeEditor.HighlighterColors;
import consulo.colorScheme.TextAttributesKey;

/**
 * @author VISTALL
 * @since 27.01.14
 */
public interface FenomSyntaxHighlighterKeys
{
	TextAttributesKey BAD_CHARACTER = TextAttributesKey.createTextAttributesKey("FENOM_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);

	TextAttributesKey COMMENT = TextAttributesKey.createTextAttributesKey("FENOM_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT);

	TextAttributesKey BRACKETS = TextAttributesKey.createTextAttributesKey("FENOM_BRACKETS", DefaultLanguageHighlighterColors.BRACKETS);

	TextAttributesKey IDENTIFIER = TextAttributesKey.createTextAttributesKey("FENOM_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER);

	TextAttributesKey KEYWORD = TextAttributesKey.createTextAttributesKey("FENOM_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);

	TextAttributesKey VARIABLE = TextAttributesKey.createTextAttributesKey("FENOM_VARIABLE", DefaultLanguageHighlighterColors.INSTANCE_FIELD);

	TextAttributesKey STRING = TextAttributesKey.createTextAttributesKey("FENOM_STRING", DefaultLanguageHighlighterColors.STRING);

	TextAttributesKey COMMA = TextAttributesKey.createTextAttributesKey("FENOM_COMMA", DefaultLanguageHighlighterColors.COMMA);

	TextAttributesKey NUMBER = TextAttributesKey.createTextAttributesKey("FENOM_NUMBER", DefaultLanguageHighlighterColors.NUMBER);

}
