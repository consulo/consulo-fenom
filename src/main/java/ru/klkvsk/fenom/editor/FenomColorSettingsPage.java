package ru.klkvsk.fenom.editor;

import consulo.annotation.component.ExtensionImpl;
import consulo.colorScheme.TextAttributesKey;
import consulo.colorScheme.setting.AttributesDescriptor;
import consulo.colorScheme.setting.ColorDescriptor;
import consulo.language.editor.colorScheme.setting.ColorSettingsPage;
import consulo.language.editor.highlight.SyntaxHighlighter;
import consulo.localize.LocalizeValue;
import jakarta.annotation.Nonnull;

import java.util.Map;

@ExtensionImpl
public class FenomColorSettingsPage implements ColorSettingsPage
{
	public static final AttributesDescriptor[] ATTRS = {
			new AttributesDescriptor("Comments", FenomSyntaxHighlighterKeys.COMMENT),
			new AttributesDescriptor("Brackets", FenomSyntaxHighlighterKeys.BRACKETS),
			new AttributesDescriptor("Keywords", FenomSyntaxHighlighterKeys.KEYWORD),
			new AttributesDescriptor("Variables", FenomSyntaxHighlighterKeys.VARIABLE),
			new AttributesDescriptor("Strings", FenomSyntaxHighlighterKeys.STRING),
			new AttributesDescriptor("Punctuation", FenomSyntaxHighlighterKeys.COMMA),
			new AttributesDescriptor("Bad characters", FenomSyntaxHighlighterKeys.BAD_CHARACTER),
	};

	@Nonnull
	@Override
	public LocalizeValue getDisplayName()
	{
		return LocalizeValue.localizeTODO("Fenom");
	}

	@Nonnull
	@Override
	public AttributesDescriptor[] getAttributeDescriptors()
	{
		return ATTRS;
	}

	@Nonnull
	@Override
	public SyntaxHighlighter getHighlighter()
	{
		return new FenomSyntaxHighlighter();
	}

	@Nonnull
	@Override
	public String getDemoText()
	{
		return "{* Comment *}\n<h1>Welcome</h1>\n\n{if $user?}\n\t$user.name\n{/if}\n";
	}
}