package ru.klkvsk.fenom.editor;

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import ru.klkvsk.fenom.FenomLanguage;

/**
 * @author VISTALL
 * @since 27.01.14
 */
public interface FenomSyntaxHighlighterKeys
{
	TextAttributesKey BAD_CHARACTER = TextAttributesKey.createTextAttributesKey(FenomLanguage.INSTANCE, HighlighterColors.BAD_CHARACTER);

	TextAttributesKey COMMENT = TextAttributesKey.createTextAttributesKey(FenomLanguage.INSTANCE, DefaultLanguageHighlighterColors.BLOCK_COMMENT);

	TextAttributesKey BRACKETS = TextAttributesKey.createTextAttributesKey(FenomLanguage.INSTANCE, DefaultLanguageHighlighterColors.BRACKETS);

	TextAttributesKey IDENTIFIER = TextAttributesKey.createTextAttributesKey(FenomLanguage.INSTANCE, DefaultLanguageHighlighterColors.IDENTIFIER);

	TextAttributesKey KEYWORD = TextAttributesKey.createTextAttributesKey(FenomLanguage.INSTANCE, DefaultLanguageHighlighterColors.KEYWORD);

	TextAttributesKey VARIABLE = TextAttributesKey.createTextAttributesKey(FenomLanguage.INSTANCE, DefaultLanguageHighlighterColors.INSTANCE_FIELD);

	TextAttributesKey STRING = TextAttributesKey.createTextAttributesKey(FenomLanguage.INSTANCE, DefaultLanguageHighlighterColors.STRING);

	TextAttributesKey COMMA = TextAttributesKey.createTextAttributesKey(FenomLanguage.INSTANCE, DefaultLanguageHighlighterColors.COMMA);

	TextAttributesKey NUMBER = TextAttributesKey.createTextAttributesKey(FenomLanguage.INSTANCE, DefaultLanguageHighlighterColors.NUMBER);

}
