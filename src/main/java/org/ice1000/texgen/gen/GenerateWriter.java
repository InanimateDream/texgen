package org.ice1000.texgen.gen;

import org.ice1000.texgen.code.Token;
import org.ice1000.texgen.tex.TeXComponent;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.Writer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Generate a single file, doesn't write to file but a {@link Writer}.
 * Reads tokens from a {@link Stream} of {@link Token}s,
 * according to a given {@link GenConfig}.
 */
public class GenerateWriter {
  public void gen(
    @NotNull Writer writer,
    @NotNull Stream<@NotNull Token> tokens,
    @NotNull GenConfig config
  ) throws IOException {
    var res = tokens
      .map(config.teXConfig.basicConvertor)
      .map(TeXComponent::toCode)
      .collect(Collectors.joining(" "));
    writer.write(res);
  }
}
