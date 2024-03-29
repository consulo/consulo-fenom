package ru.klkvsk.fenom.file;

import jakarta.annotation.Nonnull;

import jakarta.annotation.Nullable;

import consulo.fenom.icon.FenomIconGroup;
import consulo.language.file.LanguageFileType;
import consulo.localize.LocalizeValue;
import consulo.ui.image.Image;
import ru.klkvsk.fenom.FenomLanguage;

public class FenomFileType extends LanguageFileType
{
	public static final FenomFileType INSTANCE = new FenomFileType();

	private FenomFileType()
	{
		super(FenomLanguage.INSTANCE);
	}

	@Nonnull
	@Override
	public String getId()
	{
		return "Fenom template";
	}

	@Nonnull
	@Override
	public LocalizeValue getDescription()
	{
		return LocalizeValue.localizeTODO("Fenom template");
	}

	@Nonnull
	@Override
	public String getDefaultExtension()
	{
		return "fm";
	}

	@Nullable
	@Override
	public Image getIcon()
	{
		return FenomIconGroup.filetype_icon();
	}
}