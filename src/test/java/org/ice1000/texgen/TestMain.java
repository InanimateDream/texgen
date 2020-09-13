package org.ice1000.texgen;

import org.ice1000.texgen.code.BlankToken;
import org.ice1000.texgen.code.IdentifierToken;
import org.ice1000.texgen.gen.GenConfig;
import org.ice1000.texgen.gen.Generator;
import org.ice1000.texgen.tex.FontStyle;
import org.ice1000.texgen.tex.InlineComponent;
import org.ice1000.texgen.tex.PlainText;
import org.ice1000.texgen.tex.TeXConfig;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

public class TestMain {
  @Test
  public void simpleTest() throws IOException {
    Optional<InlineComponent> none = Optional.empty();

    var testTokens = List.of(
      new IdentifierToken("line1", none),
      new BlankToken("\n", none),
      new IdentifierToken("line2", none)
    );

    var teXConfig = new TeXConfig();
    teXConfig.basicConvertor = tk -> FontStyle.TypeWriter.inline(new PlainText(tk.getContent()));

    var genConfig = new GenConfig();
    genConfig.teXConfig = teXConfig;

    var gen = new Generator(Paths.get("build"), genConfig);
    gen.gen("test.tex", testTokens.stream());
    gen.gen("test2.tex", testTokens.stream());
  }
}
