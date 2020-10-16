package org.ice1000.texgen.tex;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class Tabbing implements TeXEnvironment {

  @Contract(pure = true)
  private @NotNull ComponentCreator creator() {
    return comp -> String.format("\\begin{tabbing}\n%s\n\\end{tabbing}", comp.toCode());
  }

  public @NotNull BlockComponent create(@NotNull TeXComponent comp) {
    return (BlockComponent) creator().visitBlockComponent(comp.lift());
  }
}
