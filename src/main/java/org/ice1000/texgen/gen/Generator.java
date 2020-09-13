package org.ice1000.texgen.gen;

import org.ice1000.texgen.code.Token;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Generator {
  private final @NotNull Path root;
  private final @NotNull GenConfig config;
  private final @NotNull GenerateWriter writer = new GenerateWriter();

  public Generator(@NotNull Path root, @NotNull GenConfig config) {
    this.root = root;
    this.config = config;
  }

  public void gen(@NotNull String fileName, @NotNull Stream<@NotNull ? extends Token> tokens) throws IOException {
    var path = root.resolve(fileName);
    if (Files.exists(path) && !config.overwrite) {
      throw new FileAlreadyExistsException(path.toString());
    }
    try (var w = Files.newBufferedWriter(path)) {
      writer.gen(w, tokens, config);
    }
  }
}
