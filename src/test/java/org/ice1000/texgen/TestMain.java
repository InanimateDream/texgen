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
import java.util.Map;
import java.util.Optional;

public class TestMain {
  @Test
  public void simpleTest() throws IOException {
    Optional<InlineComponent> none = Optional.empty();

    var builder = new Token.Builder(Map.of(
      "literal", LayoutPolicy.BOX,
      "keyword", LayoutPolicy.BOX,
      "identifier", LayoutPolicy.BOX,
      "delimiter", LayoutPolicy.DELIMITER,
      "operator", LayoutPolicy.OPERATOR
    ));

    // \func Sphere (n : Nat) : \Type \lp \oo
    //    | 0 => Susp Empty
    //    | suc n => Susp (Sphere n)
    var testTokens = List.of(
      builder.build("keyword", "\\func", Optional.of(new PlainText("func"))),
      builder.build("identifier", "Sphere", Optional.of(new PlainText("\\mathcal{S}"))),
      builder.build("delimiter", "(", none),
      builder.build("identifier", "n", none),
      builder.build("operator", ":", none),
      builder.build("identifier", "Nat", Optional.of(new PlainText("\\mathbb{N}"))),
      builder.build("delimiter", ")", none),
      builder.build("operator", ":", none),
      builder.build("keyword", "\\Type", Optional.of(new PlainText("\\mathcal{U}"))),
      builder.build("keyword", "\\lp", Optional.of(new PlainText("lp"))),
      builder.build("keyword", "\\oo", Optional.of(new PlainText("\\infty"))),
      builder.cons(
        "indentator",
        new LayoutPolicy(false, false, false, true, false, true),
        "|",
        Optional.of(new PlainText("\\\\\n\\quad"))),
      builder.build("literal", "0", none),
      builder.build("operator", "=>", Optional.of(new PlainText("\\Rightarrow"))),
      builder.build("identifier", "Susp", none),
      builder.build("identifier", "Empty", none),
      builder.cons(
        "indentator",
        new LayoutPolicy(false, false, false, true, false, true),
        "|",
        Optional.of(new PlainText("\\\\\n\\quad"))),
      builder.build("identifier", "suc", none),
      builder.build("identifier", "n", none),
      builder.build("operator", "=>", Optional.of(new PlainText("\\Rightarrow"))),
      builder.build("identifier", "Susp", none),
      builder.build("delimiter", "(", none),
      builder.build("identifier", "Sphere", Optional.of(new PlainText("\\mathcal{S}"))),
      builder.build("identifier", "n", none),
      builder.build("delimiter", ")", none)
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
