package ru.klkvsk.fenom.editor;

import java.util.Map;

import javax.swing.Icon;

import javax.annotation.Nonnull;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;

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
	public String getDisplayName()
	{
		return "Fenom";
	}

	@Override
	public Icon getIcon()
	{
		return null;
	}

	@Nonnull
	@Override
	public AttributesDescriptor[] getAttributeDescriptors()
	{
		return ATTRS;
	}

	@Nonnull
	@Override
	public ColorDescriptor[] getColorDescriptors()
	{
		return new ColorDescriptor[0];
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

	@Override
	public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap()
	{
		return null;
	}
}