package org.ice1000.texgen;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class TestMain {
  @Test
  public void simpleTest() throws IOException {
    var testTokens = List.of(
      Token.from("line1", Attribute.DEFAULT),
      Token.from("\n", Attribute.DEFAULT),
      Token.from("line2", Attribute.DEFAULT)
    );
    var gen = new Generator(Paths.get("build"), new GenConfig());
    gen.gen("test.tex", testTokens.stream());
    gen.gen("test2.tex", testTokens.stream());
    System.out.println(114514);
  }
}
