package org.ice1000.texgen;

import org.ice1000.texgen.code.Token;
import org.ice1000.texgen.code.LayoutPolicy;
import org.ice1000.texgen.gen.GenConfig;
import org.ice1000.texgen.gen.Generator;
import org.ice1000.texgen.tex.InlineComponent;
import org.ice1000.texgen.tex.PlainText;
import org.ice1000.texgen.gen.TeXConfig;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

public class TestMain {
  @Test
  public void simpleTest() throws IOException {
    Optional<InlineComponent> none = Optional.empty();

    // \func Sphere (n : Nat) : \Type \lp \oo
    //    | 0 => Susp Empty
    //    | suc n => Susp (Sphere n)
    var testTokens = List.of(
      new Token("keyword", LayoutPolicy.BOX, "\\func", Optional.of(new PlainText("func"))),
      new Token("identifier", LayoutPolicy.BOX, "Sphere", Optional.of(new PlainText("\\mathcal{S}"))),
      new Token("delimiter", LayoutPolicy.DELIMITER, "(", none),
      new Token("identifier", LayoutPolicy.BOX, "n", none),
      new Token("operator", LayoutPolicy.OPERATOR, ":", none),
      new Token("identifier", LayoutPolicy.BOX, "Nat", none),
      new Token("delimiter", LayoutPolicy.DELIMITER, ")", none),
      new Token("operator", LayoutPolicy.OPERATOR, ":", none),
      new Token("keyword", LayoutPolicy.BOX, "\\Type", Optional.of(new PlainText("\\mathcal{U}"))),
      new Token("keyword", LayoutPolicy.BOX, "\\lp", Optional.of(new PlainText("lp"))),
      new Token("keyword", LayoutPolicy.BOX, "\\oo", Optional.of(new PlainText("\\infty"))),
      new Token(
        "indentator",
        new LayoutPolicy(false, false, false, true, false, true),
        "|",
        Optional.of(new PlainText("\\\\\\quad"))),
      new Token("literal", LayoutPolicy.BOX, "0", none),
      new Token("operator", LayoutPolicy.OPERATOR, "=>", Optional.of(new PlainText("\\Rightarrow"))),
      new Token("identifier", LayoutPolicy.BOX, "Susp", none),
      new Token("identifier", LayoutPolicy.BOX, "Empty", none),
      new Token(
        "indentator",
        new LayoutPolicy(false, false, false, true, false, true),
        "|",
        Optional.of(new PlainText("\\\\\\quad"))),
      new Token("identifier", LayoutPolicy.BOX, "suc", none),
      new Token("identifier", LayoutPolicy.BOX, "n", none),
      new Token("operator", LayoutPolicy.OPERATOR, "=>", Optional.of(new PlainText("\\Rightarrow"))),
      new Token("identifier", LayoutPolicy.BOX, "Susp", none),
      new Token("delimiter", LayoutPolicy.DELIMITER, "(", none),
      new Token("identifier", LayoutPolicy.BOX, "Sphere", Optional.of(new PlainText("\\mathcal{S}"))),
      new Token("identifier", LayoutPolicy.BOX, "n", none),
      new Token("delimiter", LayoutPolicy.DELIMITER, ")", none)
    );

    var teXConfig = new TeXConfig();
    // teXConfig.basicConvertor = tk -> FontStyle.TypeWriter.inline(new PlainText(tk.getContent()));

    var genConfig = new GenConfig();
    genConfig.teXConfig = teXConfig;

    var gen = new Generator(Paths.get("build"), genConfig);
    gen.gen("test.tex", testTokens.stream());
    gen.gen("test2.tex", testTokens.stream());
  }
}
