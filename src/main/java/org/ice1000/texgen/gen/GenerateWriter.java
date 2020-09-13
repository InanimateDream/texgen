package org.ice1000.texgen.gen;

import org.ice1000.texgen.code.Token;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.Writer;
import java.util.stream.Stream;

/**
 * Generate a single file, doesn't write to file but a {@link Writer}.
 * Reads tokens from a {@link Stream} of {@link Token}s,
 * according to a given {@link GenConfig}.
 */
public class GenerateWriter {
  public void gen(@NotNull Writer writer, @NotNull Stream<@NotNull ? extends Token> tokens, @NotNull GenConfig config) throws IOException {
    var res = tokens.reduce("", (acc, tk) ->
      acc + config.teXConfig.basicConvertor.apply(tk).toCode().toString()
    , String::concat);
    writer.write(res);
  }
}
