package ru.klkvsk.fenom.file;

import consulo.annotation.component.ExtensionImpl;
import jakarta.annotation.Nonnull;
import consulo.virtualFileSystem.fileType.FileTypeConsumer;
import consulo.virtualFileSystem.fileType.FileTypeFactory;

@ExtensionImpl
public class FenomFileTypeFactory extends FileTypeFactory
{
	@Override
	public void createFileTypes(@Nonnull FileTypeConsumer fileTypeConsumer)
	{
		fileTypeConsumer.consume(FenomFileType.INSTANCE, "fm");
	}
}