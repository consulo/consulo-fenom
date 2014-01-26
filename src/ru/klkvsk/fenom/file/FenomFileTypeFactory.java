package ru.klkvsk.fenom.file;

import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;

public class FenomFileTypeFactory extends FileTypeFactory
{
	@Override
	public void createFileTypes(@NotNull FileTypeConsumer fileTypeConsumer)
	{
		fileTypeConsumer.consume(FenomFileType.INSTANCE, "fm");
	}
}