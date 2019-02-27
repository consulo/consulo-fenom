package ru.klkvsk.fenom.file;

import javax.annotation.Nonnull;

import javax.annotation.Nullable;
import com.intellij.openapi.editor.colors.EditorColorsScheme;
import com.intellij.openapi.editor.highlighter.EditorHighlighter;
import com.intellij.openapi.fileTypes.EditorHighlighterProvider;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.fileTypes.FileTypeEditorHighlighterProviders;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import consulo.ui.image.Image;
import ru.klkvsk.fenom.FenomLanguage;
import ru.klkvsk.fenom.editor.FenomTemplateHighlighter;

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
	public String getDescription()
	{
		return "Fenom template";
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
		return FenomIcons.FILE;
	}
}