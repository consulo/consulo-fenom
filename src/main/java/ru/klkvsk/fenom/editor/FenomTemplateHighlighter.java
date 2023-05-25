package ru.klkvsk.fenom.editor;

import consulo.colorScheme.EditorColorsScheme;
import consulo.language.Language;
import consulo.language.editor.highlight.LayerDescriptor;
import consulo.language.editor.highlight.LayeredLexerEditorHighlighter;
import consulo.language.editor.highlight.SyntaxHighlighter;
import consulo.language.editor.highlight.SyntaxHighlighterFactory;
import consulo.language.plain.PlainTextFileType;
import consulo.language.template.TemplateDataLanguageMappings;
import consulo.project.Project;
import consulo.virtualFileSystem.VirtualFile;
import consulo.virtualFileSystem.fileType.FileType;
import consulo.xml.ide.highlighter.HtmlFileType;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import ru.klkvsk.fenom.psi.FenomTypes;

/**
 * Layered highlighter - uses FenomSyntaxHighlighter as main one, and second for outer text (HTML)
 */
public class FenomTemplateHighlighter extends LayeredLexerEditorHighlighter
{
	public FenomTemplateHighlighter(@Nullable Project project, @Nullable VirtualFile virtualFile, @Nonnull EditorColorsScheme colors)
	{
		// create main highlighter
		super(new FenomSyntaxHighlighter(), colors);

		// highlighter for outer lang
		FileType type = null;
		if(project == null || virtualFile == null)
		{
			type = PlainTextFileType.INSTANCE;
		}
		else
		{
			Language language = TemplateDataLanguageMappings.getInstance(project).getMapping(virtualFile);
			if(language != null)
			{
				type = language.getAssociatedFileType();
			}
			if(type == null)
			{
				type = HtmlFileType.INSTANCE;
			}
		}
		SyntaxHighlighter outerHighlighter = SyntaxHighlighterFactory.getSyntaxHighlighter(type, project, virtualFile);

		registerLayer(FenomTypes.TEMPLATE_HTML_TEXT, new LayerDescriptor(outerHighlighter, ""));
	}
}