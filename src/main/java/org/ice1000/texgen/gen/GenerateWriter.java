package org.ice1000.texgen.gen;

import org.ice1000.texgen.code.Token;
import org.ice1000.texgen.tex.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.Writer;
import java.util.Stack;
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
    var page = new Stack<Stack<InlineComponent>>();
    page.push(new Stack<>());

    var tks = tokens
      .reduce(page, (acc, tk) -> {
        if(tk.getLayoutPolicy().indentator) {
          var newLine = new Stack<InlineComponent>();
          acc.push(newLine);
        } else {
          var currentLine = acc.pop();
          currentLine.push(config.teXConfig.basicConvertor.apply(tk));
          acc.push(currentLine);
        }
        return acc;
      }, (u, v) -> u) // Sequential Stream
      .stream()
      .map(line -> new Join(line.stream(), InlineSpace.PLAINSPACE));

    var res = (new Tabbing())
      .create(new Join(tks, new PlainText(" \\\\\n\\quad ")))
      .toCode()
      .toString();

    writer.write(res);
  }
}
