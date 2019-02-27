package ru.klkvsk.fenom.editor;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import com.intellij.ide.highlighter.HtmlFileType;
import com.intellij.lang.Language;
import com.intellij.openapi.editor.colors.EditorColorsScheme;
import com.intellij.openapi.editor.ex.util.LayerDescriptor;
import com.intellij.openapi.editor.ex.util.LayeredLexerEditorHighlighter;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.fileTypes.PlainTextFileType;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.templateLanguages.TemplateDataLanguageMappings;
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