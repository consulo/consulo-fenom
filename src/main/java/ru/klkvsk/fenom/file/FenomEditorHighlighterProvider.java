package ru.klkvsk.fenom.file;

import consulo.annotation.component.ExtensionImpl;
import consulo.codeEditor.EditorHighlighter;
import consulo.colorScheme.EditorColorsScheme;
import consulo.language.editor.highlight.EditorHighlighterProvider;
import consulo.project.Project;
import consulo.virtualFileSystem.VirtualFile;
import consulo.virtualFileSystem.fileType.FileType;
import jakarta.annotation.Nullable;
import ru.klkvsk.fenom.editor.FenomTemplateHighlighter;

import jakarta.annotation.Nonnull;

/**
 * @author VISTALL
 * @since 2019-02-27
 */
@ExtensionImpl
public class FenomEditorHighlighterProvider implements EditorHighlighterProvider
{
	@Nonnull
	@Override
	public EditorHighlighter getEditorHighlighter(@Nullable Project project, @Nonnull FileType fileType, @Nullable VirtualFile virtualFile, @Nonnull EditorColorsScheme colors)
	{
		return new FenomTemplateHighlighter(project, virtualFile, colors);
	}

	@Nonnull
	@Override
	public FileType getFileType()
	{
		return FenomFileType.INSTANCE;
	}
}
